/*
 * Parrot.
 */

package com.test.parrot.model;

import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * User request definition.
 * 
 * @author parrot.
 *
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderRequest {

  /**
   * 
   */
  private Long clientId;
  
  /**
   * 
   */
  private BigDecimal total;
  
  /**
   * 
   */
  private List<OrderItemRequest> products;
}
