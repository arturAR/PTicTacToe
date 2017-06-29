package pl.patkkka.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by patrycja on 29.06.17.
 */
public class Game {
    Board board;
    Players players = new Players();

    private static Scanner s = new Scanner(System.in);

    public Game() {

    }
    // should be separated class?
    public void configPlayers(){
        //players creation
        System.out.println("Please enter player1 (X) name:");
        String player1Name = s.nextLine();
        Player player1 = new Player(player1Name);
        this.players.addPlayer(player1,"X");

        System.out.println("Please enter player2 (O) name:");
        String player2Name = s.nextLine();
        Player player2 = new Player(player2Name);
        this.players.addPlayer(player2,"O");

        System.out.println("Who goes first? (X or O)");
        String firstPlayerChar = s.nextLine().trim().toUpperCase();
        this.players.setFirstPlayer(firstPlayerChar);
    }

    // should be separated class?
    public void configBoard(){
        System.out.println("Please enter board rows quantity:");
        int rows = s.nextInt();

        System.out.println("Please enter board columns quantity:");
        int cols = s.nextInt();

        this.board = new Board(rows,cols);
    }


}
