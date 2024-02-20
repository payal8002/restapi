package com.example.demo.controller;



import java.security.PublicKey;
import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.request.Product;
import com.example.demo.response.ProductResponse;
import com.example.demo.service.MyService;



@RestController
public class MyController {
	@Autowired
	private MyService service;
	@Autowired
	private ProductResponse response;
	@PostMapping("/product")
	public ResponseEntity<ProductResponse> product(@RequestBody Product product){
		Product savedproduct=service.add(product);
		if(savedproduct!=null) {
		System.out.println(product);
		 response.setError(false);
	        response.setMsg("Request data received and providing success response");
	        response.setProducts(Arrays.asList(product));
		return new ResponseEntity<ProductResponse>(response,HttpStatus.OK);
		} else {
			response.setError(true);
			response.setMsg("failed to product");
			return new ResponseEntity<ProductResponse>(response,HttpStatus.NOT_FOUND);
		}
	}
		//Read
		 @GetMapping("/getById/{id}")
		    public ResponseEntity<ProductResponse> getById(@PathVariable("id") int id){
		        ProductResponse response = new ProductResponse();
		        Product savedProduct = service.getProduct(id);

		        if (savedProduct != null) {
		            response.setError(false);
		            response.setMsg("Data fetched successfully");
		            response.setProducts(Arrays.asList(savedProduct));
		            return new ResponseEntity<>(response, HttpStatus.OK);
		        } else {
		            response.setError(true);
		            response.setMsg("Failed to fetch data");
		            response.setProducts(null);
		            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		        }
		    }
	
//UPDATE
	@PutMapping("/update/{id}")
	 public ResponseEntity<ProductResponse> getUser(@PathVariable("id") int id, @RequestBody Product product){
     Product updatedProduct=service.update(id,product);
     if(updatedProduct!=null) {
    	 response.setError(false);
    	 response.setMsg("data updat successful");
    	 response.setProducts(Arrays.asList(updatedProduct));
    	 return new ResponseEntity<ProductResponse>(response,HttpStatus.OK);
     }else {
    	 response.setError(true);
         response.setMsg("data updation failed");
         response.setProducts(null); 
         return new ResponseEntity<ProductResponse>(response,HttpStatus.NOT_FOUND);
     }
    	 
     }
  
  
	}



