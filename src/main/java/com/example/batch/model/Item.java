package com.example.batch.model;

import lombok.Data;

@Data
public class Item {
    
    private Product product;

    private int amount;

    public Item(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return product.toString() + " * " + amount;
    }

}