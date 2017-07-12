package com.javaAcademy.tictactoe.io.resolversImpl;

import java.io.IOException;

import com.javaAcademy.tictactoe.exceptions.IllegalMoveException;
import com.javaAcademy.tictactoe.io.DataParser;
import com.javaAcademy.tictactoe.io.DataResolver;
import com.javaAcademy.tictactoe.io.Printer;
import com.javaAcademy.tictactoe.io.UserInput;

public class CoordResolver extends DataResolver<Integer> {
	
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
		} catch(IOException e) {
			printer.printMessage("empty.ioException");
			resolveIO(key, params);
		}
	}

	void checkData(int coord, Object[] params) {
		Integer dimension = (Integer) params[1];
		checkCoordIsOnBoard(dimension, coord);
	}
	
	void checkCoordIsOnBoard(int dimension, Integer data) {
		if(data < dimension && data > 0) {
			value = data;
		} else {
			throw new IllegalMoveException("Coordinate out of board!");
		}
	}

	@Override
	public Integer getValue() {
		return value;
	}

}
