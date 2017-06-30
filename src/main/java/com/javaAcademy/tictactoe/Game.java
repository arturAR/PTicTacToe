package com.javaAcademy.tictactoe;

import com.javaAcademy.tictactoe.model.Board;
import com.javaAcademy.tictactoe.model.Match;
import com.javaAcademy.tictactoe.model.Player;
import com.javaAcademy.tictactoe.model.Players;

/**
 * Created by patrycja on 29.06.17.
 */
public class Game {
    Board board;
    Players players = new Players();

    public Game() {

    }
    // should be separated class?
    public void configPlayers(){
        //players creation
        String player1Name = UserIO.userMessageWithInput("Please enter player1 (X) name:");
        Player player1 = new Player(player1Name, "X");
        this.players.addPlayer(player1);

        String player2Name = UserIO.userMessageWithInput("Please enter player2 (O) name:");
        Player player2 = new Player(player2Name,"O");
        this.players.addPlayer(player2);

        String firstPlayerChar = UserIO.userMessageWithInput("Who goes first? (X or O)").trim().toUpperCase();
        this.players.setFirstPlayer(firstPlayerChar);
    }

    // should be separated class?
    public void configBoard(){

        int rows = Integer.parseInt(UserIO.userMessageWithInput("Please enter board rows quantity:"));
        int cols = Integer.parseInt(UserIO.userMessageWithInput("Please enter board columns quantity:"));

        this.board = new Board(rows,cols);
    }

    public void playMatch(){
        Match match = new Match (this.players);
        match.playMatch(this.players,this.board);
    }
}
