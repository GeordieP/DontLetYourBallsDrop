package com.badlogic.androidgames.dontletyourballsdrop;

import com.badlogic.androidgames.framework.Pixmap;
import com.badlogic.androidgames.framework.Graphics;

public class GUIButton {
	
	private Pixmap buttonTexture;
	private Rectangle buttonRectangle;
	
	public GUIButton() {
		this.buttonRectangle = new Rectangle(0, 0, 20, 20);
	}
	
	public GUIButton(Pixmap _texture, int _x, int _y) {
		this.buttonRectangle = new Rectangle(_x, _y, _texture.getWidth(), _texture.getHeight());
	}
	
	public void present(Graphics g) {
		g.drawPixmap(buttonTexture, (int)buttonRectangle.x, (int)buttonRectangle.y);
	}
	
	public boolean checkTapped(Vector2 touchPos) {
		// create a temporary rectangle at the touch position to check intersection with the button's rectangle
		// rectangle is 6x6, positioned at touchPos - 3 to make sure it's centered
		return buttonRectangle.intersects(new Rectangle((touchPos.x - 3), (touchPos.y - 3), 6, 6));
	}
}
