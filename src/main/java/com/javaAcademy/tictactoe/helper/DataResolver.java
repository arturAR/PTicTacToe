package com.javaAcademy.tictactoe.helper;

import java.util.Locale;
import java.util.ResourceBundle;

public abstract class DataResolver <T>{
	
	protected T value;
	
	protected Locale locale;
	
	protected DataResolver(Locale locale) {
		this.locale = locale;
	}
	
	protected abstract void resolveIO(String key, Object ...params);
	
	protected void showMessage(String key) {
		String message = ResourceBundle.getBundle("Messages", locale).getString(key);
		System.out.println(message);
	}
	
	protected abstract T getValue();
	
	protected boolean isCancelGame(String data) {
		return data.equals("q");
	}
}
