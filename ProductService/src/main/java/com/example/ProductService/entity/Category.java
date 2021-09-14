package com.example.ProductService.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Category {
    @Id
    private String categoryId;
    private String categoryName;

    //private List<Product> productList;


    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }


    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

   /* public List<Product> getProductList() {
        return productList;
    }

   public void setProductList(List<Product> productList) {
    this.productList = productList;
    }*/
}
