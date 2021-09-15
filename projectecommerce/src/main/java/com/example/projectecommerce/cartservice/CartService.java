package com.example.projectecommerce.cartservice;

import com.example.projectecommerce.cartentity.Cart;

public interface CartService {
    public Cart get(String _id);
    public Cart save(Cart cart);
    public Cart removeProduct(Cart cart);
    public void delete(String _id);
}
