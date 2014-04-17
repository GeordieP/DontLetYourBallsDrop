package com.badlogic.androidgames.dontletyourballsdrop;

import android.graphics.Color;

import com.badlogic.androidgames.framework.Graphics;

public class Ball {

	public Vector2 position, gravity, vi, vf, netForce;
	private float moveSpeed = 2.0f;
	public float mass;
	public Rectangle collisionRectangle;
	
	public Ball(float _x, float _y) {
		position = new Vector2(_x, _y);
		
		gravity = new Vector2(0.0f, 9.8f);
		netForce = new Vector2(0.0f, 0.0f);
		vi = new Vector2(0.0f, 0.0f);
		vf = new Vector2(0.0f, 0.0f);
		
		mass = 100.0f;
		
		collisionRectangle = new Rectangle(
				(position.x + Assets.ball.getWidth() / 2),
				(position.y + Assets.ball.getHeight() / 2),
				Assets.ball.getWidth() / 4,
				Assets.ball.getHeight() / 4);
	}
	
	public void bounce(int hitRectY) {
		
		if(netForce.y > 0)
			netForce.y -= (netForce.y * moveSpeed);
//			netForce.y *= -1;
//			netForce.y = (int)((netForce.y * -1)  + ((Math.random() * 10) + 1));
//			netForce.y = (int)((netForce.y * -0.8) + ((position.y - hitRectY) * 2));
		
			netForce.y = -50500 + ((position.y - hitRectY) * 2) + (int)(Math.random() * (moveSpeed - (-moveSpeed) + 1)) + (-moveSpeed);
//			android.util.Log.w("DLYBD", "NetForce: " + netForce.y);
	}
	
	public void update(float deltaTime) {
		netForce.y += mass * gravity.y;
		position.x += vi.x * deltaTime + (0.5) * netForce.x * deltaTime * deltaTime;
		position.y += vi.y * deltaTime + (0.5) * netForce.y * deltaTime * deltaTime;
		vi = vf;
		
		collisionRectangle.x = (position.x + Assets.ball.getWidth() / 2);
		collisionRectangle.y = (position.y + Assets.ball.getHeight() / 2);
	}
	
	public void present(Graphics g) {
		g.drawPixmap(Assets.ball, (int)position.x, (int)position.y);
		g.drawRect(
				(int)collisionRectangle.x,
				(int)collisionRectangle.y,
				(int)collisionRectangle.width,
				(int)collisionRectangle.height, Color.RED);		
	}
	
	public boolean isOOB(Graphics g) {
		return (position.y > g.getHeight());
	}
}