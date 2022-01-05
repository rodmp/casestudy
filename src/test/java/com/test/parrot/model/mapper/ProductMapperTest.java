/*
 * Parrot.
 */

package com.test.parrot.model.mapper;

import static org.junit.Assert.assertNotNull;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.test.parrot.domain.Product;

/**
 * 
 * @author parrot.
 *
 */
@ExtendWith(SpringExtension.class)
public class ProductMapperTest {

  /**
   * 
   */
  @InjectMocks
  private ProductMapper productMapper;
  
  @Test
  public void productToProductDto() {
    Product product = new Product();
    product.setId(1l);
    product.setName("user1");
    product.setPrice(BigDecimal.valueOf(34));
    product.setStock(2);
    
    assertNotNull(this.productMapper.productToProductDto(product));
  }
}
