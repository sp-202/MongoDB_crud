package com.example.mongodbcrud;

import com.example.mongodbcrud.encrypted_txt.PasswordEncryption;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class MongoDbCrudApplication {
    public static void main(String[] args) {
        SpringApplication.run(MongoDbCrudApplication.class, args);
        PasswordEncryption encryption = new PasswordEncryption();
        String password = "Subhodeep";
        String uuid = "38943nmfdfj943i4934indfndwf";
        String random = "38ure39eucbndcbdch";
        String str = encryption.encryptedPassword(password, uuid, random);
        System.out.println(encryption.isValidPassword(password, uuid, random, str));
    }

}
