package com.javaAcademy.tictactoe.model;

import java.util.HashMap;
import java.util.Map;

public class GameStatistics {
	
	private Map<Symbol, Player> players = new HashMap<>();
	
	public GameStatistics(Player xPlayer, Player oPlayer) {
		players.put(xPlayer.getSymbol(), xPlayer);
		players.put(oPlayer.getSymbol(), oPlayer);
	}
	
	private void updatePlayerStatisticAfterBattle(Symbol playerSymbol, BattleScore score) {
		players.get(playerSymbol).addPoints(score);
	}
	
	public void updateStatistics(BattleResult result) {
		if(result.isWinner()) {
			updatePlayerStatisticAfterBattle(result.getWinner(), BattleScore.WIN);
			updatePlayerStatisticAfterBattle(result.getLoser(), BattleScore.DEFEAT);
		} else {
			updatePlayerStatisticAfterBattle(Symbol.O, BattleScore.DRAW);
			updatePlayerStatisticAfterBattle(Symbol.X, BattleScore.DRAW);
		}
	}

	public void showStatistics() {
		System.out.println("Statistics:");
		System.out.println("	Player O: " + players.get(Symbol.O).getAmountOfPoints());
		System.out.println("	Player X: " + players.get(Symbol.X).getAmountOfPoints());
	}

	public void summarizeGame() {
		System.out.println("\n\n MATCH RESULT: ");
		int pointsPlayerX = players.get(Symbol.X).getAmountOfPoints();
		int pointsPlayerO = players.get(Symbol.O).getAmountOfPoints();
		if(pointsPlayerO > pointsPlayerX) {
			System.out.println("	Player O win game!");
		} else if(pointsPlayerX > pointsPlayerO) {
			System.out.println("	Player X win game!");
		} else {
			System.out.println("	Draw!");
		}
	}
}
