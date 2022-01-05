/*
 * Parrot.
 */

package com.test.parrot.api;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.parrot.model.ProductRequest;
import com.test.parrot.model.ProductResponse;
import com.test.parrot.service.ProductService;

/**
 * 
 * @author parrot.
 *
 */
@ExtendWith(SpringExtension.class)
public class ProductControllerTest {

  /**
   * 
   */
  @InjectMocks
  private ProductController productController;

  /**
   * 
   */
  @Mock
  private ProductService productService;

  /**
   * 
   * @throws Exception
   */
  @Test
  public void getProducts() throws Exception {
    ProductResponse productResponse = this.generateProductResponse();
    when(this.productService.findAllProducts(Mockito.any(), Mockito.any()))
        .thenReturn(productResponse);

    assertNotNull(this.productController.getProducts(Optional.of(0), Optional.of(3)));
  }

  /**
   * 
   */
  @Test
  public void createProduct() {
    ProductRequest productRequest = mock(ProductRequest.class);

    doNothing().when(this.productService).createProduct(productRequest);

    assertEquals(HttpStatus.CREATED,
        this.productController.createProduct(productRequest).getStatusCode());
  }

  /**
   * 
   * @return
   * @throws JsonMappingException
   * @throws JsonProcessingException
   */
  private ProductResponse generateProductResponse()
      throws JsonMappingException, JsonProcessingException {

    String json =
        "{\"products\":[{\"id\":5,\"name\":\"sacapuntas\",\"price\":5.00,\"stock\":245},{\"id\":6,\"name\":\"Pegamento\",\"price\":10.50,\"stock\":50}],\"totalPages\":3,\"currentPage\":2,\"totalItems\":6}";
    return new ObjectMapper().readValue(json, ProductResponse.class);
  }
}
