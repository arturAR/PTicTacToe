package com.javaAcademy.tictactoe;

import com.javaAcademy.tictactoe.model.GameSettings;
import com.javaAcademy.tictactoe.model.GameStatistics;

import java.util.Locale;
import java.util.Scanner;

import com.javaAcademy.tictactoe.exceptions.CancelGameException;
import com.javaAcademy.tictactoe.helper.IOResolver;
import com.javaAcademy.tictactoe.helper.resolversImpl.SizeResolver;
import com.javaAcademy.tictactoe.helper.resolversImpl.StringResolver;
import com.javaAcademy.tictactoe.model.Player;
import com.javaAcademy.tictactoe.model.Symbol;

/**
 * Created by patrycja on 28.06.17.
 */
public class Main {
	
	Scanner s = new Scanner(System.in);
	private static IOResolver ioResolver;
	
    public static void main(String[] args) {
    	Main app = new Main();
    	System.out.println("Please choose the language/Wybierz język: 1 - English, 2 - Polish. Default English.");
    	String lang = app.s.nextLine();
    	app.createIOResolver(lang);
    	ioResolver = IOResolver.getIOResolverInstance();
    	System.out.println("Choose 1 to play 2-players game, choose 2 to play by network.");
    	String type = app.s.nextLine();
    	if(type.equals("1")) {
    		app.startNormalGame(app);
    	} else {
    		app.startServerGame(app);
    	}
    	
    }
    
    private void startServerGame(Main app) {
    	System.out.println("Choose 1 to create a game, else you will join to created game.");
    	String type = app.s.nextLine();
    	if(type.equals("1")) {
	    	try {
	    		GameSettings settings = app.getGameSettings();
	    		GameStatistics statistics = app.getGameStatistics();
	    		
	    		Game.startGame(settings, statistics);
	    	} catch(CancelGameException e) {
	    		ioResolver.resolveIO("epty.gameEnd");
	    	}
    	} else {
    		
    	}
	}

	private void startNormalGame(Main app) {
    	try {
    		GameSettings settings = app.getGameSettings();
    		GameStatistics statistics = app.getGameStatistics();
    		
    		Game.startGame(settings, statistics);
    	} catch(CancelGameException e) {
    		ioResolver.resolveIO("epty.gameEnd");
    	}
    }
    
    private GameStatistics getGameStatistics() {
    	StringResolver<?> strRes = (StringResolver<?>) ioResolver.resolveIO("string.playerONickname");
    	String playerOName = (String) strRes.getValue();
    	
    	strRes = (StringResolver<?>) ioResolver.resolveIO("string.playerXNickname");
    	String playerXName = (String) strRes.getValue();
    	
        Player playerX = new Player(playerXName, Symbol.X);
        Player playerO = new Player(playerOName, Symbol.O);
        
        return new GameStatistics(playerX, playerO);
	}

	private GameSettings getGameSettings() {
    	ioResolver.resolveIO("empty.chosenLanguage");
    	
    	SizeResolver<?> res = (SizeResolver<?>) ioResolver.resolveIO("int.size.xDimension");
    	Integer xDim = (Integer) res.getValue();
    	
    	res = (SizeResolver<?>) ioResolver.resolveIO("int.size.yDimension");
    	Integer yDim = (Integer) res.getValue();
    	
    	res = (SizeResolver<?>) ioResolver.resolveIO("int.size.winningCondition", xDim, yDim);
    	Integer charSeriesDim = (Integer) res.getValue();
    	
    	StringResolver<?> strRes = (StringResolver<?>) ioResolver.resolveIO("string.whoStarts");
    	String whoStarts = (String) strRes.getValue();
    	
		return new GameSettings(whoStarts, charSeriesDim, xDim, yDim, 3);
	}
	
    private void createIOResolver(String langNumber) {
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
