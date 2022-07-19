package com.example.mongodbcrud.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class TokenVerificationService {

    @Autowired
    private TokenRepository tokenRepository;

    public String issueNewToken(String uuid, String email) {

        String token = UUID.randomUUID().toString();
        String issuedAt = LocalDateTime.now().toString();
        String expiresAt = LocalDateTime.now().plusMinutes(15).toString();
        EmailValidationToken validationToken = new EmailValidationToken(
                UUID.randomUUID().toString(), token, issuedAt, expiresAt, null, uuid, email
        );
        tokenRepository.save(validationToken);
        return token;
    }
}
