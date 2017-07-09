package com.javaAcademy.tictactoe.view;

import com.javaAcademy.tictactoe.model.GameArena;
import com.javaAcademy.tictactoe.model.Symbol;

public class TablePrinter {

	public static void printArena(GameArena arena) {
		Symbol[][] playArena = arena.getArena();
		for(int y = 1; y < arena.getYDimension(); y++) {
			ConsolePrinter.printMessageSOutLn("");
			for(int x = 1; x < arena.getXDimension(); x++) {
				ConsolePrinter.printMessageSOut("  |" +  printPoint(playArena[x][y]) );
			}
		}
	}
	
	public static String printPoint(Symbol point) {
		return point.toString();
	}	
}
