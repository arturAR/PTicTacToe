package com.javaAcademy.tictactoe.helper;

import java.util.Locale;
import java.util.ResourceBundle;

public abstract class DataResolver {
	
	protected Locale locale;
	
	protected DataResolver(Locale locale) {
		this.locale = locale;
	}
	
	protected abstract void resolveIO(String key);
	
	protected void showMessage(String key) {
		String message = ResourceBundle.getBundle("Messages", locale).getString(key);
		System.out.println(message);
	}
}
