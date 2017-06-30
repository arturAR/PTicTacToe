package com.javaAcademy.tictactoe.exceptions;

/**
 * Created by patrycja on 29.06.17.
 */
public class IllegalMoveException extends Throwable{
    public IllegalMoveException() {
    }

    public IllegalMoveException(String message) {
        super(message);
    }
}
