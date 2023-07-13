package com.vti.demorestfulapi.service;

import com.vti.demorestfulapi.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductServiceInterface {
    public Product insert(Product product);
    public Product update(Product product);

    public void delete(Product product);
    public Optional<Product> findByID(Long id);
    public List<Product> getAll();
    public List<Product> getByCategory(String category);
}
