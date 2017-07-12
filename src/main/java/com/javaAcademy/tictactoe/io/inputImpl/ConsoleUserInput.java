package com.javaAcademy.tictactoe.io.inputImpl;

import java.util.Scanner;

import com.javaAcademy.tictactoe.io.UserInput;
import com.javaAcademy.tictactoe.model.Type;

public class ConsoleUserInput implements UserInput {
	
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String getUserInput() {
        return scanner.nextLine();
    }

	@Override
	public void setType(Type type) {
	}
}
