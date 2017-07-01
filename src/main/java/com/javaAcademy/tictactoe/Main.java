package com.javaAcademy.tictactoe;

import com.javaAcademy.tictactoe.model.GameSettings;
import com.javaAcademy.tictactoe.model.GameStatistics;

import java.util.Scanner;

import com.javaAcademy.tictactoe.helper.UserIO;
import com.javaAcademy.tictactoe.model.Board;
import com.javaAcademy.tictactoe.model.Match;
import com.javaAcademy.tictactoe.model.Player;
import com.javaAcademy.tictactoe.model.Players;
import com.javaAcademy.tictactoe.model.Symbol;

/**
 * Created by patrycja on 28.06.17.
 */
public class Main {
	
	Scanner s = new Scanner(System.in);
	
    public static void main(String[] args) {
    	Main app = new Main();
    	GameSettings settings = app.getGameSettings();
    	GameStatistics statistics = app.getGameStatistics();
    	Game game = new Game(settings, statistics);
    }
    
    private GameStatistics getGameStatistics() {
    	String playerXName = UserIO.userMessageWithInput("Please enter player1 (X) name: ");
        String playerOName = UserIO.userMessageWithInput("Please enter player2 (O) name: ");
        
        Player playerX = new Player(playerXName, Symbol.X);
        Player playerO = new Player(playerOName, Symbol.O);
        
        return new GameStatistics(playerX, playerO);
	}

	private GameSettings getGameSettings() {
		
		
		int rows = Integer.parseInt(UserIO.userMessageWithInput("Please enter board rows quantity:"));
        int cols = Integer.parseInt(UserIO.userMessageWithInput("Please enter board columns quantity:"));

		//System.out.println("Please choose the language/Wybierz jêzyk: 1 - English, 2 - Polish.");
    	//final int lang = Integer.parseInt(s.nextLine());
    	//TODO choosing languange
    	System.out.println("You chose English");
    	
    	System.out.println("Choose board X dimension: ");
    	final int xDim = Integer.parseInt(s.nextLine());
    	
    	System.out.println("Choose board Y dimension: ");
    	final int yDim = Integer.parseInt(s.nextLine());
    	//TODO board dimension validation
    	
    	System.out.println("Choose how many charakters to win: ");
    	//TODO char series validation
    	final int charSeriesDim = Integer.parseInt(s.nextLine());
    	
    	System.out.println("Choose who start: press 1 if O, press 2 if X:");
    	//TODO char validation
    	final int whoStarts = Integer.parseInt(s.nextLine());
		return new GameSettings(whoStarts, charSeriesDim, xDim, yDim, "en", 3);
	}
}
