package com.javaAcademy.tictactoe.model;


public class GameSettings {
	
	private int whoStarts;
	private int winningCondition;
	private int xArenaDimension;
	private int yArenaDimension;
	private int amountOfBattles;
	
	public GameSettings(int whoStarts, int winningCondition, int xArenaDimension, 
			int yArenaDimension, int amountOfBattles) {
		super();
		this.whoStarts = whoStarts;
		this.winningCondition = winningCondition;
		this.xArenaDimension = xArenaDimension;
		this.yArenaDimension = yArenaDimension;
		this.amountOfBattles = amountOfBattles;
	}

	public Symbol getWhoStarts() {
		if(whoStarts == 1) {
			return Symbol.O;
		}
		return Symbol.X;
	}

	public int getWinningCondition() {
		return winningCondition;
	}

	public int getXArenaDimension() {
		return xArenaDimension;
	}

	public int getYArenaDimension() {
		return yArenaDimension;
	}
	
	public int getAmountOfBattles() {
		return amountOfBattles;
	}
}
