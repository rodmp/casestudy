/*
 * Parrot.
 */

package com.test.parrot.service;

/**
 * Contract interface User service class.
 * 
 * @author parrot.
 *
 */
import java.util.Optional;
import com.test.parrot.model.UserRequest;
import com.test.parrot.model.UserResponse;

public interface UserService {

  /**
   * Find all users method. Two parameters are received for pagination, one the page size and two
   * the page number.
   * 
   * @param page Actual page requested.
   * @param size Size of page..
   * @return UserResponse Result of search.
   */
  public UserResponse findAllUsers(Optional<Integer> page, Optional<Integer> size);

  /**
   * Create new user method. 
   * 
   * @param userRequest UserRequest object info requested.
   */
  public void createUser(UserRequest userRequest);
}
