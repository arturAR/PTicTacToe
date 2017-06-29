package pl.patkkka.tictactoe.end_conditions;

import pl.patkkka.tictactoe.Board;

/**
 * Created by Patka on 2017-05-29.
 */
public class RowCondition extends WinCondition {

    public RowCondition() {
    }

    @Override
    public boolean checkCondition(int x, int y, char currentChar, Board board)) {
        int n = boardState[0].length;
        //iterate rows
        for (int i = 0; i < n; i++){
            if (boardState[i][y] != currentChar){
                break;
            }
            if (i == n-1){
                return true;
            }
        }
        return false;
    }
}
