package com.example.ProductService.controller;

import com.example.ProductService.dto.Productdto;
import com.example.ProductService.entity.Product;
import com.example.ProductService.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;


    @GetMapping(value="/{productId}")
    public Product getProduct(@PathVariable(value="productId") String productId )
    {
        return productService.getProduct(productId);
    }
    @PostMapping
    public Product addNewProduct(@RequestBody Product product)
    {

        return productService.addNewProduct(product);
    }
    @PutMapping
    public Product updateNewProduct(@RequestBody Product product)
    {

        return productService.addNewProduct(product);
    }

    @DeleteMapping("/{productId}")
    public void  deleteProduct(@PathVariable(value = "productId") String productId)
    {
        productService.deleteProduct(productId);
    }
    @GetMapping(value="/categoryName/{categoryName}")
    public List<Product> getProductList (@PathVariable(value="categoryName")  String categoryName)
    {

        return productService.getProductList(categoryName);
    }
    @GetMapping(value="/merchantId/{merchantId}")

    public List<Product> getProductListOfMerchant (@PathVariable(value="merchantId")  Long merchantId)
    {

        return productService.getProductListOfMerchant(merchantId);
    }


    @Transactional
    @PutMapping(value="/{productId}/{quantity}")
    public Product updateQuantity(@PathVariable(value = "productId") String productId, @PathVariable(value="quantity") int quantity)
    {
        return productService.updateQuantity(productId,quantity);
    }
    @PostMapping(value = "/updateinventory")
    public Product updateInventory(@RequestBody Product product)
    {
        return productService.updateQuantityAfterBuy(product);
    }
}
