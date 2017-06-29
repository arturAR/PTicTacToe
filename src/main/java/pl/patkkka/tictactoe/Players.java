package pl.patkkka.tictactoe;

import pl.patkkka.tictactoe.exceptions.IllegalMoveException;
import pl.patkkka.tictactoe.exceptions.PositionOccupiedException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by patrycja on 29.06.17.
 */
public class Players {
  //  List<Player> players;
    Map<String,Player> players = new HashMap<>();
    Player currentPlayer;

    public Players() {
    }

    public void addPlayer (Player player, String character){
        players.put(character,player);
    }

    public void setFirstPlayer (String character){
        this.currentPlayer = this.players.get(character);
    }

    public void currentPlayerMove(Board b, int field) throws IllegalMoveException, PositionOccupiedException {

        b.addMove(field,getCurrentPlayerChar());

    }

    //how to handle without it!?
    public String getCurrentPlayerName(){
        return currentPlayer.getName();
    }
    public String getCurrentPlayerChar(){
        for (Map.Entry<String,Player> e : this.players.entrySet()){
            if (currentPlayer.equals(e.getValue())){
                return e.getKey();
            }
        }
        //???
        return null;
    }
}
