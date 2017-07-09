package com.javaAcademy.tictactoe.helper;

import org.testng.annotations.*;

import com.javaAcademy.tictactoe.exceptions.CancelGameException;
import com.javaAcademy.tictactoe.helper.resolversImpl.CoordResolver;

public class DataResolverTest {

	
	@Test(expectedExceptions = CancelGameException.class)
	public void shouldThrowCancelGameException() {
		DataResolver<?> dataResolver = new CoordResolver<Integer>(null, null);

		String data = "q";
		dataResolver.checkIfCancelGame(data);
	}
}
