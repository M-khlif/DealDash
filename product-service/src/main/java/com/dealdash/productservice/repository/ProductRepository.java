package com.dealdash.productservice.repository;

import com.dealdash.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
    
}
