/*
 * Parrot.
 */

package com.test.parrot.api;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.test.parrot.constant.Constants;
import com.test.parrot.model.UserRequest;
import com.test.parrot.model.UserResponse;
import com.test.parrot.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

/**
 * User controller class.
 * 
 * @author parrot.
 *
 */
@RestController
@RequestMapping(Constants.BASE_PATH)
@Slf4j
public class UserController {

  /**
   * UserService variable.
   */
  private final UserService userService;

  /**
   * UserController constructor.
   * 
   * @param userService UserService instance.
   */
  public UserController(final UserService userService) {
    this.userService = userService;
  }

  /**
   * Get entry point method to get all users.
   * 
   * @param page Actual request page.
   * @param size Actual size of page.
   * @return UserResponse reference.
   */
  @ApiOperation(value = Constants.API_RESOURCES_NAME_USERS_FIND,
      produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiResponses(value = {@ApiResponse(code = Constants.CODE_OK, message = Constants.OK),
      @ApiResponse(code = Constants.CODE_BAD_REQUEST, message = Constants.BAD_REQUEST),
      @ApiResponse(code = Constants.CODE_INTERNAL_ERROR, message = Constants.INTERNAL_ERROR)})

  @GetMapping(value = Constants.GET_MAPPING_RESOURCE_USERS,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<UserResponse> getAllUsers(@RequestParam("page") Optional<Integer> page,
      @RequestParam("size") Optional<Integer> size) {
    log.debug(Constants.END_REQUEST);
    return new ResponseEntity<>(this.userService.findAllUsers(page, size), HttpStatus.OK);
  }

  /**
   * Post entry pont method to create new products.
   *  
   * @param userRequest UserRequest reference.
   * @return void.
   */
  @ApiOperation(value = Constants.API_RESOURCES_NAME_USERS_CREATE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiResponses(value = {@ApiResponse(code = Constants.CODE_OK, message = Constants.OK),
      @ApiResponse(code = Constants.CODE_BAD_REQUEST, message = Constants.BAD_REQUEST),
      @ApiResponse(code = Constants.CODE_INTERNAL_ERROR, message = Constants.INTERNAL_ERROR)})

  @PostMapping(value = Constants.GET_MAPPING_RESOURCE_USERS,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> createUsers(@Valid @RequestBody UserRequest userRequest) {

    this.userService.createUser(userRequest);
    log.debug(Constants.END_REQUEST, userRequest);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
}
