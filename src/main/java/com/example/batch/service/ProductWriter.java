package com.example.batch.service;

import com.example.batch.model.Product;
import com.example.batch.repository.ProductRepository;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductWriter implements ItemWriter<Product>, StepExecutionListener {

    @Autowired
    private ProductRepository productRepo;

    @Override
    public void beforeStep(StepExecution stepExecution) {

    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        System.out.println("Total product num is " + productRepo.productNum());
        return null;
    }

    @Override
    public void write(List<? extends Product> list) throws Exception {
        //list.stream().forEach(System.out::println);
        //System.out.println("chunk written");
        for(Product p : list) {
            boolean b = productRepo.save(p);
            System.out.println(p);
            if(!b) {
                System.out.println("save product failed");
            }
        }
    }
}
