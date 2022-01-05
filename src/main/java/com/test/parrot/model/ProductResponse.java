/*
 * Parrot.
 */

package com.test.parrot.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase entidad de productos para la respuesta.
 * @author parrot.
 *
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

  /**
   * 
   */
  private List<ProductDto> products;
  
  /**
   * 
   */
  private Integer totalPages;
  
  /**
   * 
   */
  private Integer currentPage;
  
  /**
   * 
   */
  private Long totalItems;
}
