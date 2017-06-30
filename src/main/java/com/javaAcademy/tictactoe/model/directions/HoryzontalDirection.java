package com.javaAcademy.tictactoe.model.directions;

import com.javaAcademy.tictactoe.model.Direction;
import com.javaAcademy.tictactoe.model.Point;

public class HoryzontalDirection implements Direction{

	@Override
	public Point getNextPoint(int x, int y) {
		x++;
		return new Point(x,y);
	}

}
