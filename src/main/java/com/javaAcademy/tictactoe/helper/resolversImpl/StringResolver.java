package com.javaAcademy.tictactoe.helper.resolversImpl;

import java.io.IOException;

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
		try {
			printer.printMessage(key);
			String data = userInput.getUserInput();
			
			checkIfCancelGame(data); 
			
			value = (T) data;
		} catch (IOException e) {
			printer.printMessage("empty.ioException");
			resolveIO(key, params);
		}
	}

	@Override
	public T getValue() {
		return value;
	}

}
