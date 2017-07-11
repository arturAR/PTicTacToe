package com.javaAcademy.tictactoe.model;

public enum Symbol {
	X("X") {
		@Override
		public Symbol getOppositeSymbol() {
			return O;
		}
	},
	O("O") {
		@Override
		public Symbol getOppositeSymbol() {
			return X;
		}
	},
	EMPTY(" ") {
		@Override
		public Symbol getOppositeSymbol() {
			return EMPTY;
		}
	};
	
	private String symbol;
	
	private Symbol(String symbol) {
		this.symbol = symbol;
	}

	public String toString() {
		return symbol;
	}
	
	public abstract Symbol getOppositeSymbol();
}
