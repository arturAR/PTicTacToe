package com.javaAcademy.tictactoe.helper.resolversImpl;

import java.util.Locale;

import com.javaAcademy.tictactoe.exceptions.IllegalMoveException;
import com.javaAcademy.tictactoe.helper.DataParser;
import com.javaAcademy.tictactoe.helper.DataResolver;
import com.javaAcademy.tictactoe.helper.UserIO;

public class CoordResolver<T> extends DataResolver<T> {
	
	//TODO input implementation by injection
	//Supplier<String> input = UserIO::getUserInput;

	public CoordResolver(Locale locale) {
		super(locale);
	}

	@Override
	public void resolveIO(String key, Object ...params) {
		try {
			showMessage(key);
			//String data = input.get();//UserIO.getUserInput();
			String data = UserIO.getUserInput();
			
			checkIfCancelGame(data); 
			
			int coord = DataParser.parseToInt(data);
			checkData(coord, params);
		} catch(IllegalMoveException e) {
			showMessage("empty.illegalCoord");
			resolveIO(key, params);
		} catch(NumberFormatException e) {
			showMessage("empty.noNumberException");
			resolveIO(key, params);
		}
	}

	private void checkData(int coord, Object[] params) {
		Integer dimension = (Integer) params[1];
		checkCoordIsOnBoard(dimension, coord);
	}
	
	@SuppressWarnings("unchecked")
	private void checkCoordIsOnBoard(int dimension, Integer data) {
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
