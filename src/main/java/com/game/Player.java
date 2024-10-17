package com.game;



public class Player {

    private String name;
    private int gamesPlayed;

    public Player(String name) {
        this.name = name;
        this.gamesPlayed = 0;
    }

    public String getName() {
        return name;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void incrementGamesPlayed() {
        this.gamesPlayed++;
    }
}
