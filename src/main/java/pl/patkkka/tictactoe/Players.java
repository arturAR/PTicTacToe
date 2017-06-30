package pl.patkkka.tictactoe;

import pl.patkkka.tictactoe.exceptions.IllegalMoveException;
import pl.patkkka.tictactoe.exceptions.PositionOccupiedException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by patrycja on 29.06.17.
 */
public class Players {
    // map idea was to store characters not inside Player object...
//    Map<String,Player> playersWithChars = new HashMap<>();
    List<Player> players = new ArrayList<>();
    Player currentPlayer;

    public Players() {
    }



    public void addPlayer (Player player){
        players.add(player);
    }

    // this was implementation for map
  //  public void setFirstPlayer (String character){
//        this.currentPlayer = this.players.get(character);
//    }

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

    //how to handle without it!?
    public String getCurrentPlayerName(){
        return currentPlayer.getName();
    }

    //this was implementation with map
//    public String getCurrentPlayerChar(){
//        for (Map.Entry<String,Player> e : this.players.entrySet()){
//            if (currentPlayer.equals(e.getValue())){
//                return e.getKey();
//            }
//        }
//        //???
//        return null;
//    }

    //how to handle without it!?
    public String getCurrentPlayerChar(){
        return currentPlayer.getCharacter();
    }

    public void addPointToCurrentPlayer(){
        this.currentPlayer.addPoint();
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
