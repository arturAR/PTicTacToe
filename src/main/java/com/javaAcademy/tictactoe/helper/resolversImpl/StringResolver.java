package com.javaAcademy.tictactoe.helper.resolversImpl;

import java.util.Locale;

import com.javaAcademy.tictactoe.helper.DataResolver;

public class StringResolver extends DataResolver {


	public StringResolver(Locale locale) {
		super(locale);
	}

	@Override
	public void resolveIO(String key) {
		showMessage(key);
	}

}
