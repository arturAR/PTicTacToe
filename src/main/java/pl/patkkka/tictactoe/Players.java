package pl.patkkka.tictactoe;

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
        this.currentPlayer = players.get(character);
    }
}
