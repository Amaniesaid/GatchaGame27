package com.gatchagame.GatchaGame.Services.PlayerServices.Impl;

import com.gatchagame.GatchaGame.Model.Player;
import com.gatchagame.GatchaGame.Services.PlayerServices.AbstractPlayerService;
import com.gatchagame.GatchaGame.Services.PlayerServices.DeletePlayerService;
import org.springframework.stereotype.Service;

@Service(value = "DeleteUserService")
public class DeletePlayerServiceImpl extends AbstractPlayerService implements DeletePlayerService {

    @Override
    public void execute(String username){
        Player player = playerRepository.findByUsername(username);
        //TODO: Verifier si le user n'est pas null
        playerRepository.delete(player);
    }
}
