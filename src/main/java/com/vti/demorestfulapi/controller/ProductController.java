package com.vti.demorestfulapi.controller;

import com.vti.demorestfulapi.model.Product;
import com.vti.demorestfulapi.model.ResponseObject;
import com.vti.demorestfulapi.service.ProductService;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/findAll")
    public ResponseEntity<?>  getAllProduct()
    {
        List<Product> productList = new ArrayList<>();
        productList = productService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(new
                ResponseObject(200,"Success",productList));

    }

    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody Product product){
        Product product1 = productService.insert(product);
        return ResponseEntity.status(HttpStatus.OK).body(new
                ResponseObject(200,"Success",product1));    }


    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Product product){
        Product product1 = productService.update(product);
        return ResponseEntity.status(HttpStatus.OK).body(new
                ResponseObject(200,"Success",product1));    }

    @PostMapping("deleteByID")
    public  ResponseEntity<?>  delete (@RequestParam Long id){
        Optional<Product> productOptional = productService.findByID(id);
        if(productOptional.isPresent()){
            Product product = productOptional.get();
            product.setDeleteTime(new Date());
            productService.delete(product);
            return ResponseEntity.status(HttpStatus.OK).body(new
                    ResponseObject(200,"Success",null));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new
                ResponseObject(201,"Fail",null));

    }

}
