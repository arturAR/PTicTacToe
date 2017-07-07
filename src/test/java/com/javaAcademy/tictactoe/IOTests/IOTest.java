package com.javaAcademy.tictactoe.IOTests;

import java.io.ByteArrayInputStream;

import static org.testng.Assert.*;
import org.testng.annotations.*;

import com.javaAcademy.tictactoe.helper.UserInput;

public class IOTest {

	@Test
	public void testGetUserInputByScanner() {
		String string = "5dsa";
		ByteArrayInputStream in = new ByteArrayInputStream(string.getBytes());
		System.setIn(in);
		
		UserInput userInput = new UserInput();
		String result = userInput.getUserInput();
		assertEquals(string, result);
	}
}
