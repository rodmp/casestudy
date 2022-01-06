/*
 * Parrot.
 */

package com.test.parrot.service;

import com.test.parrot.model.OrderRequest;

/**
 * Contract interface Order service class.
 * 
 * @author parrot.
 *
 */
public interface OrderService {

  /**
   * Create new orders method. This method uses block synchronization to prevent two requests from
   * entering the same resource and losing control of the storage of available products.
   * 
   * If all operations is correct, save the order and orderitems requested.
   * 
   * @param orderRequest OrderRequest object, contains infor to create new order.
   */
  void createOrder(OrderRequest orderRequest);
}
