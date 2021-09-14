package com.example.ProductService.service;

import com.example.ProductService.entity.Category;
import com.example.ProductService.entity.Product;

import java.util.List;

public interface CategoryService {

    public Category addCategory(Category category);

    public Category getCategory( String categoryId);

    public Category updateCategory(Category category);

    public void delete(String categoryId);
     public List<Category> getAllCategories();


}
