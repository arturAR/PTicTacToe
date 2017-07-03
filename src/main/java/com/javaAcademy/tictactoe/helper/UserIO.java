package com.javaAcademy.tictactoe.helper;

import java.util.Scanner;

/**
 * Created by patrycja on 29.06.17.
 */
public class UserIO {
	
    private static Scanner scanner = new Scanner(System.in);

    public static String getUserInput(){
        return scanner.nextLine();
    }

}
