package com.example.mongodbcrud.service;

import com.example.mongodbcrud.entity.UserDbAttributes;
import com.example.mongodbcrud.entity.UserDetails;
import com.example.mongodbcrud.entity.UserRegistrationPayload;
import com.example.mongodbcrud.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDataRepository userDataRepository;

    public boolean registerUser(UserRegistrationPayload payload) {
        if (userDataRepository.findByUsername(payload.getUsername()) == null) {
            UserDbAttributes userAttributes = new UserDbAttributes(
                    payload.getUuid(), payload.getUsername(), payload.getPassword(),
                    payload.getTime_stamp(), null, null, new UserDetails(null, payload.getEmail(),
                    null, payload.getFirst_name(), payload.getLast_name())
            );
            userDataRepository.save(userAttributes);
            return true;
        } else {
            return false;
        }
    }
}
