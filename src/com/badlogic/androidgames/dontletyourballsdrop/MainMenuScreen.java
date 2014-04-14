package com.badlogic.androidgames.dontletyourballsdrop;

import java.util.List;

import android.util.Log;

import com.badlogic.androidgames.framework.Game;
import com.badlogic.androidgames.framework.Graphics;
import com.badlogic.androidgames.framework.Input.TouchEvent;
import com.badlogic.androidgames.framework.Screen;

public class MainMenuScreen extends Screen {
	
	private GUIButton playBtn, settingsBtn, creditsBtn;	
	
    public MainMenuScreen(Game game) {
        super(game);
        
        Graphics g = game.getGraphics();
        playBtn = new GUIButton(Assets.playBtn, (g.getWidth() / 2 - Assets.playBtn.getWidth() / 2), (g.getHeight() - (g.getHeight() / 3) - Assets.playBtn.getHeight() / 2));
        settingsBtn = new GUIButton(Assets.settingsBtn, (g.getWidth() / 2 - Assets.settingsBtn.getWidth() / 2), (g.getHeight() - (g.getHeight() / 5) - Assets.settingsBtn.getHeight() / 2));
        creditsBtn = new GUIButton(Assets.creditsBtn, (g.getWidth() / 2 - Assets.creditsBtn.getWidth() / 2), (g.getHeight() - (g.getHeight() / 7) - Assets.creditsBtn.getHeight() / 2));
    }   

    @Override
    public void update(float deltaTime) {
//        Graphics g = game.getGraphics();
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();
        
        if (touchEvents.size() > 0) {
//            game.setScreen(new GameScreen(game));
        	Vector2 touchPosition = new Vector2(touchEvents.get(0).x, touchEvents.get(0).y);
        	
        	// check if each button has been tapped
        	if (playBtn.checkTapped(touchPosition)) {
        		game.setScreen(new GameScreen(game));
         	} else if (creditsBtn.checkTapped(touchPosition)) {
         		//System.out.println("Credits Button Pressed!");
         		game.setScreen(new Credits(game));
         	}
        }
    }
    
    private boolean inBounds(TouchEvent event, int x, int y, int width, int height) {
        if(event.x > x && event.x < x + width - 1 && 
           event.y > y && event.y < y + height - 1) 
            return true;
        else
            return false;
    }
    
    @Override
    public void present(float deltaTime) {
        Graphics g = game.getGraphics();
        
        // Draw background image
        g.drawPixmap(Assets.mainMenuBackground, 0, 0, g.getWidth(), g.getHeight());
        
        // Draw Logo
        g.drawPixmap(Assets.mainMenuLogo, ((g.getWidth() / 2) - (Assets.mainMenuLogo.getWidth() / 2)), 30);
        
        // Draw Play Button
//        g.drawPixmap(Assets.playBtn, (g.getWidth() / 2 - Assets.playBtn.getWidth() / 2), (g.getHeight() - (g.getHeight() / 3) - Assets.playBtn.getHeight() / 2));
        
        playBtn.present(g);
        
        // Draw Settings Button
     //   g.drawPixmap(Assets.settingsBtn, (g.getWidth() / 2 - Assets.settingsBtn.getWidth() / 2), (g.getHeight() - (g.getHeight() / 5) - Assets.settingsBtn.getHeight() / 2));
      //  settingsBtn.present(g);
        
        // Draw Credits Button
       // g.drawPixmap(Assets.creditsBtn, (g.getWidth() / 2 - Assets.creditsBtn.getWidth() / 2), (g.getHeight() - (g.getHeight() / 7) - Assets.creditsBtn.getHeight() / 2));
        creditsBtn.present(g);
    }

    @Override
    public void pause() {        
//        Settings.save(game.getFileIO());
    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
