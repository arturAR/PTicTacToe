package com.javaAcademy.tictactoe.helper.resolversImpl;

import java.util.Locale;

import org.testng.annotations.*;

import com.javaAcademy.tictactoe.exceptions.IllegalMoveException;
import com.javaAcademy.tictactoe.helper.IOResolver;
import com.javaAcademy.tictactoe.helper.resolversImpl.CoordResolver;

public class CoordResolverTest {
	
	private Locale locale;
	
	@BeforeTest
	public void createIOResolver() {
		locale = new Locale("en", "EN");
		
		IOResolver.createIOResolver(locale);
	}
	
	@Test(expectedExceptions = IllegalMoveException.class)
	public void shouldThrowIllegalMoveException() {
		CoordResolver<?> dataResolver = new CoordResolver<Integer>(locale, null);
		
		int dimension = 4;
		int dataFromUser = 6;
		dataResolver.checkCoordIsOnBoard(dimension, dataFromUser);
	}

	
}
