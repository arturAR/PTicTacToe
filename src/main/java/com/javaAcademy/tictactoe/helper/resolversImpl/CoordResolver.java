package com.javaAcademy.tictactoe.helper.resolversImpl;

import com.javaAcademy.tictactoe.exceptions.IllegalMoveException;
import com.javaAcademy.tictactoe.helper.DataParser;
import com.javaAcademy.tictactoe.helper.DataResolver;
import com.javaAcademy.tictactoe.helper.UserInput;
import com.javaAcademy.tictactoe.view.Printer;

public class CoordResolver<T> extends DataResolver<T> {
	
	public CoordResolver(UserInput userInput, Printer printer) {
		super(userInput, printer);
	}

	@Override
	public void resolveIO(String key, Object ...params) {
		try {
			printer.printMessage(key);
			String data = userInput.getUserInput();
			
			checkIfCancelGame(data); 
			
			int coord = DataParser.parseToInt(data);
			checkData(coord, params);
		} catch(IllegalMoveException e) {
			printer.printMessage("empty.illegalCoord");
			resolveIO(key, params);
		} catch(NumberFormatException e) {
			printer.printMessage("empty.noNumberException");
			resolveIO(key, params);
		}
	}

	void checkData(int coord, Object[] params) {
		Integer dimension = (Integer) params[1];
		checkCoordIsOnBoard(dimension, coord);
	}
	
	@SuppressWarnings("unchecked")
	void checkCoordIsOnBoard(int dimension, Integer data) {
		if(data < dimension && data > 0) {
			value = (T) data;
		} else {
			throw new IllegalMoveException();
		}
	}

	@Override
	public T getValue() {
		return value;
	}

}
