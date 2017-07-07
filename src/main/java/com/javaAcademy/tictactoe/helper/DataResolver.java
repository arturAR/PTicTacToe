package com.javaAcademy.tictactoe.helper;

import java.util.Locale;
import java.util.ResourceBundle;

import com.javaAcademy.tictactoe.exceptions.CancelGameException;
import com.javaAcademy.tictactoe.view.MessagePrinter;

public abstract class DataResolver <T>{
	
	protected T value;
	
	protected Locale locale;
	protected UserInput userInput;
	
	protected DataResolver(Locale locale, UserInput userInput) {
		this.locale = locale;
		this.userInput = userInput;
	}
	
	protected abstract void resolveIO(String key, Object ...params);
	
	protected void showMessage(String key) {
		String message = ResourceBundle.getBundle("Messages", locale).getString(key);
		MessagePrinter.printMessageSOutLn(message);
	}
	
	protected abstract T getValue();
	
	protected void checkIfCancelGame(String data) {
		if(data.equals("q")) {
			throw new CancelGameException("Cancel game");
		}
	}
}
