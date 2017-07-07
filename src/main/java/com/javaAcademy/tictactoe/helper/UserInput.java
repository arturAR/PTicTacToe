package com.javaAcademy.tictactoe.helper;

import java.util.Scanner;

import com.javaAcademy.tictactoe.model.Type;

/**
 * Created by patrycja on 29.06.17.
 */
public class UserInput {
	
    private Scanner scanner = new Scanner(System.in);

    public String getUserInput(){
        return scanner.nextLine();
    }
    
    public String getClientServerInput(Type turn) {
    	if(turn.equals(Type.SERVER)) {
    		return getUserInput();
    	}
    	return "";
    }
}
