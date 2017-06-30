package com.javaAcademy.tictactoe.model;

public interface Direction {
	
	Point getNextPoint(int x, int y);
}
