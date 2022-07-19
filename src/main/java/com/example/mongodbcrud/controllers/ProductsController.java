package com.example.mongodbcrud.controllers;


import com.example.mongodbcrud.entity.RegisteredProducts;
import com.example.mongodbcrud.repository.ProductsDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsDataRepository productsRepository;


    @PostMapping("/create_product")
    public RegisteredProducts createProducts(@RequestBody RegisteredProducts products) {
        products.setProduct_id(UUID.randomUUID().toString());
        return productsRepository.save(products);
    }

}
