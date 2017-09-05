package io.data.highscores.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class playercontroller {

    @Autowired
    private playerservice playerService;

    @RequestMapping("/players")
    public List<simplifiedplayerdata> getAllPlayers() {
        return playerService.getPlayers(false);
    }

    @RequestMapping("/players/topten")
    public List<simplifiedplayerdata> getTopTen (){
        return playerService.getPlayers(true);
    }
}
