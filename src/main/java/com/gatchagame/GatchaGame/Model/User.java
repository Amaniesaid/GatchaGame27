package com.gatchagame.GatchaGame.Model;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "Users")
@Data
public class User {

    @Id
    @NotNull
    private Integer id;

    @Max(value = 25)
    private String name;

    @Max(value = 100)
    @NotNull
    private String email;
    @NotNull
    private String password;

    private String token;

    private int lastActivityTime;

}
