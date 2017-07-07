package com.javaAcademy.tictactoe.helper.resolversImpl;

import com.javaAcademy.tictactoe.helper.DataResolver;
import com.javaAcademy.tictactoe.helper.UserInput;
import com.javaAcademy.tictactoe.view.Printer;

public class EmptyResolver<T> extends DataResolver<T> {


	public EmptyResolver(UserInput userInput, Printer printer) {
		super(userInput, printer);
	}

	@Override
	public void resolveIO(String key, Object ...params) {
		if(params.length == 0) {
			printer.printMessage(key);
		} else {
			printer.showMessageWithParam(key, params);
		}
	}

	@Override
	protected T getValue() {
		return null;
	}
}
