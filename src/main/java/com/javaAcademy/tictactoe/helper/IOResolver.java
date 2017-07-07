package com.javaAcademy.tictactoe.helper;

import java.util.Locale;
import java.util.ResourceBundle;

import com.javaAcademy.tictactoe.helper.resolversImpl.CoordResolver;
import com.javaAcademy.tictactoe.helper.resolversImpl.EmptyResolver;
import com.javaAcademy.tictactoe.helper.resolversImpl.SizeResolver;
import com.javaAcademy.tictactoe.helper.resolversImpl.StringResolver;

public class IOResolver {
	
	private static IOResolver instance;
	
	private Locale locale;

	private DataResolver<?> dataResolver;
	
	private IOResolver(Locale locale) {
		this.locale = locale;
	}

	public static IOResolver createIOResolver(Locale locale) {
		instance = new IOResolver(locale);
		return instance;
	}
	
	public static IOResolver getIOResolverInstance() {
		return instance;
	}

	public String getMsgByKey(String key) {
		return ResourceBundle.getBundle("Messages", locale).getString(key);
	}
	
	public DataResolver<?> resolveIO(String key, Object ...params) {
		UserInput userInput = new UserInput();
		if(key.startsWith("int.size.")) {
			dataResolver = new SizeResolver<Integer>(locale, userInput);
		} else if (key.startsWith("int.coord.")) {
			dataResolver = new CoordResolver<Integer>(locale, userInput);
		} else if (key.startsWith("string.")) {
			dataResolver = new StringResolver<String>(locale, userInput);
		} else { //key.startsWith("empty.")
			dataResolver = new EmptyResolver<String>(locale, userInput);
		}
		dataResolver.resolveIO(key, params);
		return dataResolver;
	}
}
