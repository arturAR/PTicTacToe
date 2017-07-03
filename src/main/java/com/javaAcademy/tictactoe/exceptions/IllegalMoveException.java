package com.javaAcademy.tictactoe.exceptions;

/**
 * Created by patrycja on 29.06.17.
 */
public class IllegalMoveException extends RuntimeException {
	
	private static final long serialVersionUID = -4493172789714300899L;

	public IllegalMoveException() {
    }

    public IllegalMoveException(String message) {
        super(message);
    }
}
