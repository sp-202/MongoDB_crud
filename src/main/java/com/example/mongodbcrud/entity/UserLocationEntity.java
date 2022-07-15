package com.example.mongodbcrud.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserLocationEntity {

    private String city;
    private String state;
    private String pin_code;
}
