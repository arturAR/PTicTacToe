package com.javaAcademy.tictactoe.view;

import com.javaAcademy.tictactoe.model.GameArena;
import com.javaAcademy.tictactoe.model.Type;

public interface Printer {
	
	void printMessage(String message);

	void showMessageWithParam(String key, Object[] params);
	
	void setType(Type type);
	
	void printArena(GameArena arena);
}