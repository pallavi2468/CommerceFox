package com.example.ProductService.controller;

import com.example.ProductService.entity.Category;
import com.example.ProductService.entity.Product;
import com.example.ProductService.service.CategoryService;
//import com.example.ProductService.service.impl.NextSequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping
    public Category addCategory( @RequestBody Category category)
    {

        return categoryService.addCategory(category);
    }


    @DeleteMapping(value = "/{categoryId}")
    public void delete(@PathVariable(name="categoryId") String categoryId)
    {
        categoryService.delete(categoryId);
    }
    @GetMapping
    public List<Category> getAllCategories(){
        //todo fill the details here
       return  categoryService.getAllCategories();
    }


}
