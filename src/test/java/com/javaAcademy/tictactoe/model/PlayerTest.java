package com.javaAcademy.tictactoe.model;

import static org.testng.Assert.*;

import org.testng.annotations.*;

import com.javaAcademy.tictactoe.model.BattleScore;
import com.javaAcademy.tictactoe.model.Player;
import com.javaAcademy.tictactoe.model.Symbol;


public class PlayerTest {

	@Test
	public void testCreatePlayer() {
		Player xPlayer = new Player("Tomek", Symbol.X);
		assertEquals("Tomek", xPlayer.getNick());
		assertEquals(Symbol.X, xPlayer.getSymbol());
	}
	
	@Test
	public void testAddPointFromWin() {
		Player xPlayer = new Player("Tomek", Symbol.X);
		
		xPlayer.addPoints(BattleScore.WIN);
		
		assertEquals(BattleScore.WIN.getPointsForResult(), xPlayer.getAmountOfPoints());
	}
	
	@Test
	public void testAddPointFromDraw() {
		Player xPlayer = new Player("Tomek", Symbol.X);
		
		xPlayer.addPoints(BattleScore.DRAW);
		
		assertEquals(BattleScore.DRAW.getPointsForResult(), xPlayer.getAmountOfPoints());
	}
	
	@Test
	public void testPlayerPointsAfter3Wins() {
		Player xPlayer = new Player("Tomek", Symbol.X);
		
		xPlayer.addPoints(BattleScore.WIN);
		xPlayer.addPoints(BattleScore.WIN);
		xPlayer.addPoints(BattleScore.WIN);
		
		int score = 3 * BattleScore.WIN.getPointsForResult();
		assertEquals(score, xPlayer.getAmountOfPoints());
	}
}
