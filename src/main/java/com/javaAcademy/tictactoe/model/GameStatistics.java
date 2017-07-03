package com.javaAcademy.tictactoe.model;

import java.util.HashMap;
import java.util.Map;

import com.javaAcademy.tictactoe.helper.IOResolver;

public class GameStatistics {
	
	private Map<Symbol, Player> players = new HashMap<>();
	private IOResolver ioResolver;
	
	public GameStatistics(Player xPlayer, Player oPlayer) {
		players.put(xPlayer.getSymbol(), xPlayer);
		players.put(oPlayer.getSymbol(), oPlayer);
		ioResolver = IOResolver.getIOResolverInstance();
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
		ioResolver.resolveIO("empty.showStatistic.head");
		ioResolver.resolveIO("empty.showStatistic.player", players.get(Symbol.O).getNick(), players.get(Symbol.O).getAmountOfPoints());
		ioResolver.resolveIO("empty.showStatistic.player", players.get(Symbol.X).getNick(), players.get(Symbol.X).getAmountOfPoints());
	}

	public void summarizeGame() {
		ioResolver.resolveIO("empty.matchResult.head");
		int pointsPlayerX = players.get(Symbol.X).getAmountOfPoints();
		int pointsPlayerO = players.get(Symbol.O).getAmountOfPoints();
		if(pointsPlayerO > pointsPlayerX) {
			ioResolver.resolveIO("empty.matchResult.head");
		} else if(pointsPlayerX > pointsPlayerO) {
			ioResolver.resolveIO("empty.gameResult.playerOwin");
		} else {
			ioResolver.resolveIO("empty.gameResult.draw");
		}
	}
}
