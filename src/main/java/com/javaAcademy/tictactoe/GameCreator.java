package com.javaAcademy.tictactoe;

import com.javaAcademy.tictactoe.model.GameSettings;
import com.javaAcademy.tictactoe.model.GameStatistics;

import java.util.Scanner;

import com.javaAcademy.tictactoe.exceptions.CancelGameException;
import com.javaAcademy.tictactoe.gameImpl.ServerGame;
import com.javaAcademy.tictactoe.helper.IOResolver;
import com.javaAcademy.tictactoe.helper.resolversImpl.SizeResolver;
import com.javaAcademy.tictactoe.helper.resolversImpl.StringResolver;
import com.javaAcademy.tictactoe.model.Player;
import com.javaAcademy.tictactoe.model.Symbol;
import com.javaAcademy.tictactoe.model.Type;

public class GameCreator {
	
	Scanner s = new Scanner(System.in);
	private static IOResolver ioResolver;
	

	void startGame() {
    	try {
    		ioResolver = IOResolver.getIOResolverInstance();
        	GameSettings settings = getGameSettings();
    		GameStatistics statistics = getGameStatistics();
    		
    		ServerGame.startGame(settings, statistics);
    	} catch(CancelGameException e) {
    		ioResolver.resolveIO("epty.gameEnd");
    	}
    }
    
    private GameStatistics getGameStatistics() {
    	ioResolver.setPrinter(Type.SERVER);
    	StringResolver<?> strRes = (StringResolver<?>) ioResolver.resolveIO("string.playerONickname");
    	String playerOName = (String) strRes.getValue();
    	
    	ioResolver.setPrinter(Type.CLIENT);
    	strRes = (StringResolver<?>) ioResolver.resolveIO("string.playerXNickname");
    	String playerXName = (String) strRes.getValue();
    	
        Player playerX = new Player(playerXName, Symbol.X);
        Player playerO = new Player(playerOName, Symbol.O);
        
        return new GameStatistics(playerX, playerO);
	}

	private GameSettings getGameSettings() {
    	ioResolver.setPrinter(Type.SERVER);
    	SizeResolver<?> res = (SizeResolver<?>) ioResolver.resolveIO("int.size.xDimension");
    	Integer xDim = (Integer) res.getValue();
    	
    	ioResolver.setPrinter(Type.SERVER);
    	res = (SizeResolver<?>) ioResolver.resolveIO("int.size.yDimension");
    	Integer yDim = (Integer) res.getValue();
    	
    	ioResolver.setPrinter(Type.SERVER);
    	res = (SizeResolver<?>) ioResolver.resolveIO("int.size.winningCondition", xDim, yDim);
    	Integer charSeriesDim = (Integer) res.getValue();
    	
    	ioResolver.setPrinter(Type.SERVER);
    	StringResolver<?> strRes = (StringResolver<?>) ioResolver.resolveIO("string.whoStarts");
    	String whoStarts = (String) strRes.getValue();
    	
		return new GameSettings(whoStarts, charSeriesDim, xDim, yDim, 3);
	}
	
}