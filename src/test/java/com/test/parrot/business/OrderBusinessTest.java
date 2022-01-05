/*
 * Parrot.
 */

package com.test.parrot.business;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.parrot.domain.Client;
import com.test.parrot.domain.Product;
import com.test.parrot.exceptions.custom.BadRequestException;
import com.test.parrot.model.OrderRequest;
import com.test.parrot.repository.OrderRepository;
import com.test.parrot.service.ClientService;
import com.test.parrot.service.ProductService;

/**
 * Order business class test.
 * @author parrot.
 *
 */
@ExtendWith(SpringExtension.class)
public class OrderBusinessTest {

  /**
   * OrderBusiness variable.
   */
  @InjectMocks
  private OrderBusiness orderBusiness;

  /**
   * ClientService variable.
   */
  @Mock
  private ClientService clientService;

  /**
   * ProductService variable.
   */
  @Mock
  private ProductService productService;

  /**
   * OrderRepository variable.
   */
  @Mock
  private OrderRepository orderRepository;

  /**
   * 
   * @throws Exception
   */
  @Test
  public void createOrderTest() throws Exception {
    OrderRequest orderRequest = this.generateOrderRequest();

    Client client = new Client();
    client.setId(2l);
    client.setName("client1");

    Product product = new Product();
    product.setId(1l);
    product.setName("goma");
    product.setStock(4);

    when(this.clientService.findClientById(Mockito.anyLong())).thenReturn(client);

    when(this.productService.findByProductId(Mockito.anyLong())).thenReturn(product);

    this.orderBusiness.createOrder(orderRequest);
    assertNotNull(product);
  }

  /**
   * 
   * @throws Exception
   */
  @Test
  public void createOrderTestOutStock() throws Exception {
    OrderRequest orderRequest = this.generateOrderRequest();

    Client client = new Client();
    client.setId(2l);
    client.setName("client1");

    Product product = new Product();
    product.setId(1l);
    product.setName("goma");
    product.setStock(2);

    when(this.clientService.findClientById(Mockito.anyLong())).thenReturn(client);

    when(this.productService.findByProductId(Mockito.anyLong())).thenReturn(product);

    assertThrows(BadRequestException.class, () -> this.orderBusiness.createOrder(orderRequest));
  }

  /**
   * 
   * @return
   * @throws JsonMappingException
   * @throws JsonProcessingException
   */
  private OrderRequest generateOrderRequest() throws JsonMappingException, JsonProcessingException {

    String json = "{\"clientId\":1,\"total\":\"135.90\",\"products\":[{\"id\":2,\"quantity\":3}]}";
    return new ObjectMapper().readValue(json, OrderRequest.class);
  }
}
