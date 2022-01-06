/*
 * Parrot.
 */

package com.test.parrot.model;

import java.math.BigDecimal;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Product request definition class.
 * 
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
   * Product name.
   */
  @NotEmpty(message = "Please enter name")
  private String name;

  /**
   * Product price.
   */
  @NotNull(message = "Please enter price")
  private BigDecimal price;

  /**
   * Product stock.
   */
  @NotNull(message = "Please enter stock")
  private Integer stock;
}
