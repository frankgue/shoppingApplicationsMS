package com.gkfcsolution.notificationservice.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created on 2025 at 14:52
 * File: null.java
 * Project: shoppingApplicationsMS
 *
 * @author Frank GUEKENG
 * @date 23/10/2025
 * @time 14:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderPlaceEvent {
    private String orderNumber;
}
