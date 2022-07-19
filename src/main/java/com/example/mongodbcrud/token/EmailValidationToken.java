package com.example.mongodbcrud.token;

import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "email_token_db")
public class EmailValidationToken {

    @Id
    private String token_id;

    @NonNull
    private String token;
    @NonNull
    private String issuedAt;
    @NonNull
    private String expiresAt;
    private String verifiedAt;
    @NonNull
    private String user_uuid;
    @NonNull
    private String user_email;
}
