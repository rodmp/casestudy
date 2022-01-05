/*
 * Parrot.
 */

package com.test.parrot.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.test.parrot.domain.Orders;

public interface OrderRepository extends PagingAndSortingRepository<Orders, Long> {

}
