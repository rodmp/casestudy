/*
 * Parrot.
 */

package com.test.parrot.business;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.parrot.domain.Product;
import com.test.parrot.exceptions.custom.BadRequestException;
import com.test.parrot.exceptions.custom.NotDataFoundException;
import com.test.parrot.repository.ProductRepository;

/**
 * 
 * @author parrot.
 *
 */
@ExtendWith(SpringExtension.class)
public class ReportBusinessTest {

  /**
   * 
   */
  @InjectMocks
  private ReportBusiness reportBusiness;

  /**
   * 
   */
  @Mock
  private ProductRepository orderRepository;

  @Test
  public void generateReportTest() throws Exception {

    List<Product> products = this.generateListProducts();
    Pageable pageable = PageRequest.of(2, 2);
    Page<Product> list = new PageImpl<>(products, pageable, 6);

    when(this.orderRepository.findByTransactionDateBetween(Mockito.any(), Mockito.any(),
        Mockito.any(Pageable.class))).thenReturn(list);
    
    this.reportBusiness.generateReport(Optional.of(2), Optional.of(2),
        Optional.of(LocalDate.of(2022, 01, 05)), Optional.of(LocalDate.of(2022, 01, 05)));
  }

  /**
   * 
   * @throws Exception
   */
  @Test
  public void generateReportPageEmpty() throws Exception {

    assertThrows(BadRequestException.class,
        () -> this.reportBusiness.generateReport(Optional.empty(), Optional.of(2),
            Optional.of(LocalDate.of(2022, 01, 05)), Optional.of(LocalDate.of(2022, 01, 05))));
  }

  /**
   * 
   * @throws Exception
   */
  @Test
  public void findAllProductsTestPageNull() throws Exception {
    List<Product> products = List.of();
    Pageable pageable = PageRequest.of(2, 2);
    Page<Product> list = new PageImpl<>(products, pageable, 6);

    when(this.orderRepository.findByTransactionDateBetween(Mockito.any(), Mockito.any(),
        Mockito.any(Pageable.class))).thenReturn(list);

    assertThrows(NotDataFoundException.class,
        () -> this.reportBusiness.generateReport(Optional.of(2), Optional.of(2),
            Optional.of(LocalDate.of(2022, 01, 05)), Optional.of(LocalDate.of(2022, 01, 05))));

  }

  /**
   * 
   */
  private List<Product> generateListProducts()
      throws JsonMappingException, JsonProcessingException {

    String json =
        "[{\"id\":5,\"name\":\"sacapuntas\",\"price\":5.00,\"stock\":245},{\"id\":6,\"name\":\"Pegamento\",\"price\":10.50,\"stock\":50}]";
    return new ObjectMapper().readValue(json, new TypeReference<List<Product>>() {});
  }
}
