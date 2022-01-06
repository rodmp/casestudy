package com.test.parrot.model;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Order item request definition.
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
   * Order item identifier.
   */
  @NotNull(message = "Please enter id")
  private Long id;

  /**
   * Order item quantity request.
   */
  @NotNull(message = "Please enter quantity")
  private Integer quantity;
}
