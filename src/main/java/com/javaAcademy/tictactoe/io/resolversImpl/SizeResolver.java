package com.javaAcademy.tictactoe.io.resolversImpl;

import java.io.IOException;

import com.javaAcademy.tictactoe.exceptions.DigitLessThanThreeException;
import com.javaAcademy.tictactoe.exceptions.WinningConditionTooBigException;
import com.javaAcademy.tictactoe.io.DataParser;
import com.javaAcademy.tictactoe.io.DataResolver;
import com.javaAcademy.tictactoe.io.Printer;
import com.javaAcademy.tictactoe.io.UserInput;


public class SizeResolver extends DataResolver<Integer> {


	public SizeResolver(UserInput userInput, Printer printer) {
		super(userInput, printer);
	}
	
	@Override
	public void resolveIO(String key, Object ...params) {
		try {
			printer.printMessage(key);
			String data = userInput.getUserInput();
			checkIfCancelGame(data); 
			
			int size = DataParser.parseToInt(data);
			checkData(size, params);
		} catch (WinningConditionTooBigException e) {
			printer.printMessage("empty.winningConditionTooBig");
			resolveIO(key, params);
		} catch (NumberFormatException e) {
			printer.printMessage("empty.noNumberException");
			resolveIO(key, params);
		} catch (DigitLessThanThreeException e) {
			printer.printMessage("empty.digitLessThan3");
			resolveIO(key, params);
		} catch (IOException e) {
			printer.printMessage("empty.ioException");
			resolveIO(key, params);
		}
	}

	void checkData(Integer size, Object[] params) {
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
			value = size;
		}
	}

	@Override
	public Integer getValue() {
		return value;
	}
}
