package com.example.mongodbcrud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails {

    private String phone_number;

    @Pattern(regexp = "^[a-zA-Z0-9.! #$%&'*+/=?^_`{|}~-]{1,20}+@[a-zA-Z0-9-]{3,20}+(?:\\.[a-zA-Z0-9-]{3,8}+)*$",
            message = "Please enter a valid email address")
    private String email_id;
    private String gender;

    @Pattern(regexp = "^[A-Za-z\\s]{1,15}[\\.]{0,1}[A-Za-z\\s]{0,10}$",
            message = "Please enter a valid name")
    private String first_name;

    @Pattern(regexp = "^[A-Za-z\\s]{1,15}[\\.]{0,1}[A-Za-z\\s]{0,10}$",
            message = "Please enter a valid name")
    private String last_name;
}
