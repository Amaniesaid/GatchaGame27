package com.gatchagame.GatchaGame.Dao;

import com.gatchagame.GatchaGame.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepo extends MongoRepository<User, Integer> {
    Optional<User> findByEmail();
}
