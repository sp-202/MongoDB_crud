package com.example.mongodbcrud.controllers;


import com.example.mongodbcrud.encrypted_txt.PasswordEncryption;
import com.example.mongodbcrud.entity.UserRegistrationPayload;
import com.example.mongodbcrud.service.UserService;
import com.example.mongodbcrud.token.TokenVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "http://localhost:3000/")
public class UserRegisterController {

    PasswordEncryption passwordEncryption = new PasswordEncryption();

    @Autowired
    private UserService userService;

    @Autowired
    private TokenVerificationService tokenVerificationService;

    @PostMapping("/create_user")
    public ResponseEntity<String> createUser(@RequestBody @Valid UserRegistrationPayload payload) {
        System.out.println(payload);

        if (userService.registerUser(payload)) {
            String uuid = UUID.randomUUID().toString();
            payload.setUuid(uuid);
            payload.setTime_stamp(LocalDateTime.now().toString());
            String password = payload.getPassword();
            payload.setPassword(passwordEncryption.encryptedPassword(password, uuid, "dhwfhef9434394"));
            String verificationToken = tokenVerificationService.issueNewToken(uuid, payload.getEmail());
            return new ResponseEntity<>("Please verify your email-id" + verificationToken, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Username is already taken", HttpStatus.CONFLICT);
        }
    }
}
