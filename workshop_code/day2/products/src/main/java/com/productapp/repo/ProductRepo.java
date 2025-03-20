package com.productapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productapp.entities.Product;

//u dont hve to write layer u need declare it
@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
}
