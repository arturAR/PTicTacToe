package com.javaAcademy.tictactoe.exceptions;

/**
 * Created by patrycja on 29.06.17.
 */
public class PositionOccupiedException extends Throwable{
    public PositionOccupiedException() {
    }

    public PositionOccupiedException(String message) {
        super(message);
    }
}
