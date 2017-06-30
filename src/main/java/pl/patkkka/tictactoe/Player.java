package pl.patkkka.tictactoe;

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

    //how to handle without it?!
    public String getName() {
        return name;
    }

    public void addPoint(){
        this.score++;
    }
    //how to handle without it?!
    public String getCharacter() {
        return character;
    }
}
