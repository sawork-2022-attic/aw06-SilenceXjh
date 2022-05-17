package com.example.batch.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.batch.model.Product;

import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImp implements ProductRepository {
    
    private List<Product> products = new ArrayList<>();

    @Override
    public List<Product> allProducts() {
        return products;
    }

    @Override
    public Product getProduct(String asin) {
        for(Product p : products) {
            if(p.getAsin().equals(asin)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public synchronized boolean save(Product p) {
        return products.add(p);
    }

    @Override
    public int productNum() {
        return products.size();
    }

}