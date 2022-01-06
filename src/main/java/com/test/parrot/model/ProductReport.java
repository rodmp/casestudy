package com.test.parrot.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Product report definition class.
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
   * Product name.
   */
  private String name;

  /**
   * Product quantity order report.
   */
  private Integer quantity;

  /**
   * Products total order request.
   */
  private BigDecimal total;

}
