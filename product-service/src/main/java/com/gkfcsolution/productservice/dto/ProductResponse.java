package com.gkfcsolution.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Created on 2025 at 20:18
 * File: null.java
 * Project: shoppingApplicationsMS
 *
 * @author Frank GUEKENG
 * @date 17/10/2025
 * @time 20:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}
