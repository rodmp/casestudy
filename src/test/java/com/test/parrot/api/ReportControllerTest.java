/*
 * Parrot.
 */

package com.test.parrot.api;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.parrot.model.ProductReportResponse;
import com.test.parrot.service.ReportService;

/**
 * 
 * @author parrot.
 *
 */
@ExtendWith(SpringExtension.class)
public class ReportControllerTest {

  /**
   * 
   */
  @InjectMocks
  private ReportController reportController;

  /**
   * 
   */
  @Mock
  private ReportService reportService;

  /**
   * 
   * @throws Exception
   */
  @Test
  public void generateReport() throws Exception {

    ProductReportResponse productReportResponse = this.generateProductReportResponse();
    when(this.reportService.generateReport(Mockito.any(), Mockito.any(), Mockito.any(),
        Mockito.any())).thenReturn(productReportResponse);

    assertNotNull(this.reportController.generateReport(Optional.of(0), Optional.of(4),
        Optional.of(LocalDate.of(2022, 01, 04)), Optional.of(LocalDate.of(2022, 01, 04))));
  }

  /**
   * 
   * @return
   * @throws JsonMappingException
   * @throws JsonProcessingException
   */
  private ProductReportResponse generateProductReportResponse()
      throws JsonMappingException, JsonProcessingException {

    String json =
        "{\"startDate\":\"2022-01-03\",\"endDate\":\"2022-01-04\",\"products\":[{\"name\":\"lapiz\",\"quantity\":10,\"total\":60.00},{\"name\":\"pluma\",\"quantity\":8,\"total\":40.00},{\"name\":\"sacapuntas\",\"quantity\":6,\"total\":30.00},{\"name\":\"regla\",\"quantity\":4,\"total\":16.00},{\"name\":\"goma\",\"quantity\":3,\"total\":15.00}],\"totalPages\":1,\"currentPage\":0,\"totalItems\":5}";
    return new ObjectMapper().readValue(json, ProductReportResponse.class);
  }
}
