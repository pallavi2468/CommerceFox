package com.example.ProductService.service.impl;

import com.example.ProductService.entity.Product;
import com.example.ProductService.repository.ProductRepository;
import com.example.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    public Product getProduct(String productId)
    {
         return productRepository.findById(productId).get();
    }
    public Product addNewProduct(Product product)
    {
        product.setRating(Math.random());
       return productRepository.save(product);
    }
    public Product updateNewProduct(Product product)
    {
        return productRepository.save(product);
    }
    public void  deleteProduct(String productId)
    {
        productRepository.deleteById(productId);
    }
    public List<Product> getProductList(String categoryName)
    {

        return productRepository.findByCategoryName(categoryName);

    }
    public List<Product> getProductListOfMerchant(Long merchantId)
    {
        return productRepository.findByMerchantId(merchantId);
    }
    public Product updateQuantity(String productId,int quantity)
    {
        Product product=productRepository.findById(productId).get();
        int prevQuantity=product.getQuantity();
        product.setQuantity(prevQuantity+quantity);
        productRepository.save(product);
        return product;
    }
    @Override
    public Product updateQuantityAfterBuy(Product product) {
        Product updatedProduct = productRepository.findById(product.getProductId()).get();
        updatedProduct.setQuantity(updatedProduct.getQuantity()-product.getQuantity());
        return productRepository.save(updatedProduct);
    }

}
