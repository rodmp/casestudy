/*
 * Parrot.
 */

package com.test.parrot.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.test.parrot.domain.Orders;

/**
 * Interface order repository class.
 * 
 * @author parrot.
 *
 */
public interface OrderRepository extends PagingAndSortingRepository<Orders, Long> {

}
