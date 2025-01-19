package com.gatchagame.GatchaGame.Controller;

import com.gatchagame.GatchaGame.Model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {


    @PostMapping("/login")
    public User userAuthentification(@RequestBody String username){
        return user.find
    }

    @PostMapping("/signup")

    @GetMapping("/users")

    @GetMapping("/users/me")
}
