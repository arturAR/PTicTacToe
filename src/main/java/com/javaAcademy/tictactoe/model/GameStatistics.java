package com.javaAcademy.tictactoe.model;

import java.util.HashMap;
import java.util.Map;

import com.javaAcademy.tictactoe.helper.IOResolver;

public class GameStatistics {
	
	private Map<Symbol, Player> players = new HashMap<>();
	private IOResolver msgResolver;
	
	public GameStatistics(Player xPlayer, Player oPlayer) {
		players.put(xPlayer.getSymbol(), xPlayer);
		players.put(oPlayer.getSymbol(), oPlayer);
		msgResolver = IOResolver.IOresolverInstance();
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
		System.out.println(msgResolver.getMsgByKey("empty.showStatistic.head"));
		System.out.println(msgResolver.getMsgByKey("empty.showStatistic.playerO") + players.get(Symbol.O).getAmountOfPoints());
		System.out.println(msgResolver.getMsgByKey("empty.showStatistic.playerX") + players.get(Symbol.X).getAmountOfPoints());
	}

	public void summarizeGame() {
		System.out.println(msgResolver.getMsgByKey("empty.matchResult.head"));
		int pointsPlayerX = players.get(Symbol.X).getAmountOfPoints();
		int pointsPlayerO = players.get(Symbol.O).getAmountOfPoints();
		if(pointsPlayerO > pointsPlayerX) {
			System.out.println(msgResolver.getMsgByKey("empty.gameResult.playerOwin"));
		} else if(pointsPlayerX > pointsPlayerO) {
			System.out.println(msgResolver.getMsgByKey("empty.gameResult.playerXWin"));
		} else {
			System.out.println(msgResolver.getMsgByKey("empty.gameResult.draw"));
		}
	}
}
