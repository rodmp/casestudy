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
   * 
   */
  private Long id;

  /**
   * 
   */
  private String name;

  /**
   * 
   */
  private BigDecimal price;

  /**
   * 
   */
  private Integer stock;
}
