package com.gatchagame.GatchaGame.DaoTest;

import com.gatchagame.GatchaGame.Dao.PlayerRepository;
import com.gatchagame.GatchaGame.Model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.time.LocalDateTime;

@DataMongoTest
class PlayerRepoTest {

    @Autowired
    private PlayerRepository userRepository;

    private final static String USERNAME = "USERNAME";
    private final static String PASSWORD = "PASSWORD";
    private final static String TOKEN = "TOKEN";
    private final static LocalDateTime TOKEN_EXPIRATION = LocalDateTime.now().plusHours(1);
    private final static int LEVEL = 1;
    private final static int EXPERIENCE = 1000;

    @BeforeEach
    void setUp() {
        //efface la collection users avant chaque test pour assurer un état propre
        userRepository.deleteAll();
    }

    @Test
    void testSaveUser() {
        Player player = Player.Builder.builder()
                .id("1")
                .username(USERNAME)
                .password(PASSWORD)
                .token(TOKEN)
                .tokenExpiration(TOKEN_EXPIRATION)
                .level(LEVEL)
                .experience(EXPERIENCE)
                .build();

       userRepository.save(player);


    }
}
