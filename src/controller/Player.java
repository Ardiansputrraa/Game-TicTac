package controller;

public class Player {
    private static String playerA, playerB, pemenang;

    public Player(String playerA, String playerB, String pemenang) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.pemenang = pemenang;
    }

    public Player(String playerA, String playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }

    public Player(String playerA) {
        this.playerA = playerA;
    }

    public Player() {

    }

    public String getPlayerA() {
        return this.playerA;
    }

    public void setPlayerA(String player) {
        this.playerA = player;
    }

    public String getPlayerB() {
        return this.playerB;
    }

    public void setPlayerB(String player) {
        this.playerB = playerB;
    }

    public String getPemenang() {
        return this.pemenang;
    }

    public void setPemenang(String pemenang) {
        this.pemenang = pemenang;
    }
}
