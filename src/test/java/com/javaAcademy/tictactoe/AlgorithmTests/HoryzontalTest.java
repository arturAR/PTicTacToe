package com.javaAcademy.tictactoe.AlgorithmTests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.javaAcademy.tictactoe.businessLogic.CheckerAlgorithm;
import com.javaAcademy.tictactoe.model.GameArena;
import com.javaAcademy.tictactoe.model.Point;
import com.javaAcademy.tictactoe.model.Symbol;

public class HoryzontalTest {

	/* Horyzontal Tests*/
	@Test
	public void testHoryzontalThreeSymbolOInARowOn5x5Arena() {
		GameArena gameArena = GameArena.getGameArena(5, 5);
		gameArena.setSymbol(Symbol.O, new Point(2,2));
		gameArena.setSymbol(Symbol.O, new Point(3,2));
		gameArena.setSymbol(Symbol.O, new Point(4,2));
		
		CheckerAlgorithm checker = new CheckerAlgorithm(gameArena, 3);
		assertEquals(checker.win(gameArena, Symbol.O), true);
	}
	
	@Test
	public void testHoryzontalThreeSymbolONotInARowOn5x5BoardArena() {
		GameArena gameArena = GameArena.getGameArena(5, 5);
		gameArena.setSymbol(Symbol.O, new Point(1,2));
		gameArena.setSymbol(Symbol.O, new Point(3,2));
		gameArena.setSymbol(Symbol.O, new Point(4,2));
		
		CheckerAlgorithm checker = new CheckerAlgorithm(gameArena, 3);
		assertEquals(checker.win(gameArena, Symbol.O), false);
	}
	
	@Test
	public void testHoryzontalThreeSymbolOInARowOn5x3Arena() {
		GameArena gameArena = GameArena.getGameArena(5, 3);
		gameArena.setSymbol(Symbol.O, new Point(2,2));
		gameArena.setSymbol(Symbol.O, new Point(3,2));
		gameArena.setSymbol(Symbol.O, new Point(4,2));
		
		CheckerAlgorithm checker = new CheckerAlgorithm(gameArena, 3);
		assertEquals(checker.win(gameArena, Symbol.O), true);
	}
	
	@Test
	public void testHoryzontalThreeSymbolONotInARowOn5x3BoardArena() {
		GameArena gameArena = GameArena.getGameArena(5, 5);
		gameArena.setSymbol(Symbol.O, new Point(1,2));
		gameArena.setSymbol(Symbol.O, new Point(3,2));
		gameArena.setSymbol(Symbol.O, new Point(4,2));
		
		CheckerAlgorithm checker = new CheckerAlgorithm(gameArena, 3);
		assertEquals(checker.win(gameArena, Symbol.O), false);
	}
}
