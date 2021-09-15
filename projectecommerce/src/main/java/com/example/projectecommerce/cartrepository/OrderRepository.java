package com.example.projectecommerce.cartrepository;

import com.example.projectecommerce.cartentity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
    public List<Order> findByUserId(Long userId);
}
