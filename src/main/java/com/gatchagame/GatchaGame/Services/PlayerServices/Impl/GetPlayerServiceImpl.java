package com.gatchagame.GatchaGame.Services.PlayerServices.Impl;

import com.gatchagame.GatchaGame.Model.Player;
import com.gatchagame.GatchaGame.Services.PlayerServices.AbstractPlayerService;
import com.gatchagame.GatchaGame.Services.PlayerServices.GetPlayerService;
import org.springframework.stereotype.Service;

@Service(value = "GetUserService")
public class GetPlayerServiceImpl extends AbstractPlayerService implements GetPlayerService {

    @Override
    public Player byUserName(String username){

        //TODO : Faire le check au cas où le User serait vide ie Null
        return this.playerRepository.findByUsername(username);
    }

    @Override

    public Player byToken(String token){
        //TODO : Faire le check au cas où le User serait vide ie Null
        return this.playerRepository.findByToken(token);
    }
}
