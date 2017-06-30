package com.javaAcademy.tictactoe.model.directions;

import com.javaAcademy.tictactoe.model.Direction;
import com.javaAcademy.tictactoe.model.Point;

public class DescendingDirection implements Direction{

	@Override
	public Point getNextPoint(int x, int y) {
		x++;
		y++;
		return new Point(x,y);
	}

}
