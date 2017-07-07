package com.javaAcademy.tictactoe.helper;

import java.util.Locale;

import org.testng.annotations.*;

import com.javaAcademy.tictactoe.exceptions.CancelGameException;
import com.javaAcademy.tictactoe.helper.resolversImpl.CoordResolver;

public class DataResolverTest {
	
	private Locale locale;
	
	@BeforeTest
	public void createIOResolver() {
		locale = new Locale("en", "EN");
		
		IOResolver.createIOResolver(locale);
	}
	
	@Test(expectedExceptions = CancelGameException.class)
	public void shouldThrowCancelGameException() {
		UserInput userInput = new UserInput();
		DataResolver<?> dataResolver = new CoordResolver<Integer>(locale, userInput);

		String data = "q";
		dataResolver.checkIfCancelGame(data);
	}
}
