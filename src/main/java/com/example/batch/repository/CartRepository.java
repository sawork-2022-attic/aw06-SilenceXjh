package com.example.batch.repository;

import com.example.batch.model.Cart;
import com.example.batch.model.Item;

public interface CartRepository {
    
    public Cart create();

    public Cart getCartById(int cartId);

    public Cart addItem(int cartId, Item item);

}