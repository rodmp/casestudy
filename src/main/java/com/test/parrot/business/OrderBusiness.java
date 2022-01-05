/*
 * Parrot.
 */

package com.test.parrot.business;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.test.parrot.constant.MessageConstant;
import com.test.parrot.domain.Client;
import com.test.parrot.domain.OrderItem;
import com.test.parrot.domain.Orders;
import com.test.parrot.domain.Product;
import com.test.parrot.exceptions.custom.BadRequestException;
import com.test.parrot.model.OrderItemRequest;
import com.test.parrot.model.OrderRequest;
import com.test.parrot.repository.OrderRepository;
import com.test.parrot.service.ClientService;
import com.test.parrot.service.OrderService;
import com.test.parrot.service.ProductService;
import lombok.extern.slf4j.Slf4j;

/**
 * Order business class definition. This class contains main functionality, this is create new
 * orders.
 * 
 * @author parrot.
 *
 */
@Slf4j
@Service
public class OrderBusiness implements OrderService {

  /**
   * ClientService variable.
   */
  private final ClientService clientService;

  /**
   * ProductService variable.
   */
  private final ProductService productService;

  /**
   * OrderRepository variable.
   */
  private final OrderRepository orderRepository;

  /**
   * OrderBusiness constructor.
   * 
   * @param clientService ClientService reference.
   * @param orderRepository OrderRepository reference.
   * @param productService ProductService reference.
   */
  public OrderBusiness(final ClientService clientService, final OrderRepository orderRepository,
      final ProductService productService) {
    this.clientService = clientService;
    this.orderRepository = orderRepository;
    this.productService = productService;
  }

  /**
   * {@inheritDoc}
   */
  @Transactional
  @Override
  public void createOrder(OrderRequest orderRequest) {
    Client client = this.clientService.findClientById(orderRequest.getClientId());

    synchronized (this) {
      Orders order = new Orders();
      order.setClient(client);
      order.setTransactionDate(LocalDate.now());
      order.setTotal(orderRequest.getTotal());
      order.setProducts(orderRequest.getProducts().stream()
          .map(orderItem -> this.createItem(orderItem, order)).collect(Collectors.toSet()));

      log.debug(MessageConstant.ORDER_TO_SAVE, order);

      this.orderRepository.save(order);
    }
  }

  /**
   * Private method to create new order item, This method verifies that there are enough products in
   * stock, if there are not, an exception is sent, and the database is updated with the products
   * sold.
   * 
   * @param orderItemRequest
   * @param order
   * @return
   */
  private OrderItem createItem(OrderItemRequest orderItemRequest, Orders order) {

    Product product = this.productService.findByProductId(orderItemRequest.getId());

    if (product.getStock() < orderItemRequest.getQuantity()) {
      throw new BadRequestException(String.format(MessageConstant.NOT_STOCK, product.getName()),
          List.of(product.getName(), product.getStock().toString()));
    }

    OrderItem orderItem = new OrderItem();
    orderItem.setQuantity(orderItemRequest.getQuantity());
    orderItem.setProduct(product);
    orderItem.setOrder(order);

    this.productService.updateProductStok(product.getStock() - orderItemRequest.getQuantity(),
        product);
    return orderItem;
  }
}
