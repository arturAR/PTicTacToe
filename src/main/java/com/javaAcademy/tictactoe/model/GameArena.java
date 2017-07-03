package com.javaAcademy.tictactoe.model;

public class GameArena {

	private int xDimension;
	private int yDimension;
	private Symbol[][] arena;
	
	private GameArena(int x, int y) {
		this.xDimension = x + 1;
		this.yDimension = y + 1;
		createArena();
	}
	
	private void createArena() {
		arena = new Symbol[xDimension][yDimension];
		for(int x = 0 ; x < xDimension; x++) {
			for(int y = 0 ; y < yDimension; y++) {
				arena[x][y] = Symbol.EMPTY;
			}
		}
	}

	public static GameArena getGameArena(int x , int y) {
		return new GameArena(x,y);
	}
	
	public Symbol[][] getArena() {
		return arena;
	}
	
	public int getXDimension() {
		return xDimension;
	}
	
	public int getYDimension() {
		return yDimension;
	}
	
	public int getAmountOfSymbols() {
		return (xDimension-1) * (yDimension-1);
	}
	
	public void setSymbol(Symbol symbol, Point point) {
    	arena[point.getY()][point.getX()] = symbol;
	}
}
