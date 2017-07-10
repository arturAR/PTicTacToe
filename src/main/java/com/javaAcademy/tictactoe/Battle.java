package com.javaAcademy.tictactoe;

import com.javaAcademy.tictactoe.businessLogic.CheckerAlgorithm;
import com.javaAcademy.tictactoe.helper.IOResolver;
import com.javaAcademy.tictactoe.helper.resolversImpl.CoordResolver;
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
		boolean someoneWin = false;
		int cnt = 0;
		ioResolver.getPrinter().printArena(gameArena);
		Symbol symbol = settings.getWhoStarts();
		Player player1 = statistics.getPlayerBySymbol(symbol);
		Player player2 = statistics.getPlayerBySymbol(symbol.getOppositeSymbol(settings.getWhoStarts()));
		do{
			if(cnt%2 == 0) {
				symbol = player1.getSymbol();
			} else {
				symbol = player2.getSymbol();
			}
			someoneWin = doMove(symbol);
			if(someoneWin) {
				//ioResolver.getPrinter().setType(Type.SERVER);
				ioResolver.resolveIO("empty.battleWinner", symbol.toString());
				return new BattleResult(symbol, symbol.getOppositeSymbol(symbol), true);
			}
	    	cnt++;
	    	ioResolver.getPrinter().printArena(gameArena); 
		} while(cnt < gameArena.getAmountOfSymbols() && !someoneWin);
		ioResolver.resolveIO("empty.battleNoWinner");
		return new BattleResult(Symbol.O, Symbol.X, false);
	}
	
	private boolean doMove(Symbol symbol) {
		Point tempPoint = getPointIfEmpty(gameArena, symbol);
		gameArena.setSymbol(symbol, tempPoint);
		return checker.win(gameArena, symbol);
	}

	private Point getPointIfEmpty(GameArena arena, Symbol symbol) {
		ioResolver.resolveIO("empty.whoTurn.first", symbol);
		
		CoordResolver<?> algoRes = (CoordResolver<?>) ioResolver.resolveIO("int.coord.xCoord", "X", arena.getXDimension());
    	Integer xDim = (Integer) algoRes.getValue();
    	
    	algoRes = (CoordResolver<?>) ioResolver.resolveIO("int.coord.yCoord", "Y", arena.getYDimension());
    	Integer yDim = (Integer) algoRes.getValue();
    	
    	ioResolver.resolveIO("empty.chosenCoords", xDim + "|" + yDim);
		
		if((arena.getArena()[xDim][yDim]).equals(Symbol.EMPTY)) {
			return new Point(xDim, yDim);
		}
		ioResolver.resolveIO("empty.pointOccupied");
		return getPointIfEmpty(arena, symbol);
	}
	
}
