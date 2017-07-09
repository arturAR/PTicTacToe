package com.javaAcademy.tictactoe.helper;

import java.util.Locale;
import java.util.ResourceBundle;

import com.javaAcademy.tictactoe.helper.resolversImpl.CoordResolver;
import com.javaAcademy.tictactoe.helper.resolversImpl.EmptyResolver;
import com.javaAcademy.tictactoe.helper.resolversImpl.SizeResolver;
import com.javaAcademy.tictactoe.helper.resolversImpl.StringResolver;
import com.javaAcademy.tictactoe.view.Printer;
import com.javaAcademy.tictactoe.view.TablePrinter;

public class IOResolver {
	
	private static IOResolver instance;
	
	private Locale locale;
	
	private UserInput userInput;
	private Printer printer;

	private DataResolver<?> dataResolver;
	
	private IOResolver(Locale locale, UserInput userInput, Printer printer) {
		this.locale = locale;
		this.userInput = userInput;
		this.printer = printer;
	}

	public static IOResolver createIOResolver(Locale locale, UserInput userInput, Printer printer) {
		instance = new IOResolver(locale, userInput, printer);
		return instance;
	}
	
	public static IOResolver getIOResolverInstance() {
		return instance;
	}

	public String getMsgByKey(String key) {
		return ResourceBundle.getBundle("Messages", locale).getString(key);
	}
	
	public DataResolver<?> resolveIO(String key, Object ...params) {
		if(key.startsWith("int.size.")) {
			dataResolver = new SizeResolver<Integer>(userInput, printer);
		} else if (key.startsWith("int.coord.")) {
			dataResolver = new CoordResolver<Integer>(userInput, printer);
		} else if (key.startsWith("string.")) {
			dataResolver = new StringResolver<String>(userInput, printer);
		} else { //key.startsWith("empty.")
			dataResolver = new EmptyResolver<String>(userInput, printer);
		}
		dataResolver.resolveIO(key, params);
		return dataResolver;
	}

	public Printer getPrinter() {
		return printer;
	}
}
