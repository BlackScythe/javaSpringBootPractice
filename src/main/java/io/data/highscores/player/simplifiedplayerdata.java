package io.data.highscores.player;

import java.security.PrivateKey;

public class simplifiedplayerdata {
    private String userName;
    private long lvl;
    private long score;

    public simplifiedplayerdata(String userName, long score) {
        this.userName = userName;
        this.lvl = score/2000000;
        this.score = score;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getLvl() {
        return lvl;
    }

    public void setLvl(long lvl) {
        this.lvl = lvl;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }
}
