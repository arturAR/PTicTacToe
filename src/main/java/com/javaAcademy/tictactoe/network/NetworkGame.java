package com.javaAcademy.tictactoe.network;

import com.javaAcademy.tictactoe.Battle;
import com.javaAcademy.tictactoe.businessLogic.CheckerAlgorithm;
import com.javaAcademy.tictactoe.model.BattleResult;
import com.javaAcademy.tictactoe.model.GameArena;
import com.javaAcademy.tictactoe.model.GameSettings;
import com.javaAcademy.tictactoe.model.GameStatistics;

public class NetworkGame {

    public NetworkGame(GameSettings settings, GameStatistics statistics) {
    	int cnt = 0;
		do {
			GameArena gameArena = GameArena.getGameArena(settings.getXArenaDimension(), settings.getYArenaDimension());
			CheckerAlgorithm checker = new CheckerAlgorithm(gameArena, settings.getWinningCondition());
			
			Battle battle = new Battle(settings, gameArena, checker, statistics);
			BattleResult result = battle.doBattle();
			statistics.updateStatistics(result);
			statistics.showStatistics();
			cnt++;
		} while (cnt < settings.getAmountOfBattles());
		statistics.summarizeGame();
    }
    
    public static NetworkGame startGame(GameSettings settings, GameStatistics statistics) {
		return new NetworkGame(settings, statistics);
	}
}
