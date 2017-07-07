package com.javaAcademy.tictactoe.model;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.javaAcademy.tictactoe.model.BattleResult;
import com.javaAcademy.tictactoe.model.Symbol;

public class BattleResultTest {

	@Test
	public void isWinnerTest() {
		Symbol symbol = Symbol.O;
		BattleResult battleResult = new BattleResult(symbol, symbol.getOppositeSymbol(symbol), true);
		
		assertTrue(battleResult.isWinner());
	}
	
	@Test
	public void isDrawTest() {
		Symbol symbol = Symbol.O;
		BattleResult battleResult = new BattleResult(symbol, symbol.getOppositeSymbol(symbol), false);
		
		assertFalse(battleResult.isWinner());
	}
	
	@Test
	public void oWinTest() {
		Symbol symbol = Symbol.O;
		BattleResult battleResult = new BattleResult(symbol, symbol.getOppositeSymbol(symbol), true);
		
		assertEquals(battleResult.getWinner(), symbol);
	}
	
	@Test
	public void xLoseTest() {
		Symbol symbol = Symbol.O;
		BattleResult battleResult = new BattleResult(symbol, symbol.getOppositeSymbol(symbol), true);
		
		assertEquals(battleResult.getLoser(), symbol.getOppositeSymbol(symbol));
	}
	
	
}
