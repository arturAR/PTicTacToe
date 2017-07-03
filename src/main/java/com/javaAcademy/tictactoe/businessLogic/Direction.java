package com.javaAcademy.tictactoe.businessLogic;

import com.javaAcademy.tictactoe.model.Point;

public interface Direction {
	
	Point getNextPoint(int x, int y);
}
