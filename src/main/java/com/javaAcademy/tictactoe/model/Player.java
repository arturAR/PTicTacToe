package com.javaAcademy.tictactoe.model;

/**
 * Created by patrycja on 29.06.17.
 */
public class Player {
    String name;
    int score;
    String character;

    public Player(String name, String character) {
        this.name = name;
        this.character = character;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public void addPoints(int points){
        this.score += points;
    }

    public String getCharacter() {
        return character;
    }

    public void move(Board b){

    }
}
