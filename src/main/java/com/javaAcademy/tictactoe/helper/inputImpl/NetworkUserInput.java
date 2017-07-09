package com.javaAcademy.tictactoe.helper.inputImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

import com.javaAcademy.tictactoe.helper.UserInput;
import com.javaAcademy.tictactoe.model.Type;

public class NetworkUserInput implements UserInput{

	private Type type;
	private Scanner scanner = new Scanner(System.in);
	private BufferedReader reader;
	
	@Override
	public String getUserInput() throws IOException {
		if(type.equals(Type.SERVER)) {
			return scanner.nextLine();
		} else {
			String line = reader.readLine();
			String message = line;
			while (!line.equals("")) {
				message += line;
			}
			return message;
		}
	}
}
