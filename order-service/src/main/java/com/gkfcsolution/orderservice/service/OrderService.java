package com.gkfcsolution.orderservice.service;

import com.gkfcsolution.orderservice.dto.OrderRequest;

/**
 * Created on 2025 at 10:57
 * File: OrderService.java.java
 * Project: shoppingApplicationsMS
 *
 * @author Frank GUEKENG
 * @date 19/10/2025
 * @time 10:57
 */
public interface OrderService {
    void placeOrder(OrderRequest orderRequest);
}
