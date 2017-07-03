package com.javaAcademy.tictactoe.businessLogic.directions;

import com.javaAcademy.tictactoe.businessLogic.Direction;
import com.javaAcademy.tictactoe.model.Point;

public class HoryzontalDirection implements Direction{

	@Override
	public Point getNextPoint(int x, int y) {
		x++;
		return new Point(x,y);
	}

}
