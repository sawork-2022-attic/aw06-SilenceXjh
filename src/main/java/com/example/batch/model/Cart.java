package com.example.batch.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Cart {

    private int cartId;
    
    private List<Item> items = new ArrayList<>();

    public Cart(int cartId) {
        this.cartId = cartId;
    }

    public boolean addItem(Item item) {
        return items.add(item);
    }

    @Override
    public String toString() {
        if(items.isEmpty()) {
            return "cart" + cartId + ": " + "empty\n";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("cart" + cartId + "\n");
        for(Item item : items) {
            sb.append(item.toString() + "\n");
        }
        return sb.toString();
    }

}