/*
 * Parrot.
 */

package com.test.parrot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.test.parrot.domain.OrderItem;

/**
 * Interface order item repository class.
 * 
 * @author parrot.
 *
 */
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
