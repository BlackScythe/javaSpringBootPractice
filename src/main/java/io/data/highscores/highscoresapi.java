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

    @Bean
    public CommandLineRunner dummyData(playerrepository repository) {
        return (args) -> {
            // save a couple of players
            repository.save(new player("a",200000000,200000000,200000000,200000000,12345151));
            repository.save(new player("b",123000430,163782987,2123453,1234432,51231232));
            repository.save(new player("c",123412341,345621341,136132451,32134,15314));
            repository.save(new player("d",152344,42345,41234,1254,42345));
            repository.save(new player("e",415345,51451,41255,523455,12345));
            repository.save(new player("f",123456,5142356,6514325,66534,67678));
            repository.save(new player("g",123514325,114235234,1234123457,741234,752345));
            repository.save(new player("h",123415,1234154,12351243,1234512345,1243513425));
            repository.save(new player("i",23451324,24351324,125431345,523451234,2534512));
            repository.save(new player("j",745673456,412341235,123513452,14352345,154134));
            repository.save(new player("k",1235134,1234125,12341234,1354234,412351345));
            repository.save(new player("l",63456345,12341234,34563456,523451234,12341234));
            repository.save(new player("m",12341234,123452343,23452655,124123,12341234));
            repository.save(new player("n",12341234,5324514,234563456,744567,1234));
            repository.save(new player("o",12341234,52345,1523452345,6453634,3456345));
            repository.save(new player("p",12341234,1543534566,4654756,245624,67585678));
        };
    }

}


