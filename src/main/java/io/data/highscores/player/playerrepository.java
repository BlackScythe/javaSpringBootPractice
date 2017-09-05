package io.data.highscores.player;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface playerrepository extends CrudRepository<player, Long> {
    public player findOneByuserName(String userName);
}
