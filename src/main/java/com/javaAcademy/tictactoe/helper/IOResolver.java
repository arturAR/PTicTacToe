package com.javaAcademy.tictactoe.helper;

import java.util.Locale;
import java.util.ResourceBundle;

import com.javaAcademy.tictactoe.helper.inputImpl.ConsoleUserInput;
import com.javaAcademy.tictactoe.helper.resolversImpl.CoordResolver;
import com.javaAcademy.tictactoe.helper.resolversImpl.EmptyResolver;
import com.javaAcademy.tictactoe.helper.resolversImpl.SizeResolver;
import com.javaAcademy.tictactoe.helper.resolversImpl.StringResolver;
import com.javaAcademy.tictactoe.view.MessagePrinter;

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
		ConsoleUserInput userInput = new ConsoleUserInput();
		MessagePrinter messagePrinter = new MessagePrinter();
		if(key.startsWith("int.size.")) {
			dataResolver = new SizeResolver<Integer>(userInput, messagePrinter);
		} else if (key.startsWith("int.coord.")) {
			dataResolver = new CoordResolver<Integer>(userInput, messagePrinter);
		} else if (key.startsWith("string.")) {
			dataResolver = new StringResolver<String>(userInput, messagePrinter);
		} else { //key.startsWith("empty.")
			dataResolver = new EmptyResolver<String>(userInput, messagePrinter);
		}
		dataResolver.resolveIO(key, params);
		return dataResolver;
	}
}
