package com.badlogic.androidgames.dontletyourballsdrop;

public class Rectangle {
	public float x, y, width, height;
	
	public Rectangle() { }
	
	public Rectangle(float _x, float _y, float _width, float _height) {
		this.x = _x;
		this.y = _y;
		this.width = _width;
		this.height = _height;
	}
	
	public boolean intersects(Rectangle otherRect) {
		return ((otherRect.x > this.x)
				&& (otherRect.x < (this.x + this.width))
				&& (otherRect.y > this.y)
				&& (otherRect.y < (this.y + this.height))
		);
	}
}