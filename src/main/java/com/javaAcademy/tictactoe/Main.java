package com.javaAcademy.tictactoe;

import java.util.Locale;
import java.util.Scanner;

import com.javaAcademy.tictactoe.helper.IOResolver;

public class Main {
	
	static Scanner s = new Scanner(System.in);
	private static IOResolver ioResolver;
	
	public static void main(String[] args) {
		
    	System.out.println("Please choose the language/Wybierz język: 1 - English, 2 - Polish. Default English.");
    	String lang = s.nextLine();
    	createIOResolver(lang);
    	ioResolver = IOResolver.getIOResolverInstance();
    	
    	System.out.println("Choose 1 to play 2-players game, choose 2 to play by network.");
    	String type = s.nextLine();
    	GameCreator app = new GameCreator();
    	if(type.equals("1")) {
    		app.startNormalGame();
    	} else {
    		app.startNetworkGame();
    	}
	}

    private static void createIOResolver(String langNumber) {
		switch(langNumber) {
			case "1":
				IOResolver.createIOResolver(new Locale("en", "EN"));
				break;
			case "2":
				IOResolver.createIOResolver(new Locale("pl", "PL"));
				break;
			default:
				IOResolver.createIOResolver(new Locale("en", "EN"));
		}
	}
}
