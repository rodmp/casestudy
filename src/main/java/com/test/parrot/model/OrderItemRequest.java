package com.test.parrot.model;

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
public class OrderItemRequest {

  /**
   * 
   */
  private Long id;

  /**
   * 
   */
  private Integer quantity;
}
