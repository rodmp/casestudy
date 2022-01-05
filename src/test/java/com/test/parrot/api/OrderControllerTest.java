/*
 * Parrot.
 */

package com.test.parrot.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.test.parrot.model.OrderRequest;
import com.test.parrot.service.OrderService;

/**
 * 
 * @author parrot.
 *
 */
@ExtendWith(SpringExtension.class)
public class OrderControllerTest {

  /**
   * 
   */
  @InjectMocks
  private OrderController orderController;

  /**
   * 
   */
  @Mock
  private OrderService orderService;

  @Test
  public void createOrder() {
    OrderRequest orderRequest = mock(OrderRequest.class);

    doNothing().when(this.orderService).createOrder(orderRequest);

    assertEquals(HttpStatus.CREATED,
        this.orderController.createOrders(orderRequest).getStatusCode());
  }
}
