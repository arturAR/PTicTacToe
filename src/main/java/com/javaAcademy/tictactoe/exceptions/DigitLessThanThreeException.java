package com.javaAcademy.tictactoe.exceptions;

public class DigitLessThanThreeException extends RuntimeException {

	private static final long serialVersionUID = -1811969664768772466L;

	public DigitLessThanThreeException(String message) {
		super(message);
	}
}
