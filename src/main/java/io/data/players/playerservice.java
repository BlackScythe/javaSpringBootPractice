package io.data.players;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class playerservice {
    @Autowired
    private player_repository playerrepository;

    public List<player> getAllPlayers (){
        List<player> players = new ArrayList<>();
        playerrepository.findAll()
                .forEach(players::add);
        return players;
    }

    public List<player> getTop10 () {
        List<player> allPlayers = new ArrayList<>();
        allPlayers = this.getAllPlayers();
        List<player> sortedPlayers = allPlayers.stream()
                .sorted((p1, p2)-> Integer.compare(p1.getOverall(), p2.getOverall()))
                .collect(Collectors.toList());
        return sortedPlayers.subList(0,9);
    }


}
