package com.example.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.request.Product;

public interface ProductRepository extends JpaRepository <Product,Long>{

	//Optional<Product> findById(int id);

	

}
