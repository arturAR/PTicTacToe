package com.javaAcademy.tictactoe.model;

public class BattleResult {

	private boolean someoneWin;
	private Symbol winner;
	private Symbol loser;

	public BattleResult(Symbol winner, Symbol loser, boolean isWinner) {
		this.someoneWin = isWinner;
		this.winner = winner;
		this.loser = loser;
	}

	public boolean isWinner() {
		return someoneWin;
	}

	public Symbol getLoser() {
		return loser;
	}
	
	public Symbol getWinner() {
		return winner;
	}
	
}
