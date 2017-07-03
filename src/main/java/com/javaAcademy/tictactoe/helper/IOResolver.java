package com.javaAcademy.tictactoe.helper;

import java.util.Locale;
import java.util.ResourceBundle;

import com.javaAcademy.tictactoe.helper.resolversImpl.AlgoResolver;
import com.javaAcademy.tictactoe.helper.resolversImpl.EmptyResolver;
import com.javaAcademy.tictactoe.helper.resolversImpl.IntResolver;
import com.javaAcademy.tictactoe.helper.resolversImpl.SizeResolver;
import com.javaAcademy.tictactoe.helper.resolversImpl.StringResolver;

public class IOResolver {
	
	private static IOResolver instance;
	
	private Locale locale;

	private DataResolver dataResolver;
	
	private IOResolver(Locale locale) {
		this.locale = locale;
	}

	public static IOResolver createIOResolver(Locale locale) {
		instance = new IOResolver(locale);
		return instance;
	}
	
	public static IOResolver IOresolverInstance() {
		return instance;
	}

	public String getMsgByKey(String key) {
		return ResourceBundle.getBundle("Messages", locale).getString(key);
	}
	
	public void resolveIO(String key) {
		if(key.startsWith("int.size.")) {
			dataResolver = new SizeResolver(locale);
		} else if (key.startsWith("int.algo.")) {
			dataResolver = new AlgoResolver(locale);
		} else if (key.startsWith("int.")) {
			dataResolver = new IntResolver(locale);
		} else if (key.startsWith("string.")) {
			dataResolver = new StringResolver(locale);
		} else { //key.startsWith("empty.")
			dataResolver = new EmptyResolver(locale);
		}
		dataResolver.resolveIO(key);
	}
}
