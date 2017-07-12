package com.javaAcademy.tictactoe;

import com.javaAcademy.tictactoe.businessLogic.CheckerAlgorithm;
import com.javaAcademy.tictactoe.io.IOResolver;
import com.javaAcademy.tictactoe.io.resolversImpl.CoordResolver;
import com.javaAcademy.tictactoe.model.BattleResult;
import com.javaAcademy.tictactoe.model.GameArena;
import com.javaAcademy.tictactoe.model.GameSettings;
import com.javaAcademy.tictactoe.model.GameStatistics;
import com.javaAcademy.tictactoe.model.Player;
import com.javaAcademy.tictactoe.model.Point;
import com.javaAcademy.tictactoe.model.Symbol;
import com.javaAcademy.tictactoe.model.Type;


public class Battle {

	private GameSettings settings;
	private IOResolver ioResolver;
	private GameArena gameArena;
	private CheckerAlgorithm checker;
	private GameStatistics statistics;

	public Battle(GameSettings settings, GameArena gameArena, CheckerAlgorithm checker, GameStatistics statistics) {
		this.settings = settings;
		this.gameArena = gameArena;
		this.checker = checker;
		this.statistics = statistics;
		ioResolver = IOResolver.getIOResolverInstance();
	}
	
	public BattleResult doBattle() {
		int cnt = 0;
		ioResolver.getPrinter().printArena(gameArena);
		Symbol symbol = settings.getWhoStarts();
		Player player = null;
		do{
			player = getNextPlayer(cnt, symbol);
			Point tempPoint = getPointIfEmpty(gameArena, player);
			gameArena.setSymbol(player.getSymbol(), tempPoint);
			if(checker.win(player.getSymbol())) {
				ioResolver.resolveIO("empty.battleWinner", player.getSymbol());
				return new BattleResult(symbol, symbol.getOppositeSymbol(), true);
			}
	    	cnt++;
	    	ioResolver.getPrinter().printArena(gameArena); 
		} while(cnt < gameArena.getAmountOfSymbols());
		ioResolver.resolveIO("empty.battleNoWinner");
		return new BattleResult(Symbol.O, Symbol.X, false);
	}
	
	private Player getNextPlayer(int cnt, Symbol startingSymbol) {
		if(cnt%2 == 0) {
			return statistics.getPlayerBySymbol(startingSymbol);
		} else {
			return statistics.getPlayerBySymbol(startingSymbol.getOppositeSymbol());
		}
	}
	
	private Point getPointIfEmpty(GameArena arena, Player player) {
		ioResolver.setPrinter(Type.BOTH);
		ioResolver.resolveIO("empty.whoTurn.first", player.getSymbol());
		
		ioResolver.setPrinter(player.getPlayerType());
		CoordResolver algoRes = (CoordResolver) ioResolver.resolveIO("int.coord.xCoord", "X", arena.getXDimension());
    	Integer xDim = algoRes.getValue();
    	
    	ioResolver.setPrinter(player.getPlayerType());
    	algoRes = (CoordResolver) ioResolver.resolveIO("int.coord.yCoord", "Y", arena.getYDimension());
    	Integer yDim = algoRes.getValue();
    	
    	ioResolver.setPrinter(player.getPlayerType());
    	ioResolver.resolveIO("empty.chosenCoords", xDim + "|" + yDim);
		
		if((arena.getArena()[xDim][yDim]).equals(Symbol.EMPTY)) {
			return new Point(xDim, yDim);
		}
		ioResolver.setPrinter(player.getPlayerType());
		ioResolver.resolveIO("empty.pointOccupied");
		return getPointIfEmpty(arena, player);
	}
}
