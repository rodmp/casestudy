package com.test.parrot.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author parrot.
 *
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductReport {

  /**
   * 
   */
  private String name;
  
  /**
   * 
   */
  private Integer quantity;
  
  /**
   * 
   */
  private BigDecimal total;
  
}
