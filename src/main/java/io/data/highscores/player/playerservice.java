package io.data.highscores.player;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class playerservice {

    @Autowired
    private playerrepository playerrepository;

    public List<simplifiedplayerdata> getPlayers (Boolean topTen){
        List<player> players = new ArrayList<>();
        List<simplifiedplayerdata> playersData = new ArrayList<>();
        playerrepository.findAll()
                .forEach(players::add);
        for (player player : players) {
            playersData.add(new simplifiedplayerdata(player.getUserName(), player.getxp()));
        }
        if (topTen){
            /*List<simplifiedplayersData>sortedplayersData = new ArrayList<>();*/
            playersData.sort(Comparator.comparing(p -> p.getScore()));
            Collections.reverse(playersData);
            return playersData.subList(0,10) ;
        }
        return playersData;
    }

}
