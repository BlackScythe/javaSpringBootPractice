package io.data.highscores.player;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

@Service
public class playerservice {

    @Autowired
    private playerrepository playerRepository;

    private static final Logger logger = Logger.getLogger(playercontroller.class);
    private List<simplifiedplayerdata> player;


    public playerservice(io.data.highscores.player.playerrepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public playerservice() {
    }

    public io.data.highscores.player.playerrepository getPlayerrepository() {
        return playerRepository;
    }

    public void setPlayerrepository(io.data.highscores.player.playerrepository playerrepository) {
        this.playerRepository = playerRepository;
    }

    public player getPlayer(String userName) {
        player player = playerRepository.findOneByuserName(userName);
        return player;
    }

    public List<simplifiedplayerdata> getPlayers (Boolean topTen){
        List<player> players = new ArrayList<>();
        List<simplifiedplayerdata> playersData = new ArrayList<>();
        this.playerRepository.findAll()
                .forEach(players::add);
        for (player player : players) {
            playersData.add(new simplifiedplayerdata(player.getUserName(), player.getxp()));
        }
        if (topTen){
            playersData.sort(Comparator.comparing(p -> p.getScore()));
            Collections.reverse(playersData);
            return playersData;
        }
        return playersData;
    }

    public List<player> getExtendedPlayers() {
        List<player> players = new ArrayList<>();
        this.playerRepository.findAll()
                .forEach(players::add);
        return players;
    }

    public ResponseEntity<String> comparePlayers(String player1Id, String player2Id) {
        ResponseEntity<String> response;
        if (this.playerRepository.count()!=0){
            player player1 = this.playerRepository.findOne(Long.valueOf(player1Id));
            player player2 = this.playerRepository.findOne(Long.valueOf(player2Id));
            if (Long.compare(player1.getxp(),player2.getxp())> 0) {
                response = compareResponseBodyBuilder(player1);
                logger.info(player1.getUserName()+" is higher level than "+ player2.getUserName());
            } else {
                response =  compareResponseBodyBuilder(player2);
                logger.info(player2.getUserName()+" is higher level than "+ player1.getUserName());

            }
            return response;
        }
        Map<String,String> body = new HashMap<String,String>();
        body.put("status", "512");
        body.put("Error", "Internal Server Error");
        body.put("message", "Database is empty, please populate @ /players/populate");
        return new ResponseEntity(body, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> compareResponseBodyBuilder (player player){
        Map<String,String> body = new HashMap<String,String>();
        body.put("Dominating Player", player.getUserName());
        body.put("xp", Long.toString(player.getxp()));
        return new ResponseEntity(body, HttpStatus.ACCEPTED);
    }

    public List<player> populate() {
            // save a couple of players
        List<player> players = new ArrayList<>();
            playerRepository.save(new player("a",200000000,200000000,200000000,200000000,12345151));
            playerRepository.save(new player("b",123000430,163782987,2123453,1234432,51231232));
            playerRepository.save(new player("c",123412341,345621341,136132451,32134,15314));
            playerRepository.save(new player("d",152344,42345,41234,1254,42345));
            playerRepository.save(new player("e",415345,51451,41255,523455,12345));
            playerRepository.save(new player("f",123456,5142356,6514325,66534,67678));
            playerRepository.save(new player("g",123514325,114235234,1234123457,741234,752345));
            playerRepository.save(new player("h",123415,1234154,12351243,1234512345,1243513425));
            playerRepository.save(new player("i",23451324,24351324,125431345,523451234,2534512));
            playerRepository.save(new player("j",745673456,412341235,123513452,14352345,154134));
            playerRepository.save(new player("k",1235134,1234125,12341234,1354234,412351345));
            playerRepository.save(new player("l",63456345,12341234,34563456,523451234,12341234));
            playerRepository.save(new player("m",12341234,123452343,23452655,124123,12341234));
            playerRepository.save(new player("n",12341234,5324514,234563456,744567,1234));
            playerRepository.save(new player("o",12341234,52345,1523452345,6453634,3456345));
            playerRepository.save(new player("p",12341234,1543534566,4654756,245624,67585678));
            playerRepository
                    .findAll()
                    .forEach(players::add);
            return players;
    }
}
