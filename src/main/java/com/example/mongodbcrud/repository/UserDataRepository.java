package com.example.mongodbcrud.repository;

import com.example.mongodbcrud.entity.UserDbAttributes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDataRepository extends MongoRepository<UserDbAttributes, String> {


    UserDbAttributes findByUsername(String username);

    @Query("{'address.city':?0}")
    List<UserDbAttributes> findByCity(String address);

    UserDbAttributes findByUuid(String uuid);
}
