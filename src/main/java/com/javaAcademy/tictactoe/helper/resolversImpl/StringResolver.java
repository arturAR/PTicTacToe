package com.javaAcademy.tictactoe.helper.resolversImpl;

import java.util.Locale;

import com.javaAcademy.tictactoe.helper.DataResolver;
import com.javaAcademy.tictactoe.helper.UserInput;

public class StringResolver<T> extends DataResolver<T> {


	public StringResolver(Locale locale, UserInput userInput) {
		super(locale, userInput);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void resolveIO(String key, Object ...params) {
		showMessage(key);
		String data = userInput.getUserInput();
		
		checkIfCancelGame(data); 
		
		value = (T) data;
	}

	@Override
	public T getValue() {
		return value;
	}

}
