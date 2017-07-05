package com.javaAcademy.tictactoe.helper.resolversImpl;

import java.util.Locale;

import com.javaAcademy.tictactoe.exceptions.CancelGameException;
import com.javaAcademy.tictactoe.exceptions.IllegalMoveException;
import com.javaAcademy.tictactoe.helper.DataParser;
import com.javaAcademy.tictactoe.helper.DataResolver;
import com.javaAcademy.tictactoe.helper.UserIO;

public class CoordResolver<T> extends DataResolver<T> {


	public CoordResolver(Locale locale) {
		super(locale);
	}

	@Override
	public void resolveIO(String key, Object ...params) {
		try {
			showMessage(key);
			String data = UserIO.getUserInput();
			if(isCancelGame(data)) {
				throw new CancelGameException("Cancel game");
			}
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
		System.out.println("Sprawdzam coord: " + params[0] + "  " + params[1]);
		Integer dimension = (Integer) params[1];
		checkCoord(dimension, coord);
	}
	
	@SuppressWarnings("unchecked")
	private void checkCoord(int dimension, Integer data) {
		System.out.println(dimension + "  i data: " + data);
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
