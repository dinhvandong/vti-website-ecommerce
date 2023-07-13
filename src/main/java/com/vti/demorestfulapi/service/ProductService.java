package com.vti.demorestfulapi.service;


import com.vti.demorestfulapi.model.Product;
import com.vti.demorestfulapi.repository.ProductRepository;
import com.vti.demorestfulapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Configurable
public class ProductService  implements  ProductServiceInterface
{
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public Product insert(Product product) {
        product.setCreatedDate(new Date());
        Product product1 = productRepository.save(product);
        return product1;
    }
    @Override
    public Product update(Product product) {
        Optional<Product> optionalProductOld = productRepository.findById(product.getId());
        if(optionalProductOld.isPresent()){
            Product productOld = optionalProductOld.get();
            product.setCreatedDate(productOld.getCreatedDate());
            Product product1 = productRepository.save(product);
            return product1;
        }
        return  null;
    }

    @Override
    public void delete(Product product) {
        productRepository.save(product);
    }

    @Override
    public Optional<Product> findByID(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getAll() {
        // Trả về các đối tượng có trường deleteTime == null (Có nghĩa là chưa bị xóa)
        return productRepository.findAll().stream()
                .filter(str -> str.getDeleteTime() == null)
                .collect(Collectors.toList());
    }
    @Override
    public List<Product> getByCategory(String category) {
        return productRepository.findAllByCategory(category);
    }
}


