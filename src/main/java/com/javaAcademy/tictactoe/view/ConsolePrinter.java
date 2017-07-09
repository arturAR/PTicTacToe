package com.javaAcademy.tictactoe.view;

import com.javaAcademy.tictactoe.helper.IOResolver;
import com.javaAcademy.tictactoe.model.GameArena;
import com.javaAcademy.tictactoe.model.Symbol;
import com.javaAcademy.tictactoe.model.Type;

public class ConsolePrinter implements Printer {
	
	public static void printMessageSOutLn(String message) {
		System.out.println(message);
	}
	
	public static void printMessageSOut(String message) {
		System.out.print(message);
	}
	
	public static void printMessageSErr(String message) {
		System.err.println(message);
	}
	
	public void printMessage(String key) {
		String message = IOResolver.getIOResolverInstance().getMsgByKey(key);
		printMessageSOutLn(message);
	}
	
	public void showMessageWithParam(String key, Object[] params) {
		String message = IOResolver.getIOResolverInstance().getMsgByKey(key);
		for(Object param: params) {
			message += " " + param;
		}
		ConsolePrinter.printMessageSOutLn(message);
	}

	@Override
	public void setType(Type type) {}

	@Override
	public void printArena(GameArena arena) {
		Symbol[][] playArena = arena.getArena();
		String message = "";
		for(int y = 1; y < arena.getYDimension(); y++) {
			message += "\n";
			for(int x = 1; x < arena.getXDimension(); x++) {
				message += "  |" +  printPoint(playArena[x][y]);
			}
		}
		printMessageSOutLn(message);
	}

	String printPoint(Symbol point) {
		return point.toString();
	}
}
