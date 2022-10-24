package com.bismillah.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.bismillah.models.entities.Supplier;

public interface SupplierRepo extends CrudRepository<Supplier, Long>{
    
}
