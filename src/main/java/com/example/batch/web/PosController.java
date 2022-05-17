package com.example.batch.web;

import com.example.batch.model.Cart;
import com.example.batch.service.PosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PosController {
    
    @Autowired
    private PosService posService;

    @GetMapping("/")
    public String allProducts() {
        return "Total product num is " + posService.productNum();
    }

    @GetMapping("/create")
    public String createCart() {
        Cart cart = posService.createCart();
        return cart.toString();
    }

    @GetMapping("/add")
    public String addItem(@RequestParam(value = "id", defaultValue = "0") int cartId, 
                @RequestParam(value = "asin", defaultValue = "B01HJ14OT0") String asin) {
        Cart cart = posService.add(cartId, asin, 1);
        return cart == null ? "NULL" : cart.toString();
    }


}