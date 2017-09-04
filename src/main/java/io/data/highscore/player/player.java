package io.data.highscore.player;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class player {

    @Id
//  @GeneratedValue(strategy  = GenerationType.AUTO)
    private long _id;

    private String userName;
    private int overall;
    private int attack;
    private int defense;
    private int magic;
    private int cooking;
    private int crafting;

    public player() {
    }

    public player(String userName, int attack, int defense, int magic, int cooking, int crafting) {
        this.userName = userName;
        this.attack = attack;
        this.defense = defense;
        this.magic = magic;
        this.cooking = cooking;
        this.crafting = crafting;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getOverall() {
        return overall;
    }

    public void setOverall(int overall) {
        this.overall = overall;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getCooking() {
        return cooking;
    }

    public void setCooking(int cooking) {
        this.cooking = cooking;
    }

    public int getCrafting() {
        return crafting;
    }

    public void setCrafting(int crafting) {
        this.crafting = crafting;
    }
}
