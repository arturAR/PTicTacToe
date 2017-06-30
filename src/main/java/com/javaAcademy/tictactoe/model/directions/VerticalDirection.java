package com.javaAcademy.tictactoe.model.directions;

import com.javaAcademy.tictactoe.model.Direction;
import com.javaAcademy.tictactoe.model.Point;

public class VerticalDirection implements Direction{

	@Override
	public Point getNextPoint(int x, int y) {
		y++;
		return new Point(x,y);
	}

}
