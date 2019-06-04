package model.element;

import contract.IPosition;

public class Position implements IPosition {
	private int x;
	private int y;
	
	public Position(int x,int y) {
		this.setX(x);
		this.setY(y);
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
}
