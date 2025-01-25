package com.gatchagame.GatchaGame.Services.PlayerServices;

import com.gatchagame.GatchaGame.Dao.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public abstract class AbstractPlayerService {

    @Autowired
    protected PlayerRepository playerRepository;

}
