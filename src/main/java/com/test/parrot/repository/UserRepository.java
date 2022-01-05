/*
 * Parrot.
 */

package com.test.parrot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.test.parrot.domain.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

  Page<User> findAll(Pageable page);
}
