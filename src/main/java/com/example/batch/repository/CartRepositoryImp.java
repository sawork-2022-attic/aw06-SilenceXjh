package com.example.batch.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.batch.model.Cart;
import com.example.batch.model.Item;

import org.springframework.stereotype.Repository;

@Repository
public class CartRepositoryImp implements CartRepository {
    
    List<Cart> carts = new ArrayList<>();

    @Override
    public Cart create() {
        int index = carts.size();
        Cart cart = new Cart(index);
        carts.add(cart);
        return cart;
    }

    @Override
    public Cart getCartById(int cartId) {
        if(cartId >= carts.size()) {
            return null;
        }
        return carts.get(cartId);
    }

    @Override
    public Cart addItem(int cartId, Item item) {
        Cart cart = getCartById(cartId);
        if(cart == null) 
            return null;
        cart.addItem(item);
        return cart;
    }

}