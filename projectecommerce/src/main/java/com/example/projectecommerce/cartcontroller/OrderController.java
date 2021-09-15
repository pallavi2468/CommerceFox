package com.example.projectecommerce.cartcontroller;

import com.example.projectecommerce.cartentity.Cart;
import com.example.projectecommerce.cartentity.Order;
import com.example.projectecommerce.cartentity.Product;
import com.example.projectecommerce.cartservice.CartService;
import com.example.projectecommerce.cartservice.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    CartService cartService;

//    RestTemplate restTemplate = new RestTemplate();



    @GetMapping(value = "/{id}")
    public Order get(@PathVariable(name = "id") String id) {
        return orderService.get(id);
    }

    @PostMapping(value = "/buy")
    public List<Order> save(@RequestBody Order order) {

        return orderService.save(order);

//        Product product = new Product();
//        product.setProductId(order.getProductId());
//        product.setQuantity(order.getQuantity());

//        cartService.delete(order.getCartId());

//        return orderService.save(order);
    }

    @GetMapping(value = "/getorderhistory/{id}")
    public List<Order> getOrderHistory(@PathVariable(name = "id") Long id){
        return orderService.OrderHistory(id);

    }

}
