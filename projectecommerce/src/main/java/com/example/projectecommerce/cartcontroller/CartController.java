package com.example.projectecommerce.cartcontroller;

import com.example.projectecommerce.cartentity.Cart;
import com.example.projectecommerce.cartservice.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping(value = "/addtocart")
    public Cart save(@RequestBody Cart cart){
        return  cartService.save(cart);
    }

    @PostMapping(value = "/removefromcart")
    public Cart removeFromCart(@RequestBody Cart cart){
        return cartService.removeProduct(cart);
    }

    @GetMapping(value = "/{id}")
    public Cart get(@PathVariable(name = "id") String _id){
        return cartService.get(_id);
    }



    @PutMapping(value="/edit")
    public Cart edit(@RequestBody Cart cart){
        return cartService.save(cart);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(name="id") String _id){
        cartService.delete(_id);
    }
}
