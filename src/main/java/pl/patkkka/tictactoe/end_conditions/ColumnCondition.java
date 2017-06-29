package pl.patkkka.tictactoe.end_conditions;

/**
 * Created by Patka on 2017-05-29.
 */
public class ColumnCondition extends WinCondition{

    public ColumnCondition() {
    }

    @Override
    public boolean checkCondition(int x, int y, char currentChar, char[][] boardState) {
        int n = boardState.length;
        //iterate columns
        for (int i = 0; i < n; i++){
            if (boardState[x][i] != currentChar){
                break;
            }
            if (i == n-1){
                return true;
            }
        }
        return false;
    }
}
