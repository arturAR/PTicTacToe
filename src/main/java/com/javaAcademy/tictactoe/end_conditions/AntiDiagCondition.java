package com.javaAcademy.tictactoe.end_conditions;

/**
 * Created by Patka on 2017-05-29.
 */
public class AntiDiagCondition extends WinCondition {

    public AntiDiagCondition() {
    }
    //to be implemented

//    @Override
//    public boolean checkCondition(int x, int y, char currentChar, char[][] boardState) {
//        int n = boardState.length;
//        if (x + y == n - 1) {
//            for (int i = 0; i < n; i++) {
//                if (boardState[i][(n - 1) - i] != currentChar) {
//                    break;
//                }
//                if (i == n - 1) {
//
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}
