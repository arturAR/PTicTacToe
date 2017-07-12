package com.javaAcademy.tictactoe.io;

import org.testng.annotations.*;

import com.javaAcademy.tictactoe.exceptions.CancelGameException;
import com.javaAcademy.tictactoe.io.DataResolver;
import com.javaAcademy.tictactoe.io.resolversImpl.CoordResolver;
import com.javaAcademy.tictactoe.io.resolversImpl.StringResolver;

public class DataResolverTest {

	
	@Test(expectedExceptions = CancelGameException.class)
	public void shouldThrowCancelGameExceptionInCoordResolver() {
		DataResolver<?> dataResolver = new CoordResolver(null, null);

		String data = "q";
		dataResolver.checkIfCancelGame(data);
	}
	
	@Test(expectedExceptions = CancelGameException.class)
	public void shouldThrowCancelGameExceptionInStringResolver() {
		DataResolver<?> dataResolver = new StringResolver(null, null);

		String data = "q";
		dataResolver.checkIfCancelGame(data);
	}
}
