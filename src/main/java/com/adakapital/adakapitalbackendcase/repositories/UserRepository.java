package com.adakapital.adakapitalbackendcase.repositories;

import com.adakapital.adakapitalbackendcase.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
