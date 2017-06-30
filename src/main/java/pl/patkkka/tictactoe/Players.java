package pl.patkkka.tictactoe;

import pl.patkkka.tictactoe.exceptions.IllegalMoveException;
import pl.patkkka.tictactoe.exceptions.PositionOccupiedException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by patrycja on 29.06.17.
 */
public class Players {

    List<Player> players = new ArrayList<>();
    Player currentPlayer;

    public Players() {
    }

    public void addPlayer (Player player){
        players.add(player);
    }

    public void setFirstPlayer (String character){
        for (Player player: players){
            if(player.getCharacter().equals(character)){
                this.currentPlayer = player;
                break;
            }
        }
    }

    public void currentPlayerMove(Board b, int field) throws IllegalMoveException, PositionOccupiedException {

        b.addMove(field,getCurrentPlayerChar());
    }

    public String getCurrentPlayerName(){
        return currentPlayer.getName();
    }

    public String getCurrentPlayerChar(){
        return currentPlayer.getCharacter();
    }

    public void givePointsForWinner(int points){
        this.currentPlayer.addPoints(points);
    }

    public void givePointsForDraw(int points) {
        for (Player p: this.players){
            p.addPoints(points);
        }
    }

    public void nextPlayer(){
        int currentPlayerIndex = this.players.indexOf(currentPlayer);
        if (currentPlayerIndex == this.players.size()-1){
            this.currentPlayer = this.players.get(0);
        } else {
            this.currentPlayer = this.players.get(currentPlayerIndex + 1);
        }
    }

}
