package com.gkfcsolution.productservice.repository;

import com.gkfcsolution.productservice.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created on 2025 at 19:30
 * File: null.java
 * Project: shoppingApplicationsMS
 *
 * @author Frank GUEKENG
 * @date 17/10/2025
 * @time 19:30
 */
public interface ProductRepository extends MongoRepository<Product, String > {
}
