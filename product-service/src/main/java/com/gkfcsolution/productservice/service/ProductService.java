package com.gkfcsolution.productservice.service;

import com.gkfcsolution.productservice.dto.ProductRequest;
import com.gkfcsolution.productservice.dto.ProductResponse;

import java.util.List;

/**
 * Created on 2025 at 19:33
 * File: null.java
 * Project: shoppingApplicationsMS
 *
 * @author Frank GUEKENG
 * @date 17/10/2025
 * @time 19:33
 */
public interface ProductService {
    void createProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProducts();
}
