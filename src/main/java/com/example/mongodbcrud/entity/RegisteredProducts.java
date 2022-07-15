package com.example.mongodbcrud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@AllArgsConstructor
@Document(collection = "product_db")
public class RegisteredProducts {

    @Id
    private String product_id;
    private String product_name;
    private int total_stock;
    private String price;
    private String company_name;
    private String launch_date;
}
