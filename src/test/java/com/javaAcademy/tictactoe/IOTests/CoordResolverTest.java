package com.javaAcademy.tictactoe.IOTests;

import static org.testng.Assert.*;

import java.io.ByteArrayInputStream;
import java.util.Locale;

import org.testng.annotations.*;

import com.javaAcademy.tictactoe.exceptions.CancelGameException;
import com.javaAcademy.tictactoe.exceptions.IllegalMoveException;
import com.javaAcademy.tictactoe.helper.IOResolver;
import com.javaAcademy.tictactoe.helper.UserInput;
import com.javaAcademy.tictactoe.helper.resolversImpl.CoordResolver;

public class CoordResolverTest {
	
	private Locale locale;
	
	@BeforeTest
	public void createIOResolver() {
		locale = new Locale("en", "EN");
		
		IOResolver.createIOResolver(locale);
	}
	/*
	@Test(expectedExceptions = CancelGameException.class)
	public void shouldThrowCancelGameException() {
		String string = "q";
		
		UserInput userInput = new UserInput();
		CoordResolver<?> dataResolver = new CoordResolver<Integer>(locale, userInput);
		ByteArrayInputStream in = new ByteArrayInputStream(string.getBytes());
		System.setIn(in);
		
		dataResolver.resolveIO("int.coord.cancelGameException");
	}
	
	
	@Test(expectedExceptions = IllegalMoveException.class)
	public void shouldThrowIllegalMoveException() {
		String string = "5";
		
		ByteArrayInputStream in = new ByteArrayInputStream(string.getBytes());
		System.setIn(in);
		CoordResolver<?> dataResolver = new CoordResolver<Integer>(locale);
		
		dataResolver.resolveIO("int.coord.IllegalMoveException", "Y", 4);
		
		
	}

	*/
}
