/*
 * Parrot.
 */

package com.test.parrot.service;

import com.test.parrot.model.OrderRequest;

public interface OrderService {

  /**
   * Create order method.
   * @param orderRequest
   */
  void createOrder(OrderRequest orderRequest);
}
