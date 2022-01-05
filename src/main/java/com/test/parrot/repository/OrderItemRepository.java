package com.test.parrot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.test.parrot.domain.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
