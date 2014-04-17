package com.badlogic.androidgames.dontletyourballsdrop;

import android.graphics.Color;

import com.badlogic.androidgames.framework.Graphics;

public class Piston extends Rectangle {
	
	private Vector2 screenDimensions;
	
	public Piston() {}
	public Piston(float x, float y, float width, float height, int screenWidth, int screenHeight) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		screenDimensions = new Vector2(screenWidth, screenHeight);
		canSpring = true;
	}
	
	public void spring(int ballY) {
		// set the Y position of the piston to the ball's Y
		// set the height of the piston to reach the bottom of the screen
		// begin retracting (hasSprung)
		this.y = ballY;
		this.height = (screenDimensions.y - ballY);
		hasSprung = true;
	}
	
	boolean canSpring, hasSprung;
	
	public void update(float deltaTime) {
		if (hasSprung) {
			// sorta 'tween' the piston back down
			if (this.y < screenDimensions.y - 30) {
				this.y += 50 * deltaTime;
			} else {
				hasSprung = false;
			}
		}
	}
	
	public void present(Graphics g) {
		g.drawRect((int)this.x, (int)this.y, (int)this.width, (int)this.height, Color.BLACK);
	}	
}
