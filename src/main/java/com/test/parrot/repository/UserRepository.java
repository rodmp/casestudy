/*
 * Parrot.
 */

package com.test.parrot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.test.parrot.domain.User;

/**
 * Interface user repository class.
 * 
 * @author parrot.
 *
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

  /**
   * Method to find all users.
   */
  Page<User> findAll(Pageable page);
}
