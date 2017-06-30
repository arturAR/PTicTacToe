package com.javaAcademy.tictactoe;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by patrycja on 29.06.17.
 */
public class UserIO {
    private static PrintStream printStream = System.out;
    private static Scanner scanner = new Scanner(System.in);

    public static void showUserMessage(String message){
        printStream.println(message);
    }

    public static String getUserInput(){
        return scanner.nextLine();
    }

    public static String userMessageWithInput(String message) {
        showUserMessage(message);
        return getUserInput();
    }
}
