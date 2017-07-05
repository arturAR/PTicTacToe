package com.javaAcademy.tictactoe.IOTests;

import java.io.ByteArrayInputStream;

import static org.testng.Assert.*;
import org.testng.annotations.*;

import com.javaAcademy.tictactoe.helper.UserIO;

public class IOTest {

	@Test
	public void testGetUserInputByScanner() {
		String string = "5dsa";
		ByteArrayInputStream in = new ByteArrayInputStream(string.getBytes());
		System.setIn(in);
		
		String result = UserIO.getUserInput();
		assertEquals(string, result);
	}
}
