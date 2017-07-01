package com.javaAcademy.tictactoe.model;

import com.javaAcademy.tictactoe.exceptions.IllegalMoveException;
import com.javaAcademy.tictactoe.exceptions.PositionOccupiedException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by patrycja on 29.06.17.
 */
public class Players {

    List<Player> players = new ArrayList<Player>();
    Player currentPlayer;

    public Players() {
    }

    public void addPlayer (Player player){
        players.add(player);
    }

    public void setFirstPlayer (String character){
        for (Player player: players){
            if(player.toString().equals(character)){
                this.currentPlayer = player;
                break;
            }
        }
    }

    public void currentPlayerMove(Board b, int field) throws IllegalMoveException, PositionOccupiedException {

        //b.addMove(field,getCurrentPlayerChar());
    }

    public String getCurrentPlayerName(){
        return currentPlayer.getNick();
    }

    public String getCurrentPlayerChar(){
        return currentPlayer.toString();
    }

    public void givePointsForWinner(int points){
        this.currentPlayer.addPoints(BattleScore.WIN);
    }

}
