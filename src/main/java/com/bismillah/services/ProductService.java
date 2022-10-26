package com.bismillah.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bismillah.models.entities.Product;
import com.bismillah.models.entities.Supplier;
import com.bismillah.models.repos.ProductRepo;

@Service
@Transactional
public class ProductService {
    
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private SupplierService supplierService;

    public Product save(Product product){
        return productRepo.save(product);
    }

    public Product findOne(Long id){
        return productRepo.findById(id).get();
    }

    public Iterable<Product> findAll(){
        return productRepo.findAll();
    }

    public void removeOne(Long id){
        productRepo.deleteById(id);
    }


    public void addSupplier(Supplier supplier, Long productId){
        Product product = findOne(productId);
        if (product == null){
            throw new RuntimeException("ProductID not found");
        }
        product.getSuppliers().add(supplier);
        save(product);
    }

    public List<Product> findByName(String name){
        return productRepo.findByNameContains("%"+name+"%");
    }

    public List<Product> findByCategory(Long id){
        return productRepo.findByCategory(id);
    }

    public List<Product> findBySupplier(Long id){
        Supplier supplier = supplierService.findOne(id);
        if (supplier == null){
            return new ArrayList<Product>();
        }

        return productRepo.findBySupplier(supplier);
    }
}
