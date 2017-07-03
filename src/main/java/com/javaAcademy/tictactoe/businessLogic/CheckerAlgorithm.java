package com.javaAcademy.tictactoe.businessLogic;

import com.javaAcademy.tictactoe.businessLogic.directions.AscendingDirection;
import com.javaAcademy.tictactoe.businessLogic.directions.DescendingDirection;
import com.javaAcademy.tictactoe.businessLogic.directions.HoryzontalDirection;
import com.javaAcademy.tictactoe.businessLogic.directions.VerticalDirection;
import com.javaAcademy.tictactoe.model.GameArena;
import com.javaAcademy.tictactoe.model.Point;
import com.javaAcademy.tictactoe.model.Symbol;

public class CheckerAlgorithm {
	
	private GameArena arena;
	private boolean isWinner = false;
	private int winCondition;
	
	public CheckerAlgorithm(GameArena gameArena, int winCondition) {
		this.arena = gameArena;
		this.winCondition = winCondition;
	}

	public boolean win(GameArena arena, Symbol checkedSymbol) {
		check(checkedSymbol);
		return isWinner;
	}
	
	private void check(Symbol userChar) {
		for(int x = 1; x < arena.getXDimension(); x++) {
			for(int y = 1; y < arena.getYDimension(); y++) {
				try {
					checkFromPoint(x, y, new VerticalDirection(), userChar);
				} catch(ArrayIndexOutOfBoundsException e) {}
				try {
					checkFromPoint(x, y, new HoryzontalDirection(), userChar);
				} catch(ArrayIndexOutOfBoundsException e) {}
				try {
					checkFromPoint(x, y, new DescendingDirection(), userChar);
				} catch(ArrayIndexOutOfBoundsException e) {}
				try {
					checkFromPoint(x, y, new AscendingDirection(), userChar);
				} catch(ArrayIndexOutOfBoundsException e) {}
			}
		}
	}
	
	private void checkFromPoint(int x, int y, Direction direction, Symbol symbol) {
		int cnt = 0;
		for(int i = 0; i < winCondition ; i++) {
			if(symbol.equals(arena.getArena()[x][y])) {
				cnt++;
			}
			Point point = direction.getNextPoint(x, y);
			x = point.getX();
			y = point.getY();
		}
		if(cnt == winCondition) {
			isWinner = true;
		}
	}
}

