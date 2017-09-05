package io.data.highscores.player;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class player {

    @Id
    @GeneratedValue(strategy  = GenerationType.AUTO)
    private long id;
    private String userName;
    private long xp;
    private long attack;
    private long defense;
    private long magic;
    private long cooking;
    private long crafting;

    public player(String userName, long attack, long defense, long magic, long cooking, long crafting) {
        this.userName = userName;
        this.attack = attack;
        this.defense = defense;
        this.magic = magic;
        this.cooking = cooking;
        this.crafting = crafting;
        this.xp = attack+defense+magic+cooking+crafting;
    }

    public player() {
    }

    public long getid() {
        return id;
    }

    public void setid(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getxp() {
        return xp;
    }

    public void setxp(long xp) {
        this.xp = xp;
    }

    public long getAttack() {
        return attack;
    }

    public void setAttack(long attack) {
        this.attack = attack;
    }

    public long getDefense() {
        return defense;
    }

    public void setDefense(long defense) {
        this.defense = defense;
    }

    public long getMagic() {
        return magic;
    }

    public void setMagic(long magic) {
        this.magic = magic;
    }

    public long getCooking() {
        return cooking;
    }

    public void setCooking(long cooking) {
        this.cooking = cooking;
    }

    public long getCrafting() {
        return crafting;
    }

    public void setCrafting(long crafting) {
        this.crafting = crafting;
    }
}
