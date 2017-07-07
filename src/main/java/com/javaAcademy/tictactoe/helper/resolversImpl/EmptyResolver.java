package com.javaAcademy.tictactoe.helper.resolversImpl;

import java.util.Locale;
import java.util.ResourceBundle;

import com.javaAcademy.tictactoe.helper.DataResolver;
import com.javaAcademy.tictactoe.helper.UserInput;
import com.javaAcademy.tictactoe.view.MessagePrinter;

public class EmptyResolver<T> extends DataResolver<T> {


	public EmptyResolver(Locale locale, UserInput userInput) {
		super(locale, userInput);
	}

	@Override
	public void resolveIO(String key, Object ...params) {
		if(params.length == 0) {
			showMessage(key);
		} else {
			showMessageWithParam(key, params);
		}
	}
	
	private void showMessageWithParam(String key, Object[] params) {
		String message = ResourceBundle.getBundle("Messages", locale).getString(key);
		for(Object param: params) {
			message += " " + param;
		}
		MessagePrinter.printMessageSOutLn(message);
	}

	@Override
	protected T getValue() {
		return null;
	}
}
