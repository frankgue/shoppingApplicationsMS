package com.gkfcsolution.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Created on 2025 at 19:32
 * File: ProductRequest.java.java
 * Project: shoppingApplicationsMS
 *
 * @author Frank GUEKENG
 * @date 17/10/2025
 * @time 19:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {
    private String name;
    private String description;
    private BigDecimal price;
}
