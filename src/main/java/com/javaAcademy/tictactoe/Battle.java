package com.javaAcademy.tictactoe;

import java.util.Scanner;

import com.javaAcademy.tictactoe.businessLogic.CheckerAlgorithm;
import com.javaAcademy.tictactoe.model.BattleResult;
import com.javaAcademy.tictactoe.model.GameArena;
import com.javaAcademy.tictactoe.model.GameSettings;
import com.javaAcademy.tictactoe.model.Point;
import com.javaAcademy.tictactoe.model.Symbol;
import com.javaAcademy.tictactoe.view.TablePrinter;


public class Battle {
	
	private static Scanner s;
	private GameSettings settings;

	public Battle(GameSettings settings) {
		this.settings = settings;
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
				System.out.println("Battle winner: " + symbol.toString());
				return new BattleResult(symbol, symbol.getOppositeSymbol(symbol), true);
			}
	    	cnt++;
	    	TablePrinter.printArena(gameArena); 
		} while(cnt < gameArena.getAmountOfSymbols() && !someoneWin);
		System.out.println("\nDRAW!");
		return new BattleResult(Symbol.O, Symbol.X, false);
	}
	
	private boolean doMove(Symbol symbol, GameArena gameArena, CheckerAlgorithm checker) {
		gameArena.setSymbol(symbol, isEmpty(gameArena, symbol));
		return checker.win(gameArena, symbol);
	}

	private static Point isEmpty(GameArena arena, Symbol symbol) {
		s = new Scanner(System.in);
		System.out.println("\nNow player: " + symbol + " move.");
		
		System.out.println("\nChoose x: ");
    	final int yDim = Integer.parseInt(s.nextLine());
    	
    	System.out.println("\nChoose y: ");
    	final int xDim = Integer.parseInt(s.nextLine());
    	
    	
    	System.out.println("You chose: " + xDim+"|"+yDim);
		
		if((arena.getArena()[xDim][yDim]).equals(Symbol.EMPTY)) {
			return new Point(xDim,yDim);
		}
		System.out.println("Point is occupied! Please choose new");
		return isEmpty(arena, symbol);
	}
	
}
