package com.javaAcademy.tictactoe;

import com.javaAcademy.tictactoe.model.GameSettings;
import com.javaAcademy.tictactoe.model.GameStatistics;

import java.util.Locale;
import java.util.Scanner;

import com.javaAcademy.tictactoe.helper.IOResolver;
import com.javaAcademy.tictactoe.model.Player;
import com.javaAcademy.tictactoe.model.Symbol;

/**
 * Created by patrycja on 28.06.17.
 */
public class Main {
	
	Scanner s = new Scanner(System.in);
	private IOResolver messageResolver;
	
    public static void main(String[] args) {
    	Main app = new Main();
    	System.out.println("Please choose the language/Wybierz język: 1 - English, 2 - Polish.");
    	final int lang = Integer.parseInt(app.s.nextLine());
    	app.createMessageResolver(lang);
    	GameSettings settings = app.getGameSettings();
    	GameStatistics statistics = app.getGameStatistics();
    	
    	Game.startGame(settings, statistics);
    }
    
    private GameStatistics getGameStatistics() {
    	System.out.println(messageResolver.getMsgByKey("string.playerONickname"));
    	String playerOName = s.nextLine();
    	
    	System.out.println(messageResolver.getMsgByKey("string.playerXNickname"));
    	String playerXName = s.nextLine();
    	
        Player playerX = new Player(playerXName, Symbol.X);
        Player playerO = new Player(playerOName, Symbol.O);
        
        return new GameStatistics(playerX, playerO);
	}

	private GameSettings getGameSettings() {
		messageResolver = IOResolver.IOresolverInstance();
    	System.out.println(messageResolver.getMsgByKey("empty.chosenLanguage"));
    	
    	System.out.println(messageResolver.getMsgByKey("int.xDimension"));
    	final int xDim = Integer.parseInt(s.nextLine());
    	
    	System.out.println(messageResolver.getMsgByKey("int.yDimension"));
    	final int yDim = Integer.parseInt(s.nextLine());
    	//TODO board dimension validation
    	
    	System.out.println(messageResolver.getMsgByKey("int.size.winningCondition"));
    	//TODO char series validation
    	final int charSeriesDim = Integer.parseInt(s.nextLine());
    	
    	System.out.println(messageResolver.getMsgByKey("int.whoStarts"));
    	//TODO char validation
    	final int whoStarts = Integer.parseInt(s.nextLine());
		return new GameSettings(whoStarts, charSeriesDim, xDim, yDim, 3);
	}
	
    private void createMessageResolver(int langNumber) {
		switch(langNumber) {
			case 1:
				IOResolver.createIOResolver(new Locale("en", "EN"));
				break;
			case 2:
				IOResolver.createIOResolver(new Locale("pl", "PL"));
				break;
			default:
				IOResolver.createIOResolver(new Locale("en", "EN"));
		}
	}
}
