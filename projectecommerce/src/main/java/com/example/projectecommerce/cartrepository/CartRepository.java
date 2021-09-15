package com.example.projectecommerce.cartrepository;

import com.example.projectecommerce.cartentity.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {
    public Cart findByUserId(Long userId);
}
