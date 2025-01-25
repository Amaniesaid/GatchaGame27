package com.gatchagame.GatchaGame.Services.PlayerServices;

import com.gatchagame.GatchaGame.Model.Player;

public interface GetPlayerService {
     Player byUserName(String  username);

     Player byToken(String token);
}
