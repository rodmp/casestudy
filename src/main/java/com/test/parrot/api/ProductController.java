/*
 * Parrot.
 */

package com.test.parrot.api;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.test.parrot.constant.Constants;
import com.test.parrot.model.ProductRequest;
import com.test.parrot.model.ProductResponse;
import com.test.parrot.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

/**
 * Product controller class.
 * 
 * @author parrot.
 *
 */
@Slf4j
@RequestMapping(Constants.BASE_PATH)
@RestController
public class ProductController {

  /**
   * ProductService variable.
   */
  private final ProductService productService;

  /**
   * ProductController constructor.
   * 
   * @param productService ProductService object.
   */
  public ProductController(final ProductService productService) {
    this.productService = productService;
  }

  /**
   * Get entry point method to get all products.
   * 
   * @param page Actual request page.
   * @param size Size of page to request.
   * @return ProductResponse object.
   */
  @ApiOperation(value = Constants.API_RESOURCES_NAME_PRODUCT_FIND,
      produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiResponses(value = {@ApiResponse(code = Constants.CODE_OK, message = Constants.OK),
      @ApiResponse(code = Constants.CODE_BAD_REQUEST, message = Constants.BAD_REQUEST),
      @ApiResponse(code = Constants.CODE_INTERNAL_ERROR, message = Constants.INTERNAL_ERROR)})

  @GetMapping(value = Constants.GET_MAPPING_RESOURCE_PRODUCTS,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ProductResponse> getProducts(@RequestParam("page") Optional<Integer> page,
      @RequestParam("size") Optional<Integer> size) {
    log.debug(Constants.END_REQUEST);
    return new ResponseEntity<>(this.productService.findAllProducts(page, size), HttpStatus.OK);
  }

  /**
   * Post entry point method to create new products.
   * 
   * @param productRequest ProductRequest object.
   * @return void.
   */
  @ApiOperation(value = Constants.API_RESOURCES_NAME_PRODUCT_CREATE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiResponses(value = {@ApiResponse(code = Constants.CODE_OK, message = Constants.OK),
      @ApiResponse(code = Constants.CODE_BAD_REQUEST, message = Constants.BAD_REQUEST),
      @ApiResponse(code = Constants.CODE_INTERNAL_ERROR, message = Constants.INTERNAL_ERROR)})

  @PostMapping(value = Constants.GET_MAPPING_RESOURCE_PRODUCTS,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> createProduct(
      @Valid @Validated @RequestBody ProductRequest productRequest) {

    this.productService.createProduct(productRequest);
    log.debug(Constants.END_REQUEST, productRequest);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
}
