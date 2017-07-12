package com.javaAcademy.tictactoe.io.resolversImpl;

import java.io.IOException;

import com.javaAcademy.tictactoe.io.DataResolver;
import com.javaAcademy.tictactoe.io.Printer;
import com.javaAcademy.tictactoe.io.UserInput;

public class StringResolver extends DataResolver<String> {


	public StringResolver(UserInput userInput, Printer printer) {
		super(userInput, printer);
	}

	@Override
	public void resolveIO(String key, Object ...params) {
		try {
			printer.printMessage(key);
			String data = userInput.getUserInput();
			
			checkIfCancelGame(data); 
			
			value = data;
		} catch (IOException e) {
			printer.printMessage("empty.ioException");
			resolveIO(key, params);
		}
	}

	@Override
	public String getValue() {
		return value;
	}

}
