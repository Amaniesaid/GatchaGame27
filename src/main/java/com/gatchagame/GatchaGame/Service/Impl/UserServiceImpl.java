package com.gatchagame.GatchaGame.Service.Impl;

import com.gatchagame.GatchaGame.Dao.UserRepo;
import com.gatchagame.GatchaGame.Model.User;
import com.gatchagame.GatchaGame.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service(value = "User Service Implementation")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Override
    public Optional<User> findUserByEmail(String email){
        return userRepo.findByEmail();
    }
}
