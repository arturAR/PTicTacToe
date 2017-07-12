package com.javaAcademy.tictactoe.io;

import com.javaAcademy.tictactoe.model.GameArena;
import com.javaAcademy.tictactoe.model.Type;

public interface Printer {
	
	void printMessage(String message);

	void printMessageWithParam(String key, Object[] params);
	
	void setType(Type type);
	
	void printArena(GameArena arena);
}