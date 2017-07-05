package com.javaAcademy.tictactoe;

import com.javaAcademy.tictactoe.businessLogic.CheckerAlgorithm;
import com.javaAcademy.tictactoe.helper.IOResolver;
import com.javaAcademy.tictactoe.helper.resolversImpl.CoordResolver;
import com.javaAcademy.tictactoe.model.BattleResult;
import com.javaAcademy.tictactoe.model.GameArena;
import com.javaAcademy.tictactoe.model.GameSettings;
import com.javaAcademy.tictactoe.model.Point;
import com.javaAcademy.tictactoe.model.Symbol;
import com.javaAcademy.tictactoe.view.TablePrinter;


public class Battle {

	private GameSettings settings;
	private IOResolver ioResolver;

	public Battle(GameSettings settings) {
		this.settings = settings;
		ioResolver = IOResolver.getIOResolverInstance();
	}

	public BattleResult doBattle() {
		GameArena gameArena = GameArena.getGameArena(settings.getXArenaDimension(), settings.getYArenaDimension());
		CheckerAlgorithm checker = new CheckerAlgorithm(gameArena, settings.getWinningCondition());
		boolean someoneWin = false;
		int cnt = 0;
		TablePrinter.printArena(gameArena); 
		Symbol symbol = null;
		do{
			if(cnt%2 == 0) {
				symbol = settings.getWhoStarts();
			} else {
				symbol = symbol.getOppositeSymbol(settings.getWhoStarts());
			}
			someoneWin = doMove(symbol, gameArena, checker);
			if(someoneWin) {
				ioResolver.resolveIO("empty.battleWinner", symbol.toString());
				return new BattleResult(symbol, symbol.getOppositeSymbol(symbol), true);
			}
	    	cnt++;
	    	TablePrinter.printArena(gameArena); 
		} while(cnt < gameArena.getAmountOfSymbols() && !someoneWin);
		ioResolver.resolveIO("empty.battleNoWinner");
		return new BattleResult(Symbol.O, Symbol.X, false);
	}
	
	private boolean doMove(Symbol symbol, GameArena gameArena, CheckerAlgorithm checker) {
		gameArena.setSymbol(symbol, isEmpty(gameArena, symbol));
		return checker.win(gameArena, symbol);
	}

	private Point isEmpty(GameArena arena, Symbol symbol) {
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
		return isEmpty(arena, symbol);
	}
	
}
