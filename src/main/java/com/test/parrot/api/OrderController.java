/*
 * Parrot.
 */

package com.test.parrot.api;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.test.parrot.constant.Constants;
import com.test.parrot.model.OrderRequest;
import com.test.parrot.service.OrderService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

/**
 * Order controller class.
 * @author parrot.
 *
 */
@Slf4j
@RequestMapping(Constants.BASE_PATH)
@RestController
public class OrderController {
  
  /**
   * OrderService variable.
   */
  private final OrderService orderService;
  
  /**
   * OrderController constructor.
   * @param orderService
   */
  public OrderController(final OrderService orderService) {
    this.orderService = orderService;
  }

  /**
   * Order entry point, create new orders.
   * @param orderRequest OrderRequest object.
   * @return void.
   */
  @ApiOperation(value = Constants.API_RESOURCES_NAME_ORDER_CREATE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiResponses(value = {@ApiResponse(code = Constants.CODE_OK, message = Constants.OK),
      @ApiResponse(code = Constants.CODE_BAD_REQUEST, message = Constants.BAD_REQUEST),
      @ApiResponse(code = Constants.CODE_INTERNAL_ERROR, message = Constants.INTERNAL_ERROR)})

  @PostMapping(value = Constants.GET_MAPPING_RESOURCE_ORDERS,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> createOrders(@Valid @RequestBody OrderRequest orderRequest) {

    this.orderService.createOrder(orderRequest);
    log.debug(Constants.END_REQUEST, orderRequest);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
}
