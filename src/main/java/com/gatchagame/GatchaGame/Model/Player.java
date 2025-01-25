package com.gatchagame.GatchaGame.Model;



import com.gatchagame.GatchaGame.Dto.PlayerDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@NoArgsConstructor(force = true)
@Document(collection = "users")

public class Player {

    @Id
    private String id;
    @NotBlank
    private final String username;
    private final String password;
    private final String token;
    private final LocalDateTime tokenExpiration;
    @NotNull
    private final int level;
    private final int experience;


    /**
     * Constructeur que Spring Data utilisera pour hydrater l'entité depuis la base.
     * Les noms et l'ordre des paramètres doivent correspondre aux champs.
     */
    @PersistenceConstructor
    public Player(String id,
                  String username,
                  String password,
                  String token,
                  LocalDateTime tokenExpiration,
                  int level,
                  int experience) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.token = token;
        this.tokenExpiration = tokenExpiration;
        this.level = level;
        this.experience = experience;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getToken() {
        return token;
    }

    public LocalDateTime getTokenExpiration() {
        return tokenExpiration;
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    private Player(Builder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.password = builder.password;
        this.token = builder.token;
        this.tokenExpiration = builder.tokenExpiration;
        this.level = builder.level;
        this.experience = builder.experience;
    }



    public static final class Builder {
        private String id;
        private String username;
        private String password;
        private String token;
        private LocalDateTime tokenExpiration;
        private int level;
        private int experience;

        private Builder(){}
        public static Builder builder() {
            return new Builder();
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public Builder tokenExpiration(LocalDateTime tokenExpiration) {
            this.tokenExpiration = tokenExpiration;
            return this;
        }

        public Builder level(int level) {
            this.level = level;
            return this;
        }

        public Builder experience(int experience) {
            this.experience = experience;
            return this;
        }


        public Player build() {
            return new Player(this);
        }
    }


    public PlayerDto toPlayerDtoEntity(){
        return PlayerDto.Builder.builder()
                .username(this.username)
                .password(this.password)
                .token(this.token)
                .tokenExpiration(this.tokenExpiration)
                .level(this.level)
                .experience(this.experience)
                .build();
    }
}
