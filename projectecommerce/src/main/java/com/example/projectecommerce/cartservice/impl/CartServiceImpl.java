package com.example.projectecommerce.cartservice.impl;

import com.example.projectecommerce.cartentity.Cart;
import com.example.projectecommerce.cartentity.Product;
import com.example.projectecommerce.cartrepository.CartRepository;
import com.example.projectecommerce.cartservice.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartRepository cartRepository;

    RestTemplate restTemplate = new RestTemplate();

    @Override
    public Cart save(Cart cart) {

        Cart userCart = cartRepository.findByUserId(cart.getUserId());

        Product product = restTemplate.getForObject("http://localhost:8084/product/"+cart.getProductId(), Product.class);

        if(userCart == null){
            Cart newCart = new Cart();
            List<Product> products = new ArrayList<>();
            List<Integer> quantities = new ArrayList<>();
            products.add(product);
            quantities.add(cart.getQuantity());
            newCart.setProducts(products);
            newCart.setCartPrice(product.getPrice());
            newCart.setUserId(cart.getUserId());
            newCart.setQuantities(quantities);
            return cartRepository.save(newCart);
        }
        else {

            List<Product> products = userCart.getProducts();
            products.add(product);
            userCart.setProducts(products);

            List<Integer> quantities = userCart.getQuantities();
            quantities.add(cart.getQuantity());
            userCart.setQuantities(quantities);

            Double totalPrice = 0.0;

            for (int i = 0; i < products.size(); i++) {
                totalPrice += products.get(i).getPrice();
            }
            userCart.setCartPrice(totalPrice);

            return cartRepository.save(userCart);
        }

    }

    @Override
    public Cart removeProduct(Cart cart) {
        Cart userCart = cartRepository.findByUserId(cart.getUserId());

        for(int i=0; i<userCart.getProducts().size(); i++){
            if(userCart.getProducts().get(i).getProductId().equals(cart.getProductId())){
                List<Product> products = userCart.getProducts();
                userCart.setCartPrice(userCart.getCartPrice()-products.get(i).getPrice());
                products.remove(i);
                userCart.setProducts(products);

                List<Integer> quantities = userCart.getQuantities();
                quantities.remove(i);
                userCart.setQuantities(quantities);


                break;
            }
        }


        if(userCart.getProducts().size()==0){
            cartRepository.deleteById(userCart.get_id());
            return null;
        }

        return cartRepository.save(userCart);
    }

    @Override
    public Cart get(String _id) {
        return cartRepository.findById(_id).get();
    }


    @Override
    public void delete(String _id) {
        cartRepository.deleteById(_id);
    }

}
