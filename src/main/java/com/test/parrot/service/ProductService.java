/*
 * Parrot.
 */

package com.test.parrot.service;

import java.util.Optional;
import javax.validation.Valid;
import com.test.parrot.domain.Product;
import com.test.parrot.model.ProductRequest;
import com.test.parrot.model.ProductResponse;

/**
 * Contract interface Product service class.
 * 
 * @author parrot.
 *
 */
public interface ProductService {

  /**
   * Find all products method. Two parameters are received for pagination, one the page size and two
   * the page number.
   * 
   * @param page
   * @param size
   * @return
   */
  ProductResponse findAllProducts(Optional<Integer> page, Optional<Integer> size);

  /**
   * Create new product method.
   * 
   * @param productRequest ProductRequest object info requested.
   */
  void createProduct(@Valid ProductRequest productRequest);

  /**
   * Method to find product by id.
   *  
   * @param id Product identifier.
   * @return Product found.
   */
  Product findByProductId(Long id);

  /**
   * Method to update product availability.
   * 
   * @param newStock new quantity to save.
   * @param product Product to update stock.
   */
  void updateProductStok(Integer newStock, Product product);
}
