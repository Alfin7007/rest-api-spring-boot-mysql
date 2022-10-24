package com.bismillah.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.bismillah.models.entities.Category;

public interface CategoryRepo extends CrudRepository<Category, Long>{
    
}
