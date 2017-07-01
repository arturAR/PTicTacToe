package com.javaAcademy.tictactoe.exceptions;

public class WinningConditionTooBigException extends RuntimeException{

	private static final long serialVersionUID = 477324754522419687L;

	public WinningConditionTooBigException(String message) {
		super(message);
	}
}
