package com.javaAcademy.tictactoe.io.resolversImpl;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.*;

import com.javaAcademy.tictactoe.exceptions.DigitLessThanThreeException;
import com.javaAcademy.tictactoe.exceptions.WinningConditionTooBigException;
import com.javaAcademy.tictactoe.io.resolversImpl.SizeResolver;

public class SizeResolverTest {

	
	@Test(expectedExceptions = WinningConditionTooBigException.class)
	public void shouldThrowWinningConditionTooBigException() {
		SizeResolver dataResolver = new SizeResolver(null, null);
		
		Object[] arenaDimension = new Integer[2];
		arenaDimension[0] = 5;
		arenaDimension[1] = 5;
		Integer winningCondition = 6;
		
		dataResolver.checkData(winningCondition, arenaDimension);
	}
	
	@Test(expectedExceptions = DigitLessThanThreeException.class)
	public void shouldThrowDigitLessThanThreeException() {
		SizeResolver dataResolver = new SizeResolver(null, null);
		
		Object[] arenaDimension = new Integer[2];
		arenaDimension[0] = 5;
		arenaDimension[1] = 5;
		Integer winningCondition = 2;
		
		dataResolver.checkData(winningCondition, arenaDimension);
	}
	
	@Test
	public void testGetValue() {
		SizeResolver dataResolver = new SizeResolver(null, null);
		
		Object[] arenaDimension = new Integer[2];
		arenaDimension[0] = 5;
		arenaDimension[1] = 5;
		Integer winningCondition = 4;
		
		dataResolver.checkData(winningCondition, arenaDimension);
		assertEquals((Integer) dataResolver.getValue(), winningCondition);
	}
}
