package com.javaAcademy.tictactoe.helper;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessageResolver {
	
	private static MessageResolver instance;
	
	private Locale locale;
	
	private MessageResolver(Locale locale) {
		this.locale = locale;
	}

	public static MessageResolver msgResolverInstance(Locale locale) {
		instance = new MessageResolver(locale);
		return instance;
	}
	
	public static MessageResolver msgResolverInstance() {
		return instance;
	}

	public String getMsgByKey(String key) {
		return ResourceBundle.getBundle("Messages", locale).getString(key);
	}
}
