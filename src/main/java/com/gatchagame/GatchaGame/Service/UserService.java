package com.gatchagame.GatchaGame.Service;


import com.gatchagame.GatchaGame.Model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findUserByEmail(String email);

}
