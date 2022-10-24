package com.bismillah.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bismillah.models.entities.Category;
import com.bismillah.models.repos.CategoryRepo;

@Service
@Transactional
public class CategoryService {
    
    @Autowired
    private CategoryRepo categoryRepo;

    public Category save(Category category){
        return categoryRepo.save(category);
    }

    public Iterable<Category> findAll(){
        return categoryRepo.findAll();
    }

    public Category findOne(Long id){
        Optional<Category> category = categoryRepo.findById(id);
        if (!category.isPresent()){
            return null;
        }
        return category.get();
    }

    public void removeOne(Long id){
        categoryRepo.deleteById(id);
    }


}
