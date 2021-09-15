package com.example.projectecommerce.cartservice;

import com.example.projectecommerce.cartentity.Order;

import java.util.List;

public interface OrderService {
    public Order get(String orderId);
    public List<Order> save(Order order);
    public List<Order> OrderHistory(Long userId);

}
