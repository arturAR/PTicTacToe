package com.javaAcademy.tictactoe.businnesLogic.directions;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.javaAcademy.tictactoe.businessLogic.CheckerAlgorithm;
import com.javaAcademy.tictactoe.model.GameArena;
import com.javaAcademy.tictactoe.model.Point;
import com.javaAcademy.tictactoe.model.Symbol;

public class DescendingTest {

	/* Descending Tests */
	@Test
	public void testDescendingThreeSymbolOInARowOn5x5Arena() {
		GameArena gameArena = GameArena.getGameArena(5, 5);
		gameArena.setSymbol(Symbol.O, new Point(2,2));
		gameArena.setSymbol(Symbol.O, new Point(3,3));
		gameArena.setSymbol(Symbol.O, new Point(4,4));
		
		CheckerAlgorithm checker = new CheckerAlgorithm(gameArena, 3);
		assertEquals(checker.win(gameArena, Symbol.O), true);
	}
	
	@Test
	public void testDescendingThreeSymbolONotInARowOn5x5BoardArena() {
		GameArena gameArena = GameArena.getGameArena(5, 5);
		gameArena.setSymbol(Symbol.O, new Point(1,1));
		gameArena.setSymbol(Symbol.O, new Point(3,3));
		gameArena.setSymbol(Symbol.O, new Point(4,4));
		
		CheckerAlgorithm checker = new CheckerAlgorithm(gameArena, 3);
		assertEquals(checker.win(gameArena, Symbol.O), false);
	}
	
	@Test
	public void testDescendingThreeSymbolOInARowOn4x6Arena() {
		GameArena gameArena = GameArena.getGameArena(4, 6);
		gameArena.setSymbol(Symbol.O, new Point(2,3));
		gameArena.setSymbol(Symbol.O, new Point(3,4));
		gameArena.setSymbol(Symbol.O, new Point(4,5));
		
		CheckerAlgorithm checker = new CheckerAlgorithm(gameArena, 3);
		assertEquals(checker.win(gameArena, Symbol.O), true);
	}
	
	@Test
	public void testDescendingThreeSymbolONotInARowOn4x6BoardArena() {
		GameArena gameArena = GameArena.getGameArena(4, 6);
		gameArena.setSymbol(Symbol.O, new Point(1,1));
		gameArena.setSymbol(Symbol.O, new Point(3,3));
		gameArena.setSymbol(Symbol.O, new Point(4,4));
		
		CheckerAlgorithm checker = new CheckerAlgorithm(gameArena, 3);
		assertEquals(checker.win(gameArena, Symbol.O), false);
	}
}
