
package com.gatchagame.GatchaGame.Services.AuthService.Impl;

import com.gatchagame.GatchaGame.Dao.PlayerRepository;
import com.gatchagame.GatchaGame.Model.Player;
import com.gatchagame.GatchaGame.Services.AuthService.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service(value = "AuthenticationService")
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private PlayerRepository playerRepository;
    @Override
    public String authenticate(String username, String password) {
        Player player = playerRepository.findByUsername(username);
        if (player != null && player.getPassword().equals(password)) {

            String token = generateToken(username);

            Player authenticatedPlayer= Player.Builder.builder()
                    .id(player.getId())
                    .username(player.getUsername())
                    .password(player.getPassword())
                    .token(token).tokenExpiration(calculateTokenExpiration())
                    .level(player.getLevel())
                    .experience(player.getExperience())
                    .build();
            playerRepository.save(authenticatedPlayer);

            return token;
        } else {
            return null;
        }
    }

    private String generateToken(String username) {
        //  token avec le format  :username-date-time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd-HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        return username + "-" + formattedDateTime;
    }


    private LocalDateTime calculateTokenExpiration() {
        // calcul date d'expiration du token : une heure à partir de maintenant
        return LocalDateTime.now().plusHours(1);
    }

     private boolean isTokenExpired(LocalDateTime expiration) {
        return LocalDateTime.now().isAfter(expiration);
    }
    @Override
    public String validateToken(String token) {
        Player player = playerRepository.findByToken(token);
        if (player != null && !isTokenExpired(player.getTokenExpiration())) {
            return player.getUsername(); // Token valide
        } else {
            return null; // Token expiré ou invalide
        }
    }

}

