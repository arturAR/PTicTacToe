package pl.patkkka.tictactoe;

import java.util.Scanner;

/**
 * Created by patrycja on 30.06.17.
 */
public class Match {

    private static Scanner s = new Scanner(System.in);

    public Match() {
    }

    public void playMatch(Players players){
        while(true){
            System.out.println(players.getCurrentPlayerName() + "'s turn: " +
                    " \nPlease insert field value, where you want to put your character and press Enter");
            int field = s.nextInt();

            if (currentPlayer.move(x,y,board)) {
                // available move
                board.printBoardState();

                if (checkGameWon()) {
                    System.out.println("Game finished!");
                    System.out.println("The winner is " + currentPlayer.getGameChar());
                    currentPlayer.addPoint();
                    break;
                }
                if (checkGameTie()) {
                    System.out.println("Game finished! Board is full. There is no winner.");
                    break;
                }
                currentPlayer = nextPlayer();
            } else
            {
                System.out.println("This field is not empty!");
            }
        }
    }
}
