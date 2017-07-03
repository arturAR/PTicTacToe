package com.javaAcademy.tictactoe.exceptions;

/**
 * Created by patrycja on 29.06.17.
 */
public class PositionOccupiedException extends Throwable{

	private static final long serialVersionUID = -2383687358910715402L;

	public PositionOccupiedException() {
    }

    public PositionOccupiedException(String message) {
        super(message);
    }
}
