/*
 * Parrot.
 */

package com.test.parrot.service;

import java.util.Optional;
import javax.validation.Valid;
import com.test.parrot.domain.Product;
import com.test.parrot.model.ProductRequest;
import com.test.parrot.model.ProductResponse;

public interface ProductService {

  /**
   * 
   * @param page
   * @param size
   * @return
   */
  ProductResponse findAllProducts(Optional<Integer> page, Optional<Integer> size);

  /**
   * 
   * @param productRequest
   */
  void createProduct(@Valid ProductRequest productRequest);

  /**
   * 
   * @param id
   * @return
   */
  Product findByProductId(Long id);
  
  /**
   * 
   * @param sale
   * @param product
   */
  void updateProductStok(Integer sale, Product product);
}
