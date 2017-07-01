package com.javaAcademy.tictactoe.model;

public enum Symbol {
	X("X"),
	O("O"),
	EMPTY(" ");
	
	private String symbol;
	
	private Symbol(String symbol) {
		this.symbol = symbol;
	}

	public String toString() {
		return symbol;
	}
	
	public Symbol getOppositeSymbol(Symbol toSymbol) {
		if(toSymbol.equals(X)) {
			return O;
		}
		return X;
	}
}
