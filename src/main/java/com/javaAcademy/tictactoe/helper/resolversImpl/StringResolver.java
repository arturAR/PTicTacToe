package com.javaAcademy.tictactoe.helper.resolversImpl;

import com.javaAcademy.tictactoe.helper.DataResolver;
import com.javaAcademy.tictactoe.helper.UserInput;
import com.javaAcademy.tictactoe.view.Printer;

public class StringResolver<T> extends DataResolver<T> {


	public StringResolver(UserInput userInput, Printer printer) {
		super(userInput, printer);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void resolveIO(String key, Object ...params) {
		printer.printMessage(key);
		String data = userInput.getUserInput();
		
		checkIfCancelGame(data); 
		
		value = (T) data;
	}

	@Override
	public T getValue() {
		return value;
	}

}
