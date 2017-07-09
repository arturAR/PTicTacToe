package com.javaAcademy.tictactoe.helper;

import static org.testng.Assert.*;

import org.testng.annotations.*;

import com.javaAcademy.tictactoe.model.GameSettings;
import com.javaAcademy.tictactoe.model.Symbol;

public class SettingsTest {
	
	private int amountOfBattles = 3;
	private int xDim = 5;
	private int yDim = 4;
	private int winningCondition = 3;
	
	@Test
	public void symbolOStarts() {
		String oStarts = "O";
		GameSettings settings = new GameSettings(oStarts, winningCondition, xDim, yDim, amountOfBattles);
		
		assertEquals(settings.getWhoStarts(), Symbol.O);
	}
	
	@Test
	public void symbolXStarts() {
		String xStarts = "X";
		GameSettings settings = new GameSettings(xStarts, winningCondition, xDim, yDim, amountOfBattles);
		
		assertEquals(settings.getWhoStarts(), Symbol.X);
	}
	
	@Test
	public void defaultSymbolXStarts() {
		String xStarts = "";
		GameSettings settings = new GameSettings(xStarts, winningCondition, xDim, yDim, amountOfBattles);
		
		assertEquals(settings.getWhoStarts(), Symbol.X);
	}
	
	@Test
	public void testWinningCondition() {
		GameSettings settings = new GameSettings("X", winningCondition, xDim, yDim, amountOfBattles);
		assertEquals(settings.getWinningCondition(), 3);
	}
	
	@Test
	public void testArenaDimension() {
		GameSettings settings = new GameSettings("X", winningCondition, xDim, yDim, amountOfBattles);
		assertEquals(settings.getXArenaDimension(), xDim);
		assertEquals(settings.getYArenaDimension(), yDim);
	}
	
	@Test
	public void testAmountOfBattles() {
		GameSettings settings = new GameSettings("X", winningCondition, xDim, yDim, amountOfBattles);
		assertEquals(settings.getAmountOfBattles(), amountOfBattles);
	}
	
}
