package com.javaAcademy.tictactoe.model;

import static org.testng.Assert.assertEquals;

import java.util.Locale;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.javaAcademy.tictactoe.helper.IOResolver;
import com.javaAcademy.tictactoe.helper.UserInput;
import com.javaAcademy.tictactoe.helper.inputImpl.ConsoleUserInput;
import com.javaAcademy.tictactoe.model.BattleResult;
import com.javaAcademy.tictactoe.model.GameStatistics;
import com.javaAcademy.tictactoe.model.Player;
import com.javaAcademy.tictactoe.model.Symbol;
import com.javaAcademy.tictactoe.view.ConsolePrinter;
import com.javaAcademy.tictactoe.view.Printer;

public class GameStatisticsTest {
	
	private Player playerX;
	private Player playerO;
	
	private String language = new String("en");
    private String country = new String("EN");
    private Locale locale;
    private UserInput userInput;
	private Printer printer;
	
	@BeforeMethod
	public void createPlayers() {
		String playerXName = "XNick";
		String playerOName = "ONick";
		playerX = new Player(playerXName, Symbol.X);
        playerO = new Player(playerOName, Symbol.O);
	}
	
	@BeforeTest
	public void createIOResolver() {
		
		locale = new Locale(language, country);
		printer = new ConsolePrinter();
		userInput = new ConsoleUserInput();
		
		IOResolver.createIOResolver(locale, userInput, printer);
	}
	
	@Test
	public void testShowStatisticsBeforeStartGame() {
		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));
        
		GameStatistics statistics = new GameStatistics(playerX, playerO);
		statistics.showStatistics();

        assertEquals(out.toString(), "Statistics: \nPlayer ONick 0\nPlayer XNick 0\n");
    }
	
	@Test
	public void testShowStatisticsAfterOneXWin() {
		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));
        
        Symbol symbol = Symbol.X;
		GameStatistics statistics = new GameStatistics(playerX, playerO);
		BattleResult battleResult = new BattleResult(symbol, symbol.getOppositeSymbol(), true);
		statistics.updateStatistics(battleResult);
		statistics.showStatistics();

        assertEquals(out.toString(), "Statistics: \nPlayer ONick 0\nPlayer XNick 3\n");
	}
	
	@Test
	public void testShowStatisticsAfterOneDraw() {
		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));
        
        Symbol symbol = Symbol.X;
		GameStatistics statistics = new GameStatistics(playerX, playerO);
		BattleResult battleResult = new BattleResult(symbol, symbol.getOppositeSymbol(), false);
		statistics.updateStatistics(battleResult);
		statistics.showStatistics();

        assertEquals(out.toString(), "Statistics: \nPlayer ONick 1\nPlayer XNick 1\n");
	}
	
	@Test
	public void testSummarizeGameAfter2DrawsAndXWin() {
		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));
        
        Symbol symbol = Symbol.X;
		GameStatistics statistics = new GameStatistics(playerX, playerO);
		BattleResult battle1 = new BattleResult(symbol, symbol.getOppositeSymbol(), false);
		statistics.updateStatistics(battle1);
		BattleResult battle2 = new BattleResult(symbol, symbol.getOppositeSymbol(), true);
		statistics.updateStatistics(battle2);
		BattleResult battle3 = new BattleResult(symbol, symbol.getOppositeSymbol(), false);
		statistics.updateStatistics(battle3);
		
		statistics.summarizeGame();
		assertEquals(out.toString(), "\n\n MATCH RESULT: \nPlayer X win game!\n");
	}
}
