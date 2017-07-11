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
/*
	public BattleResult doBattle() {
		boolean someoneWin = false;
		int cnt = 0;
		//ioResolver.getPrinter().printArena(gameArena);
		Symbol symbol = settings.getWhoStarts();
		Player player1 = statistics.getPlayerBySymbol(symbol);
		Player player2 = statistics.getPlayerBySymbol(symbol.getOppositeSymbol());
		do{
			symbol = getNextSymbol(cnt, player1, player2);
			Point tempPoint = getPointIfEmpty(gameArena, symbol);
			gameArena.setSymbol(symbol, tempPoint);
			if(checker.win(symbol)) {
				ioResolver.resolveIO("empty.battleWinner", symbol.toString());
				return new BattleResult(symbol, symbol.getOppositeSymbol(), true);
			}
	    	cnt++;
	    	//ioResolver.getPrinter().printArena(gameArena); 
		} while(cnt < gameArena.getAmountOfSymbols() && !someoneWin);
		ioResolver.resolveIO("empty.battleNoWinner");
		return new BattleResult(Symbol.O, Symbol.X, false);
	}
*/	
	
	public BattleResult doBattle() {
		int cnt = 0;
		ioResolver.getPrinter().printArena(gameArena);
		Symbol symbol = settings.getWhoStarts();
		Player player = null;
		do{
			player = getNextPlayer(cnt, symbol);
			Point tempPoint = getPointIfEmpty(gameArena, player);
			gameArena.setSymbol(symbol, tempPoint);
			if(checker.win(symbol)) {
				ioResolver.resolveIO("empty.battleWinner", symbol.toString());
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
		
		ioResolver.setPrinter(player.getClientOrServer());
		CoordResolver algoRes = (CoordResolver) ioResolver.resolveIO("int.coord.xCoord", "X", arena.getXDimension());
    	Integer xDim = algoRes.getValue();
    	
    	ioResolver.setPrinter(player.getClientOrServer());
    	algoRes = (CoordResolver) ioResolver.resolveIO("int.coord.yCoord", "Y", arena.getYDimension());
    	Integer yDim = algoRes.getValue();
    	
    	ioResolver.setPrinter(player.getClientOrServer());
    	ioResolver.resolveIO("empty.chosenCoords", xDim + "|" + yDim);
		
		if((arena.getArena()[xDim][yDim]).equals(Symbol.EMPTY)) {
			return new Point(xDim, yDim);
		}
		ioResolver.setPrinter(player.getClientOrServer());
		ioResolver.resolveIO("empty.pointOccupied");
		return getPointIfEmpty(arena, player);
	}
/*
	private Symbol getNextSymbol(int cnt, Player player1, Player player2) {
		Symbol symbol;
		if(cnt%2 == 0) {
			symbol = player1.getSymbol();
		} else {
			symbol = player2.getSymbol();
		}
		return symbol;
	}

	private Point getPointIfEmpty(GameArena arena, Symbol symbol) {
		ioResolver.setPrinter(Type.BOTH);
		ioResolver.resolveIO("empty.whoTurn.first", symbol);
		
		CoordResolver algoRes = (CoordResolver) ioResolver.resolveIO("int.coord.xCoord", "X", arena.getXDimension());
    	Integer xDim = algoRes.getValue();
    	
    	algoRes = (CoordResolver) ioResolver.resolveIO("int.coord.yCoord", "Y", arena.getYDimension());
    	Integer yDim = algoRes.getValue();
    	
    	ioResolver.resolveIO("empty.chosenCoords", xDim + "|" + yDim);
		
		if((arena.getArena()[xDim][yDim]).equals(Symbol.EMPTY)) {
			return new Point(xDim, yDim);
		}
		ioResolver.resolveIO("empty.pointOccupied");
		return getPointIfEmpty(arena, symbol);
	}
	*/
}
