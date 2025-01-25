package com.gatchagame.GatchaGame.Dao;


import com.gatchagame.GatchaGame.Model.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {

    Player findByUsername(String username);
    Player findByToken(String token);



}
