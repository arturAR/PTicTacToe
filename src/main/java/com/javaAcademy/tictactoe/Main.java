package com.javaAcademy.tictactoe;

import java.util.Locale;
import java.util.Scanner;

import com.javaAcademy.tictactoe.helper.IOResolver;
import com.javaAcademy.tictactoe.helper.UserInput;
import com.javaAcademy.tictactoe.helper.inputImpl.ConsoleUserInput;
import com.javaAcademy.tictactoe.view.ConsolePrinter;
import com.javaAcademy.tictactoe.view.Printer;

public class Main {
	
	static Scanner s = new Scanner(System.in);
	private static UserInput userInput;
	private static Printer printer;
	
	public static void main(String[] args) {
		
    	System.out.println("Please choose the language/Wybierz język: 1 - English, 2 - Polish. Default English.");
    	String lang = s.nextLine();
    	
    	
    	System.out.println("Choose 1 to play 2-players game, choose 2 to play by network.");
    	String gameType = s.nextLine();
    	
    	if(gameType.equals("2")) {
    		System.out.println("If you want join to game press 1, else you will create a game:");
    		String typeNetworkGame = s.nextLine();
    		if(typeNetworkGame.equals("1")) {
    			
    		} else {
    			
    		}
    	} else {
    		printer = new ConsolePrinter();
    		userInput = new ConsoleUserInput();
    	}
    	
    	createIOResolver(lang);
    	
    	GameCreator app = new GameCreator();
    	app.startNormalGame();
	}

    private static void createIOResolver(String langNumber) {
		switch(langNumber) {
			case "1":
				IOResolver.createIOResolver(new Locale("en", "EN"), userInput, printer);
				break;
			case "2":
				IOResolver.createIOResolver(new Locale("pl", "PL"), userInput, printer);
				break;
			default:
				IOResolver.createIOResolver(new Locale("en", "EN"), userInput, printer);
		}
	}
}
