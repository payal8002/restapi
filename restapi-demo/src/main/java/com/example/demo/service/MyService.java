package com.example.demo.service;

import org.springframework.stereotype.Component;

import com.example.demo.request.Product;

@Component
public interface MyService {
Product add(Product product);

Product getProduct(int id);

Product update(int id, Product product);

}
