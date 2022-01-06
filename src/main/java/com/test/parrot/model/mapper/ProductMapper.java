/*
 * Parrot.
 */

package com.test.parrot.model.mapper;

import org.springframework.stereotype.Component;
import com.test.parrot.domain.Product;
import com.test.parrot.model.ProductDto;

/**
 * Product mapper class. Component helper to transform objects.
 * @author parrot.
 *
 */
@Component
public class ProductMapper {

  /**
   * Transform method, Product entity to ProductDto dto.
   * 
   * @param product Entity product.
   * @return ProductDto object.
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
