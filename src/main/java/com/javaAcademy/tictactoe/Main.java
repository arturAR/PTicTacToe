package com.javaAcademy.tictactoe;

/**
 * Created by patrycja on 28.06.17.
 */
public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        game.configPlayers();
        game.configBoard();
        game.playMatch();
    }
}
