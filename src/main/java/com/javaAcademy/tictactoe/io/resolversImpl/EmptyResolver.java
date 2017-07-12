package com.javaAcademy.tictactoe.io.resolversImpl;

import com.javaAcademy.tictactoe.io.DataResolver;
import com.javaAcademy.tictactoe.io.Printer;
import com.javaAcademy.tictactoe.io.UserInput;

public class EmptyResolver extends DataResolver<String> {


	public EmptyResolver(UserInput userInput, Printer printer) {
		super(userInput, printer);
	}

	@Override
	public void resolveIO(String key, Object ...params) {
		if(params.length == 0) {
			printer.printMessage(key);
		} else {
			printer.printMessageWithParam(key, params);
		}
	}

	@Override
	protected String getValue() {
		return "";
	}
}
