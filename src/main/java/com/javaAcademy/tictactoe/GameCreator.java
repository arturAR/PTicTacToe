package com.javaAcademy.tictactoe;

import com.javaAcademy.tictactoe.model.GameSettings;
import com.javaAcademy.tictactoe.model.GameStatistics;

import java.util.Scanner;

import com.javaAcademy.tictactoe.exceptions.CancelGameException;
import com.javaAcademy.tictactoe.helper.IOResolver;
import com.javaAcademy.tictactoe.helper.resolversImpl.SizeResolver;
import com.javaAcademy.tictactoe.helper.resolversImpl.StringResolver;
import com.javaAcademy.tictactoe.model.Player;
import com.javaAcademy.tictactoe.model.Symbol;
import com.javaAcademy.tictactoe.network.NetworkGame;


public class GameCreator {
	
	Scanner s = new Scanner(System.in);
	private static IOResolver ioResolver;

	void startNormalGame() {
    	try {
    		GameSettings settings = getGameSettings();
    		GameStatistics statistics = getGameStatistics();
    		
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
	
}
