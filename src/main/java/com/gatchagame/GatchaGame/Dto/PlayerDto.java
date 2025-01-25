package com.gatchagame.GatchaGame.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gatchagame.GatchaGame.Model.Player;
import lombok.Getter;
import org.apache.commons.lang3.ObjectUtils;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class PlayerDto implements Serializable {
    
    @JsonProperty("username")
    protected String username;
    @JsonProperty("password")
    protected String password;
    @JsonProperty("token")
    protected String token;
    @JsonProperty("local_date_time")
    protected LocalDateTime tokenExpiration;
    @JsonProperty("level")
    protected int level;
    @JsonProperty("experience")
    protected int experience;

    /**
     * Default constructor for JSON Serializer
     */
    protected PlayerDto(){super();}

    private PlayerDto(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.token = builder.token;
        this.tokenExpiration = builder.tokenExpiration;
        this.level = builder.level;
        this.experience = builder.experience; 
    }
    
    public  boolean isValid(){
        return ObjectUtils.allNotNull(username, password);
    }



    public static final class Builder {
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


        public PlayerDto build() {
            return new PlayerDto(this);
        }
    }

    public Player toPlayerEntity(){
        return Player.Builder.builder()
                .username(this.username)
                .password(this.password)
                .token(this.token)
                .tokenExpiration(this.tokenExpiration)
                .level(this.level)
                .experience(this.experience)
                .build();
    }
}
