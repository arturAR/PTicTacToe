package com.javaAcademy.tictactoe.end_conditions;

import java.util.ArrayList;
import java.util.List;

import com.javaAcademy.tictactoe.model.Board;

/**
 * Created by patrycja on 30.06.17.
 */
public class WinConditions {
    private List<WinCondition> winConditions = new ArrayList<WinCondition>();

    public WinConditions() {
            WinCondition rowCondition = new RowCondition();
            WinCondition colCondition = new ColumnCondition();
            WinCondition diagCondition = new DiagCondition();
            WinCondition adiagCondition = new AntiDiagCondition();

            winConditions.add(rowCondition);
            winConditions.add(colCondition);
            winConditions.add(diagCondition);
            winConditions.add(adiagCondition);
    }

    public boolean checkIfAnyWinConditionMet(Board b){
        for (WinCondition wcon: this.winConditions){
//            if(wcon.checkCondition(Board b)){
//                return true;
//            }
        }
        return false;
    }
}
