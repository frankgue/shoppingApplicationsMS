package com.gkfcsolution.orderservice.repository;

import com.gkfcsolution.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 2025 at 11:00
 * File: OrderRepository.java.java
 * Project: shoppingApplicationsMS
 *
 * @author Frank GUEKENG
 * @date 19/10/2025
 * @time 11:00
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
