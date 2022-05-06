package com.armando.shop.repository;

import com.armando.shop.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findByNome(String nome);
}
