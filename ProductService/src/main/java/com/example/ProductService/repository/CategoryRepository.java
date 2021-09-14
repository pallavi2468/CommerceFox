package com.example.ProductService.repository;

import com.example.ProductService.entity.Category;
import com.example.ProductService.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryRepository extends MongoRepository<Category,String> {

}
