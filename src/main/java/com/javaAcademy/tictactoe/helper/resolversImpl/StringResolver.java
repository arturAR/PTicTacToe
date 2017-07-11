package com.javaAcademy.tictactoe.helper.resolversImpl;

import java.io.IOException;

import com.javaAcademy.tictactoe.helper.DataResolver;
import com.javaAcademy.tictactoe.helper.UserInput;
import com.javaAcademy.tictactoe.view.Printer;

public class StringResolver extends DataResolver<String> {


	public StringResolver(UserInput userInput, Printer printer) {
		super(userInput, printer);
	}

	@Override
	public void resolveIO(String key, Object ...params) {
		try {
			printer.printMessage(key);
			System.out.println("Teraz będę pobierał dane od ziomeczka");
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
