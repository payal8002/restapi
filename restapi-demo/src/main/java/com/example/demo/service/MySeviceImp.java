package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ProductRepository;
import com.example.demo.request.Product;
import com.example.demo.response.ProductResponse;


@Service
public class MySeviceImp implements MyService {
	@Autowired
	private ProductRepository repo;
	@Override
	public Product add(Product product) {
		
		return repo.save(product);
	}

	@Override
	public Product getProduct(int id) {
		return repo.findById ((long) id).orElse(null);

	    }

	 @Override
	    public Product update(int id, Product product) {
	        Product getProduct = repo.findById((long) id).orElse(null); // Corrected the ID type and added a semicolon

	        if (getProduct != null) {
	            getProduct.setPname(product.getPname());
	            // Other properties can be updated similarly
	            return repo.save(getProduct);
	        } else {
	            return null;
	        }
	    }
	
	
	}



	



