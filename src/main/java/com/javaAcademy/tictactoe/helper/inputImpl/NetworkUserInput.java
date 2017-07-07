package com.javaAcademy.tictactoe.helper.inputImpl;

import com.javaAcademy.tictactoe.helper.UserInput;
import com.javaAcademy.tictactoe.model.Type;

public class NetworkUserInput implements UserInput{

	private Type type;
	
	@Override
	public String getUserInput() {
		if(type.equals(Type.SERVER)) {
    		return getUserInput();
    	}
    	return "";
	}
}
