package com.javaAcademy.tictactoe.helper;


import com.javaAcademy.tictactoe.exceptions.CancelGameException;
import com.javaAcademy.tictactoe.view.Printer;

public abstract class DataResolver <T>{
	
	protected T value;
	
	protected UserInput userInput;
	protected Printer printer;
	
	protected DataResolver(UserInput userInput, Printer printer){
		this.userInput = userInput;
		this.printer = printer;
	}
	
	protected abstract void resolveIO(String key, Object ...params);
	
	protected abstract T getValue();
	
	protected void checkIfCancelGame(String data) {
		if(data.equals("q")) {
			throw new CancelGameException("Cancel game");
		}
	}
}
