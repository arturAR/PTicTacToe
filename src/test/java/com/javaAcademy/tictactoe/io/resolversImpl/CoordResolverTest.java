package com.javaAcademy.tictactoe.io.resolversImpl;

import org.testng.annotations.*;

import com.javaAcademy.tictactoe.exceptions.IllegalMoveException;
import com.javaAcademy.tictactoe.io.resolversImpl.CoordResolver;

public class CoordResolverTest {
	
	
	@Test(expectedExceptions = IllegalMoveException.class)
	public void shouldThrowIllegalMoveException() {
		CoordResolver dataResolver = new CoordResolver(null, null);
		
		int dimension = 4;
		int dataFromUser = 6;
		dataResolver.checkCoordIsOnBoard(dimension, dataFromUser);
	}

	
}
