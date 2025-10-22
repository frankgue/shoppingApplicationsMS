package com.gkfcsolution.orderservice.service.impl;

import com.gkfcsolution.orderservice.dto.InventoryResponse;
import com.gkfcsolution.orderservice.dto.OrderLineItemsDto;
import com.gkfcsolution.orderservice.dto.OrderRequest;
import com.gkfcsolution.orderservice.entity.Order;
import com.gkfcsolution.orderservice.entity.OrderLineItems;
import com.gkfcsolution.orderservice.repository.OrderRepository;
import com.gkfcsolution.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created on 2025 at 10:59
 * File: OrderServiceImpl.java.java
 * Project: shoppingApplicationsMS
 *
 * @author Frank GUEKENG
 * @date 19/10/2025
 * @time 10:59
 */
@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;

    @Override
    public void placeOrder(OrderRequest orderRequest) {
        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList().stream().map(this::mapToDto).toList();
        Order order = Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .orderLineItems(orderLineItems)
                .build();

        List<String> skuCodes = order.getOrderLineItems().stream()
                .map(OrderLineItems::getSkuCode)
                .toList();

        // Call Inventory Service, and place order if product is in stock
        List<InventoryResponse> inventoryResponseArray = webClientBuilder.build().get()
                .uri("http://inventory-service/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes.toArray()).build())
                .retrieve()
                .bodyToFlux(InventoryResponse.class)
                .collectList()
                .block();


      /*  // Call Inventory Service, and place order if product is in stock
        List<InventoryResponse> inventoryResponseArray = webClient.get()
                .uri("http://INVENTORY-SERVICE/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes.toArray()).build())
                .retrieve()
                .bodyToFlux(InventoryResponse.class)
                .collectList()
                .block();*/

        boolean allProductsInStock = inventoryResponseArray.stream().allMatch(InventoryResponse::isInStock);

        if (allProductsInStock) {
            log.info("Order Placed Successfully");
            orderRepository.save(order);
        } else {
            throw new IllegalArgumentException("Product is not in stock, please try again later");
        }
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        return OrderLineItems.builder()
                .price(orderLineItemsDto.getPrice())
                .skuCode(orderLineItemsDto.getSkuCode())
                .quantity(orderLineItemsDto.getQuantity())
                .build();
    }
}
