package com.example.mongodbcrud.encrypted_txt;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.HexFormat;

public class PasswordEncryption {

    public static String toHex(String str) {
        return String.format("%040x", new BigInteger(1, str.getBytes()));
    }

    public static String hexToString(String hexStr) {
        byte[] bytes = HexFormat.of().parseHex(hexStr);
        return new String(bytes, StandardCharsets.UTF_8);
    }

    Argon2PasswordEncoder encoder = new Argon2PasswordEncoder(64,128,4,15*1024,3);

    public String encryptedPassword(String password, String uuid, String random_spec) {

        String uniqueStr = password + uuid + random_spec;
        String encodedPassword = encoder.encode(uniqueStr);
        return toHex(encodedPassword);
    }


    public boolean isValidPassword(String password, String uuid, String random_spec, String hashedPassword) {
        String uniqueStr = password + uuid + random_spec;
        String encryptedStr = hexToString(hashedPassword);
        return encoder.matches(uniqueStr, encryptedStr);

    }
}
