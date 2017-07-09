package com.javaAcademy.tictactoe.helper.inputImpl;

import java.util.Scanner;

import com.javaAcademy.tictactoe.helper.UserInput;

public class ConsoleUserInput implements UserInput {
	
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String getUserInput() {
        return scanner.nextLine();
    }
}
