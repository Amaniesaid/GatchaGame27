package com.gatchagame.GatchaGame.Services.PlayerServices.Impl;

import com.gatchagame.GatchaGame.Model.Player;
import com.gatchagame.GatchaGame.Services.PlayerServices.AbstractPlayerService;
import com.gatchagame.GatchaGame.Services.PlayerServices.AddPlayerService;
import org.springframework.stereotype.Service;

@Service(value = "AddUserService")
public class AddPlayerServiceImpl extends AbstractPlayerService implements AddPlayerService {

    @Override
    public void execute(Player player){
        this.playerRepository.save(player);
    }
}
