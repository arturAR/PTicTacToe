package pl.patkkka.tictactoe;

import java.util.Scanner;

/**
 * Created by patrycja on 28.06.17.
 */
public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        game.configPlayers();
        game.configBoard();
    }
}
