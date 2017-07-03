package com.javaAcademy.tictactoe.model;


public class GameSettings {
	
	private String whoStarts;
	private int winningCondition;
	private int xArenaDimension;
	private int yArenaDimension;
	private int amountOfBattles;
	
	public GameSettings(String whoStarts, int winningCondition, int xArenaDimension, 
			int yArenaDimension, int amountOfBattles) {
		super();
		this.whoStarts = whoStarts;
		this.winningCondition = winningCondition;
		this.xArenaDimension = xArenaDimension;
		this.yArenaDimension = yArenaDimension;
		this.amountOfBattles = amountOfBattles;
	}

	public Symbol getWhoStarts() {
		if(whoStarts.equals("O")) {
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
