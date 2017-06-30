package pl.patkkka.tictactoe;

import pl.patkkka.tictactoe.end_conditions.DrawCondition;
import pl.patkkka.tictactoe.end_conditions.WinConditions;
import pl.patkkka.tictactoe.exceptions.IllegalMoveException;
import pl.patkkka.tictactoe.exceptions.PositionOccupiedException;

import java.util.Scanner;

/**
 * Created by patrycja on 30.06.17.
 */
public class Match {
    private Players players = new Players();
    private WinConditions winConditions = new WinConditions();
    private DrawCondition drawCondition = new DrawCondition();
    final private int POINTS_FOR_DRAW = 1;
    final private int POINTS_FOR_WIN = 3;


    private static Scanner s = new Scanner(System.in);

    public Match(Players players) {
        this.players = players;
    }

    public void playMatch(Players players, Board b){
        while(true){
            b.printBoard();
            System.out.println(players.getCurrentPlayerName() + "'s turn: " +
                    " \nPlease insert field value, where you want to put your character and press Enter");
            int field = s.nextInt();

            try {
                //move
                players.currentPlayerMove(b,field);
                //check match won
                if(winConditions.checkIfAnyWinConditionMet(b)){
                    players.givePointsForWinner(POINTS_FOR_WIN);
                    System.out.println("Match finished!" +
                                    '\n' + "The winner is " + players.getCurrentPlayerName());
                    break;
                }
                //check match draw
                if(drawCondition.checkIfDrawConditionMet(b)){
                    players.givePointsForDraw(POINTS_FOR_DRAW);
                    System.out.println("Match draw! Board is full. There is no winner.");
                    break;
                }
                //next player
                players.nextPlayer();

            } catch (IllegalMoveException e) {
                System.out.println("This field is out of board! Please select another");
            } catch (PositionOccupiedException e) {
                System.out.println("This field is not empty! Please select another");
            }

        }
    }
}
