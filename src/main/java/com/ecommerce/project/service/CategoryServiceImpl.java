package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.Optional;


@Service
public class CategoryServiceImpl implements CategoryService {
    //private List<Category> categories =  new ArrayList<>();
    @Autowired
    private CategoryRepository categoryRespository;
    //private long nextId = 1L;
    @Override
    public List<Category> getAllCategories() {
        return categoryRespository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        //category.setCategoryId(nextId++);
        categoryRespository.save(category);
    }
    @Override
    public String deleteCategory(Long categoryId){
        Category category = categoryRespository.findById(categoryId).
                orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found !"));

        categoryRespository.delete(category);

        return "Category with CategoryId: " + categoryId + " deleted sucessfully";
    }
    @Override
    public Category updateCategory(Category category, Long categoryId) {

        Category savedCategory = categoryRespository.findById(categoryId).
                orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found !"));
        category.setCategoryId(categoryId);
        savedCategory = categoryRespository.save(category);
        return savedCategory;
    }
}
