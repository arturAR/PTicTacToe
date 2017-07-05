package com.javaAcademy.tictactoe;

import static org.testng.Assert.*;
import org.testng.annotations.*;

import com.javaAcademy.tictactoe.helper.DataParser;

public class DataParserTest {

	@Test
	public void testParseToInt() {
		int number = 24;
		String stringNumber = String.valueOf(number);
		
		assertEquals(DataParser.parseToInt(stringNumber), number);
	}
}
