package com.gatchagame.GatchaGame.Services.AuthService;

import com.gatchagame.GatchaGame.Dao.PlayerRepository;

import java.time.LocalDateTime;

public interface AuthenticationService {
    String authenticate(String username, String password);

     String validateToken(String token);
}
