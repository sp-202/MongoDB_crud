package com.example.mongodbcrud.crud_controller;


import com.example.mongodbcrud.entity.ProductsEntity;
import com.example.mongodbcrud.entity.RegisteredProducts;
import com.example.mongodbcrud.entity.UserDbAttributes;
import com.example.mongodbcrud.repository.ProductsDataRepository;
import com.example.mongodbcrud.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/order")
public class UserCRUDController {

    @Autowired
    private UserDataRepository userDataRepository;

    @Autowired
    private ProductsDataRepository productsRepository;


    @PostMapping("/create_user")
    public UserDbAttributes createUser(@RequestBody UserDbAttributes userAttributes) {
        userAttributes.setUuid(UUID.randomUUID().toString());
        Date date = new Date();
        userAttributes.setTime_stamp(date.toString());
        return userDataRepository.save(userAttributes);
    }

    @PutMapping("/place_order/{uuid}/{product_name}")
    public String placeNewOrder(@PathVariable String uuid, @PathVariable String product_name) {
        RegisteredProducts products = productsRepository.findByProduct_name(product_name);

        UserDbAttributes userDetails = userDataRepository.findByUuid(uuid);
        List<ProductsEntity> productsEntityList = new ArrayList<>();
        productsEntityList.add(new ProductsEntity(products.getProduct_name(),
                "1", "02-03-2022", products.getPrice()));
        userDetails.setProducts(productsEntityList);
        userDataRepository.save(userDetails);
        return "Successfully placed order";
    }


    @GetMapping("/getuser/{name}")
    public UserDbAttributes getUsers(@PathVariable String name) {
        return userDataRepository.findByUsername(name);
    }


    @GetMapping("/getuser_by_address/{address}")
    public List<UserDbAttributes> getUsersByCity(@PathVariable String address) {
        return userDataRepository.findByCity(address);
    }

    @DeleteMapping("/delete_user/{username}")
    public String deleteUserByUserName(@PathVariable String username) {
        UserDbAttributes userAttributes = userDataRepository.findByUuid(username);
        userDataRepository.delete(userAttributes);
        return "Successfully deleted user by username" + username;
    }
}
