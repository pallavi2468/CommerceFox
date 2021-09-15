package com.example.projectecommerce.cartservice.impl;

import com.example.projectecommerce.cartentity.Cart;
import com.example.projectecommerce.cartentity.Order;
import com.example.projectecommerce.cartentity.Product;
import com.example.projectecommerce.cartrepository.CartRepository;
import com.example.projectecommerce.cartrepository.OrderRepository;
import com.example.projectecommerce.cartservice.CartService;
import com.example.projectecommerce.cartservice.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CartRepository cartRepository;

    RestTemplate restTemplate = new RestTemplate();


    @Override
    public Order get(String orderId) {
        return orderRepository.findById(orderId).get();
    }

    @Override
    public List<Order> save(Order order) {

        Cart orderCart = cartRepository.findByUserId(order.getUserId());
        List<Product> orderedProducts = orderCart.getProducts();

        List<Order> currentOrders = new ArrayList<>();

        for(int i=0; i<orderedProducts.size(); i++){
            Order newOrder = new Order();
            Product product = restTemplate.getForObject("http://localhost:8084/product/"+orderedProducts.get(i).getProductId(), Product.class);
            newOrder.setUserId(order.getUserId());
            newOrder.setCartId(orderCart.get_id());
            newOrder.setProductId(product.getProductId());
            newOrder.setQuantity(orderCart.getProducts().get(i).getQuantity());
            newOrder.setOrderPrice(newOrder.getQuantity()*product.getPrice());

            Product updatedProduct = new Product();
            updatedProduct.setProductId(newOrder.getProductId());
            updatedProduct.setQuantity(newOrder.getQuantity());
            HttpEntity<Product> request = new HttpEntity<>(updatedProduct);
            restTemplate.postForObject("http://localhost:8084/product/updateinventory",request, Product.class);

            orderRepository.save(newOrder);
            currentOrders.add(newOrder);
        }


//        order.setCart(cartService.get(order.getCartId()));
//        cartService.delete(order.getCartId());


        return currentOrders;
    }

    @Override
    public List<Order> OrderHistory(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}
