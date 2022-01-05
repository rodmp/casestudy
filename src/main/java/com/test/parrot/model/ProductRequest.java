/*
 * Parrot.
 */

package com.test.parrot.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Clase modelo para la solicitud de productos.
 * @author parrot.
 *
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductRequest {

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
