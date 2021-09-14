package com.example.ProductService.service.impl;


import com.example.ProductService.entity.Category;
import com.example.ProductService.entity.Product;
import com.example.ProductService.repository.CategoryRepository;
import com.example.ProductService.repository.ProductRepository;
import com.example.ProductService.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductRepository productRepository;
    /*public List<Product> getProductList(String categoryName)
    {

        return productRepository.findAll().stream().filter(product -> product.getCategoryName().equals(categoryName)).collect(Collectors.toList());

    }*/
    public Category addCategory(Category category)
    {
        return categoryRepository.save(category);
    }
    public Category getCategory( String categoryId)
    {
        return categoryRepository.findById(categoryId).get();
    }
    public Category updateCategory(Category category)
    {
        return categoryRepository.save(category);
    }
    public void delete(String categoryId)
    {
        categoryRepository.deleteById(categoryId);
    }
    public List<Category> getAllCategories()
    {
        return categoryRepository.findAll(Sort.by(Sort.Direction.ASC, "categoryName")).stream().collect(Collectors.toList());
    }

}
