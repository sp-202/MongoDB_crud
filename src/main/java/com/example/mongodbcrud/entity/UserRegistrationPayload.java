package com.example.mongodbcrud.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationPayload {

    @Id
    private String uuid;

    @Pattern(regexp = "^[a-zA-Z0-9.! #$%&'*+/=?^_`{|}~-]{1,20}+@[a-zA-Z0-9-]{3,20}+(?:\\.[a-zA-Z0-9-]{3,8}+)*$",
            message = "Please enter a valid email address")
    private String email;


    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%]).{8,24}$",
            message = "please input a valid password")
    private String password;

    @Pattern(regexp = "^[A-z][A-z0-9-_]{3,23}$", message = "Please enter a valid username")
    private String username;

    @Pattern(regexp = "^[A-Za-z\\s]{1,15}[\\.]{0,1}[A-Za-z\\s]{0,10}$",
            message = "Please enter a valid name")
    private String first_name;

    @Pattern(regexp = "^[A-Za-z\\s]{1,15}[\\.]{0,1}[A-Za-z\\s]{0,10}$",
            message = "Please enter a valid name")
    private String last_name;

    private String time_stamp;

}
