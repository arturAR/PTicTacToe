package com.javaAcademy.tictactoe.io;


import com.javaAcademy.tictactoe.exceptions.CancelGameException;
import com.javaAcademy.tictactoe.model.Type;

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
	
	public void setPrinterType(Type type) {
		printer.setType(type);
	}
	
	public void setUserInputType(Type type) {
		userInput.setType(type);
	}
}
