package com.javaAcademy.tictactoe.helper;

import org.testng.annotations.*;

import com.javaAcademy.tictactoe.exceptions.CancelGameException;
import com.javaAcademy.tictactoe.helper.resolversImpl.CoordResolver;
import com.javaAcademy.tictactoe.helper.resolversImpl.StringResolver;

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
