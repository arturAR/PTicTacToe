package com.javaAcademy.tictactoe.helper.resolversImpl;

import java.util.Locale;

import com.javaAcademy.tictactoe.helper.DataResolver;
import com.javaAcademy.tictactoe.helper.UserIO;

public class StringResolver<T> extends DataResolver<T> {


	public StringResolver(Locale locale) {
		super(locale);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void resolveIO(String key, Object ...params) {
		showMessage(key);
		String data = UserIO.getUserInput();
		
		checkIfCancelGame(data); 
		
		value = (T) data;
	}

	@Override
	public T getValue() {
		return value;
	}

}
