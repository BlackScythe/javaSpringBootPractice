package io.data.highscores;

import io.data.highscores.player.player;
import io.data.highscores.player.playerrepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class highscoresapi {
    public static void main (String[] args){
        SpringApplication.run(highscoresapi.class, args);
    }

}


