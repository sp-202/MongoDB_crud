package com.example.mongodbcrud.repository;

import com.example.mongodbcrud.entity.RegisteredProducts;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsDataRepository extends MongoRepository<RegisteredProducts, String> {


    @Query("{'product_name':?0}")
    RegisteredProducts findByProduct_name(String product_name);
}
