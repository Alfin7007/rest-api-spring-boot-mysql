package com.bismillah.models.repos;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bismillah.models.entities.Product;
import com.bismillah.models.entities.Supplier;

public interface ProductRepo extends CrudRepository<Product,Long> {
    
    @Query("SELECT p FROM Product p WHERE p.name LIKE :name")
    public List<Product> findByNameContains(@PathParam("name") String name);

    @Query("SELECT p FROM Product p WHERE p.category.id = :category_id")
    public List<Product> findByCategory(@PathParam("category_id") Long category_id);

    @Query("SELECT p FROM Product p WHERE :supplier MEMBER OF p.suppliers")
    public List<Product> findBySupplier(@PathParam("supplier") Supplier supplier);

}
