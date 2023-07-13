package com.vti.demorestfulapi.repository;

import com.vti.demorestfulapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCategory(String category);
    Product findByCategory(String category);
}
