package com.bismillah.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.bismillah.models.entities.Supplier;
import com.bismillah.models.repos.SupplierRepo;

@Service
@Transactional
public class SupplierService {
    
    @Autowired
    private SupplierRepo supplierRepo;

    public Supplier save(Supplier supplier){
        return supplierRepo.save(supplier);
    }
    
    public Supplier findOne(long id){
        Optional<Supplier> supplier = supplierRepo.findById(id);
        if (!supplier.isPresent()){
            return null;
        }
        return supplier.get();
    }

    public Iterable<Supplier> findAll(){
        return supplierRepo.findAll();
    }

    public void removeOne(Long id){
        supplierRepo.deleteById(id);
    }
}
