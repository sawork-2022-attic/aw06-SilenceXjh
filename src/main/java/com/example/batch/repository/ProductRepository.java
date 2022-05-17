package com.example.batch.repository;

import java.util.List;

import com.example.batch.model.Product;

public interface ProductRepository {
    
    public List<Product> allProducts();

    public Product getProduct(String asin);

    public boolean save(Product p);

    public int productNum();

}