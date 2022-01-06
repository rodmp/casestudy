/*
 * Parrot.
 */


package com.test.parrot.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Product dto definition class.
 * 
 * @author parrot.
 *
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

  /**
   * Product identifier.
   */
  private Long id;

  /**
   * Product name.
   */
  private String name;

  /**
   * Product price.
   */
  private BigDecimal price;

  /**
   * Product stock.
   */
  private Integer stock;
}
