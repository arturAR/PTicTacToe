package pl.patkkka.tictactoe;

import pl.patkkka.tictactoe.end_conditions.DrawCondition;
import pl.patkkka.tictactoe.end_conditions.WinConditions;
import pl.patkkka.tictactoe.exceptions.IllegalMoveException;
import pl.patkkka.tictactoe.exceptions.PositionOccupiedException;

/**
 * Created by patrycja on 30.06.17.
 */
public class Match {
    private Players players = new Players();
    private WinConditions winConditions = new WinConditions();
    private DrawCondition drawCondition = new DrawCondition();
    final private int POINTS_FOR_DRAW = 1;
    final private int POINTS_FOR_WIN = 3;


    public Match(Players players) {
        this.players = players;
    }

    public void playMatch(Players players, Board b){
        while(true){
            b.printBoard();
            int field = Integer.parseInt(UserIO.userMessageWithInput(players.getCurrentPlayerName() + "'s turn: " +
                    " \nPlease insert field value, where you want to put your character and press Enter"));

            try {
                //move
                players.currentPlayerMove(b,field);
                //check match won
                if(winConditions.checkIfAnyWinConditionMet(b)){
                    players.givePointsForWinner(POINTS_FOR_WIN);
                    UserIO.showUserMessage("Match finished!" +
                            '\n' + "The winner is " + players.getCurrentPlayerName());
                    break;

                }
                //check match draw
                if(drawCondition.checkIfDrawConditionMet(b)){
                    players.givePointsForDraw(POINTS_FOR_DRAW);
                    UserIO.showUserMessage("Match draw! Board is full. There is no winner.");
                    break;
                }
                //next player
                players.nextPlayer();

            } catch (IllegalMoveException e) {
                UserIO.showUserMessage("This field is out of board! Please select another");
            } catch (PositionOccupiedException e) {
                UserIO.showUserMessage("This field is not empty! Please select another");
            }
        }
    }


}
