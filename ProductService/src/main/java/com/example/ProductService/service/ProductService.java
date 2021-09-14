package com.example.ProductService.service;

import com.example.ProductService.entity.Product;

import java.util.List;

public interface ProductService {
    public Product getProduct(String productId);
    public Product addNewProduct(Product product);
    public Product updateNewProduct(Product product);
    public void  deleteProduct(String productId);
    public List<Product> getProductList(String categoryName);
    public List<Product> getProductListOfMerchant(Long merchantId);
    public Product updateQuantity(String productId,int quantity);
    public Product updateQuantityAfterBuy(Product product);
}
