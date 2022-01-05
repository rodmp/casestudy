/*
 * Parrot.
 */

package com.test.parrot.model.mapper;

import org.springframework.stereotype.Component;
import com.test.parrot.domain.Product;
import com.test.parrot.model.ProductDto;

/**
 * 
 * @author parrot.
 *
 */
@Component
public class ProductMapper {

  /**
   * 
   * @param product
   * @return
   */
  public ProductDto productToProductDto(Product product) {
    ProductDto productDto = new ProductDto();
    
    productDto.setId(product.getId());
    productDto.setName(product.getName());
    productDto.setPrice(product.getPrice());
    productDto.setStock(product.getStock());
    
    return productDto;
  }
}
