package com.example.batch.service;

import java.util.List;

import com.example.batch.model.Cart;
import com.example.batch.model.Item;
import com.example.batch.model.Product;
import com.example.batch.repository.CartRepository;
import com.example.batch.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PosServiceImp implements PosService {
    
    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private CartRepository cartRepo;

    @Override
    public Cart createCart() {
        return cartRepo.create();
    }
 
    @Override
    public Cart add(int cartId, Product product, int amount) {
        Item item = new Item(product, amount);
        return cartRepo.addItem(cartId, item);
    }

    @Override
    public Cart add(int cartId, String asin, int amount) {
        Product product = productRepo.getProduct(asin);
        if(product == null) 
            return null;
        return this.add(cartId, product, amount);
    }

    @Override
    public List<Product> allProducts() {
        return productRepo.allProducts();
    }

    @Override
    public int productNum() {
        return productRepo.productNum();
    }

}