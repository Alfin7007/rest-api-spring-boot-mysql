package com.bismillah.models.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bismillah.models.entities.Product;

public interface ProductRepo extends CrudRepository<Product,Long> {
    
    List<Product> findByNameContains(String name);
}
