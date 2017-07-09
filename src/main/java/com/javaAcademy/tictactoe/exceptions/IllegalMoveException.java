package com.javaAcademy.tictactoe.exceptions;

public class IllegalMoveException extends RuntimeException {
	
	private static final long serialVersionUID = -4493172789714300899L;

    public IllegalMoveException(String message) {
        super(message);
    }
}
