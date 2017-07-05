package com.javaAcademy.tictactoe.helper.resolversImpl;

import java.util.Locale;

import com.javaAcademy.tictactoe.exceptions.CancelGameException;
import com.javaAcademy.tictactoe.exceptions.DigitLessThanThreeException;
import com.javaAcademy.tictactoe.exceptions.WinningConditionTooBigException;
import com.javaAcademy.tictactoe.helper.DataParser;
import com.javaAcademy.tictactoe.helper.DataResolver;
import com.javaAcademy.tictactoe.helper.UserIO;

public class SizeResolver<T> extends DataResolver<T> {


	public SizeResolver(Locale locale) {
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
			int size = DataParser.parseToInt(data);
			checkData(size, params);
		} catch (WinningConditionTooBigException e) {
			showMessage("empty.winningConditionTooBig");
			resolveIO(key, params);
		} catch (NumberFormatException e) {
			showMessage("empty.noNumberException");
			resolveIO(key, params);
		} catch (DigitLessThanThreeException e) {
			showMessage("empty.digitLessThan3");
			resolveIO(key, params);
		}
	}

	@SuppressWarnings("unchecked")
	private void checkData(Integer size, Object[] params) {
		int smallestDim = -1 ;
		for (Object param : params) {
			Integer dim = (Integer) param;
			if(smallestDim == -1) {
				smallestDim = dim;
			} else {
				if(smallestDim > dim) {
					smallestDim = dim;
				}
			}
		}
		
		if(size < 3) {
			throw new DigitLessThanThreeException("Digit less than 3!");
		} else if(size > smallestDim && params.length != 0) {
			throw new WinningConditionTooBigException("Winning condition too big!");
		} else {
			value = (T) size;
		}
	}

	@Override
	public T getValue() {
		return value;
	}
}
