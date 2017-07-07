package com.javaAcademy.tictactoe.helper;

import java.io.ByteArrayInputStream;

import static org.testng.Assert.*;
import org.testng.annotations.*;

import com.javaAcademy.tictactoe.helper.inputImpl.ConsoleUserInput;

public class IOTest {

	@Test
	public void testGetUserInputByScanner() {
		String string = "5dsa";
		ByteArrayInputStream in = new ByteArrayInputStream(string.getBytes());
		System.setIn(in);
		
		ConsoleUserInput userInput = new ConsoleUserInput();
		String result = userInput.getUserInput();
		assertEquals(string, result);
	}
}
