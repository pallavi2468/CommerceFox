package com.example.ProductService.repository;

import com.example.ProductService.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product,String> {


    public List<Product> findByCategoryName(String categoryName);
    public List<Product> findByMerchantId (Long merchantId);


}
