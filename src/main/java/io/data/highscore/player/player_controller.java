package io.data.highscore.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class player_controller {

    @Autowired
    private player_service playerService;

    @RequestMapping("/players")
    public List<player> getAllPlayers() {
        return playerService.getAllPlayers();
    }
}
