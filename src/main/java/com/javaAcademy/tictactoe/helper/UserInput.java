package com.javaAcademy.tictactoe.helper;

import java.io.IOException;

import com.javaAcademy.tictactoe.model.Type;

public interface UserInput {
	
	String getUserInput() throws IOException;

	void setType(Type type);
}
