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
 * Reponse Product definition class.
 * 
 * @author parrot.
 *
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

  /**
   * List of product dto.
   */
  private List<ProductDto> products;
  
  /**
   * Total pagination pages.
   */
  private Integer totalPages;
  
  /**
   * Current page.
   */
  private Integer currentPage;
  
  /**
   * Total  items.
   */
  private Long totalItems;
}
