package com.example.mongodbcrud.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@Document(collection = "user_db")
public class UserDbAttributes {

    @Id
    private String uuid;
    private String username;
    private String time_stamp;
    private List<ProductsEntity> products;
    private UserLocationEntity address;
    private UserDetails userDetails;
}
