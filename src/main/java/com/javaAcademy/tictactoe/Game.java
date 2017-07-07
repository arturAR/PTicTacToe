package com.javaAcademy.tictactoe;

import com.javaAcademy.tictactoe.businessLogic.CheckerAlgorithm;
import com.javaAcademy.tictactoe.model.BattleResult;
import com.javaAcademy.tictactoe.model.GameArena;
import com.javaAcademy.tictactoe.model.GameSettings;
import com.javaAcademy.tictactoe.model.GameStatistics;

/**
 * Created by patrycja on 29.06.17.
 */
public class Game {

    public Game(GameSettings settings, GameStatistics statistics) {
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
    
    public static Game startGame(GameSettings settings, GameStatistics statistics) {
		return new Game(settings, statistics);
	}
}
