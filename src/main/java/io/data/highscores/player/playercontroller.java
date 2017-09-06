package io.data.highscores.player;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;
import java.util.*;

@RestController
public class playercontroller {

    private static final Logger logger = Logger.getLogger(playercontroller.class);

    @Autowired
    private playerservice playerService;

    @RequestMapping(method = RequestMethod.GET, value = "/players")
    public List<simplifiedplayerdata> getAllPlayers() {
        logger.info("Request for all players");
        return playerService.getPlayers(false);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/players/{name}")
    public ResponseEntity<String> getPlayer(@PathVariable String name) {
        logger.info("Getting info");
        player player = playerService.getPlayer(name);
        Map<String,String > body = new HashMap<String, String>();
        if (player == null) {
            body.put("error", "404");
            body.put("message", name+" not found.");
            return new ResponseEntity(body, HttpStatus.NOT_FOUND);

        }
        simplifiedplayerdata simplifiedPlayerData = new simplifiedplayerdata(player.getUserName(),player.getxp());
        body.put("userName", simplifiedPlayerData.getUserName());
        body.put("LVL", Long.toString(simplifiedPlayerData.getLvl()));
        body.put("Score", Long.toString(simplifiedPlayerData.getScore()));
        return new ResponseEntity(body, HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/players/topten")
    public List<simplifiedplayerdata> getTopTen (){
        logger.info("Request for top 10 players");
        return playerService.getPlayers(true);
    }

    @RequestMapping(method = RequestMethod.GET, value ="/players/extended")
    public List<player> getExtendedPlayers() {
        logger.info("Request for extended player data");
        return playerService.getExtendedPlayers();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/players/populate")
    public List<player> populate() {
        logger.info("Call for populate player db");
        return playerService.populate();
    }

    @RequestMapping(method = RequestMethod.GET, value ="/players/{player1Id}/{player2Id}")
    public ResponseEntity<String> comparePlayers (@PathVariable String player1Id, @PathVariable String player2Id){
        logger.info("Comparing players...");
        return playerService.comparePlayers(player1Id, player2Id);
    }

    @RequestMapping(value = {"/players",""}, method = {RequestMethod.PUT,RequestMethod.DELETE, RequestMethod.HEAD, RequestMethod.OPTIONS, RequestMethod.PATCH, RequestMethod.POST, RequestMethod.TRACE})
    public ResponseEntity<String> defaultResponse(HttpServletRequest request) {
        Map<String, String> body = new HashMap<>();
        body.put("status", HttpStatus.METHOD_NOT_ALLOWED.toString());
        body.put("error", HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase());
        body.put("message", "Oops! Method not implemented yet for: "+request.getMethod());
        body.put("path", request.getRequestURI());
        return new ResponseEntity(body, HttpStatus.METHOD_NOT_ALLOWED);
    }
}
