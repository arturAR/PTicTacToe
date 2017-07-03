package com.javaAcademy.tictactoe.exceptions;

public class CancelGameException extends RuntimeException {

	private static final long serialVersionUID = 3321699247410499802L;

	public CancelGameException(String message) {
		super(message);
	}

}
