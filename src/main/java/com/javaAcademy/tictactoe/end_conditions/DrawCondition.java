package com.javaAcademy.tictactoe.end_conditions;

import com.javaAcademy.tictactoe.model.Board;

/**
 * Created by patrycja on 30.06.17.
 */
public class DrawCondition {
    public DrawCondition() {
    }

    public boolean checkIfDrawConditionMet(Board b){
        return b.checkIfBoardFull();
    }
}
