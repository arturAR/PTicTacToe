package com.javaAcademy.tictactoe.businessLogic.directions;

import com.javaAcademy.tictactoe.businessLogic.Direction;
import com.javaAcademy.tictactoe.model.Point;

public class VerticalDirection implements Direction{

	@Override
	public Point getNextPoint(int x, int y) {
		y++;
		return new Point(x,y);
	}

}
