package com.armando.shop.repository;

import com.armando.shop.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends MongoRepository<Users, String> {
//    Users findByUsername(String username);
}
