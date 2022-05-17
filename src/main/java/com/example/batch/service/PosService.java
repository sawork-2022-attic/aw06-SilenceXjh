package com.example.batch.service;

import java.util.List;

import com.example.batch.model.Cart;
import com.example.batch.model.Product;

public interface PosService {

    public Cart createCart();
    
    public Cart add(int cartId, Product product, int amount);

    public Cart add(int cartId, String asin, int amount);

    public List<Product> allProducts();

    public int productNum();

}