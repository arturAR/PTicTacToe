package com.javaAcademy.tictactoe.helper.resolversImpl;

import java.util.Locale;

import com.javaAcademy.tictactoe.helper.DataResolver;

public class SizeResolver extends DataResolver {


	public SizeResolver(Locale locale) {
		super(locale);
	}

	@Override
	public void resolveIO(String key) {
		showMessage(key);
	}
}
