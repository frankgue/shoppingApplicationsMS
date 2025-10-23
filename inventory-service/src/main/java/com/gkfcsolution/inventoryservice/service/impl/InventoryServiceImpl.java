package com.gkfcsolution.inventoryservice.service.impl;

import com.gkfcsolution.inventoryservice.dto.InventoryResponse;
import com.gkfcsolution.inventoryservice.entity.Inventory;
import com.gkfcsolution.inventoryservice.repository.InventoryRepository;
import com.gkfcsolution.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created on 2025 at 11:58
 * File: InventoryImpl.java.java
 * Project: shoppingApplicationsMS
 *
 * @author Frank GUEKENG
 * @date 19/10/2025
 * @time 11:58
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode) {
        return inventoryRepository.findBySkuCode(skuCode).isPresent();
    }

    @SneakyThrows
    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCodes) {
        log.info("Wait Started");
//        Thread.sleep(10000);
//        log.info("Wait Ended");
        return inventoryRepository.findBySkuCodeIn(skuCodes).stream().map(inventory ->
                InventoryResponse.builder()
                        .skuCode(inventory.getSkuCode())
                        .isInStock(inventory.getQuantity() > 0)
                        .build()
        ).toList();
    }
}
