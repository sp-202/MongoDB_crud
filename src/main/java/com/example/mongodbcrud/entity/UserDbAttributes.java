package com.example.mongodbcrud.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@AllArgsConstructor
@Document(collection = "user_db")
@NoArgsConstructor
public class UserDbAttributes {

    @Id
    private String uuid;

    @Pattern(regexp = "^[A-z][A-z0-9-_]{3,23}$", message = "Please enter a valid username")
    private String username;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%]).{8,24}$",
            message = "please input a valid password")
    private String password;

    private String time_stamp;
    private List<ProductsEntity> products;
    private UserLocationEntity address;

    @Valid
    @NotNull
    private UserDetails userDetails;
}
