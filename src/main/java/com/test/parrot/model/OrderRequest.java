/*
 * Parrot.
 */

package com.test.parrot.model;

import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotNull;
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
   * Order client identifier.
   */
  @NotNull(message = "Please enter client id")
  private Long clientId;

  /**
   * Total order request.
   */
  @NotNull(message = "Please enter total")
  private BigDecimal total;

  /**
   * List of order products.
   */
  @NotNull(message = "Please ente product items list")
  private List<OrderItemRequest> products;
}
