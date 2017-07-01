package com.javaAcademy.tictactoe.model;

public class Player {
	private String nick;
	private Symbol symbol;
	private int points;

	public Player(String nick, Symbol symbol) {
		this.nick = nick;
		this.symbol = symbol;
		points = 0;
	}

	public String getNick() {
		return nick;
	}

	public Symbol getSymbol() {
		return symbol;
	}
	
	public void addPoints(BattleScore battleScore) {
		points += battleScore.getPointsForResult();
	}
	
	public int getAmountOfPoints() {
		return points;
	}
}
