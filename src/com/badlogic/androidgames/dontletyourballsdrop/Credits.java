package com.badlogic.androidgames.dontletyourballsdrop;

import java.util.List;

import com.badlogic.androidgames.framework.Game;
import com.badlogic.androidgames.framework.Graphics;
import com.badlogic.androidgames.framework.Screen;
import com.badlogic.androidgames.framework.Input.TouchEvent;

public class Credits extends Screen {

    float dTime = 0.0f;
	
	public Credits(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(float deltaTime) {
		// TODO Auto-generated method stub
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();
        
		if((dTime += deltaTime) > 0.7f && touchEvents.size() > 0) {		// only continue if dTime is > 0.7 seconds
        	game.setScreen(new MainMenuScreen(game));
        }
	}

	@Override
	public void present(float deltaTime) {
		Graphics g = game.getGraphics();
		g.drawPixmap(Assets.mainMenuBackground, 0, 0, g.getWidth(), g.getHeight());
		g.drawPixmap(Assets.creditNames, 0, 0, g.getWidth(), g.getHeight());
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	

}
