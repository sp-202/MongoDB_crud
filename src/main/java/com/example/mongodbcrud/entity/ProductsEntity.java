package com.example.mongodbcrud.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsEntity {

    private String product_name;
    private String quantity;
    private String order_date;
    private String price;
}
