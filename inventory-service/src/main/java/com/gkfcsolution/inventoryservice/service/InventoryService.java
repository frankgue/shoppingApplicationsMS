package com.gkfcsolution.inventoryservice.service;

import com.gkfcsolution.inventoryservice.dto.InventoryResponse;
import com.gkfcsolution.inventoryservice.entity.Inventory;

import java.util.List;

/**
 * Created on 2025 at 11:58
 * File: null.java
 * Project: shoppingApplicationsMS
 *
 * @author Frank GUEKENG
 * @date 19/10/2025
 * @time 11:58
 */
public interface InventoryService {
    boolean isInStock(String skuCode);

    List<InventoryResponse> isInStock(List<String> skuCodes);
}
