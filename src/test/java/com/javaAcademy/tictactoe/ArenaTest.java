package com.javaAcademy.tictactoe;

import static org.testng.Assert.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.javaAcademy.tictactoe.model.GameArena;
import com.javaAcademy.tictactoe.model.Point;
import com.javaAcademy.tictactoe.model.Symbol;


public class ArenaTest {
	
	@Test
	public void testAmountOfPointsInTable2x2is4() {
		GameArena gameArena = GameArena.getGameArena(2, 2);
		
		assertTrue(gameArena.getAmountOfSymbols() == 4);
	}
	
	@DataProvider(name = "amountOfPoints")
	public static Object[][] provide() {
		return new Object[][]{
            {2,4,8},
            {3,5,15},
            {3,3,9},
            
		};
	}
	
	@Test(dataProvider = "amountOfPoints")
	public void testAmountOfPointsInTable(int a, int b, int result) {
		GameArena gameArena = GameArena.getGameArena(a, b);
		assertEquals(gameArena.getAmountOfSymbols(), result, "Test failed: "+a+"+"+b+"="+result);
    }
	
	@Test
	public void testAllSymbolsAreEmptyInNewGameArena() {
		GameArena gameArena = GameArena.getGameArena(3, 4);
		for(int x = 0 ; x < gameArena.getXDimension(); x++) {
			for(int y = 0 ; y < gameArena.getYDimension(); y++) {
				assertEquals(gameArena.getArena()[x][y], Symbol.EMPTY);
			}
		}
	}
	
	@Test 
	public void testSetSymbolXOnArena() {
		GameArena gameArena = GameArena.getGameArena(3, 3);
		
		gameArena.setSymbol(Symbol.X, new Point(2,2));
		
		assertEquals(gameArena.getArena()[2][2], Symbol.X);
	}
	
	@Test 
	public void testSetSymbolOOnArena() {
		GameArena gameArena = GameArena.getGameArena(3, 3);
		
		gameArena.setSymbol(Symbol.O, new Point(1,3));
		
		assertEquals(gameArena.getArena()[1][3], Symbol.O);
	}

}
