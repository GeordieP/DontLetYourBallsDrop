package com.badlogic.androidgames.dontletyourballsdrop;

import java.util.List;

import android.graphics.Color;

import com.badlogic.androidgames.framework.Game;
import com.badlogic.androidgames.framework.Graphics;
import com.badlogic.androidgames.framework.Input.TouchEvent;
import com.badlogic.androidgames.framework.Screen;

public class GameScreen extends Screen {
	
	private GUIButton restartBtn;
	
    enum GameState {
        Ready,
        Running,
        Paused,
        GameOver
    }
    
    GameState state = GameState.Ready;
    Ball ball;
    public Rectangle ballHitRect;

    Vector2 touchPosition;
    float dTime = 0.0f;

    public GameScreen(Game game) {
        super(game);
        game.getInput().clearTouches();
        Graphics g = game.getGraphics();
        state = GameState.Ready;
        dTime = 0.0f;
        
        // create ball, initially center horizontally, place near the top vertically
        ball = new Ball((game.getGraphics().getWidth() / 2 - Assets.ball.getWidth() / 2), game.getGraphics().getHeight() / 4);
        
        ballHitRect = new Rectangle(
        		(game.getGraphics().getWidth() / 2 - (game.getGraphics().getWidth() / 3) / 2),
        		game.getGraphics().getHeight() - game.getGraphics().getHeight() / 4,
        		game.getGraphics().getWidth() / 3,
        		game.getGraphics().getWidth() / 3);
        
        restartBtn = new GUIButton(Assets.settingsBtn, (g.getWidth() / 2 - Assets.settingsBtn.getWidth() / 2), (g.getHeight() - (g.getHeight() - 20) - Assets.settingsBtn.getHeight() / 2));
        
    }

    @Override
    public void update(float deltaTime) {
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
//        game.getInput().getKeyEvents();
     
        
        switch(state) {
        case Ready:
        	updateReady(touchEvents, deltaTime);
        	break;
        case Running:
        	updateRunning(touchEvents, deltaTime);
        	break;
        case Paused:
        	break;
        case GameOver:
        	break;
        }
    }
    
    boolean canBounce = true;
    
    private void updateRunning(List<TouchEvent> touchEvents, float deltaTime) {
        
    	if(touchEvents.size() > 0) { 
        	touchPosition = new Vector2(touchEvents.get(0).x, touchEvents.get(0).y);
        	dTime += deltaTime;	// count seconds that the screen has been touched
        	if (dTime > 0.1) {
        		canBounce = false;
        	}
        	
        	if (canBounce && ballHitRect.intersects((ball.collisionRectangle))) {
        		ball.bounce();
        	}
        }
        
        if (restartBtn.checkTapped(touchPosition)) {
        	restartGame();
        }

        if (touchEvents.size() == 0) {
        	canBounce = true;
        	dTime = 0;
        	
        }
        
//        if ((dTime += deltaTime) > 5 && (touchEvents.size() > 0) && (ballHitRect.intersects(ball.collisionRectangle))) {
//        	ball.bounce();
//        }
        
        ball.update(deltaTime);
        
        
    }
    
    private void updateReady(List<TouchEvent> touchEvents, float deltaTime) {
        if((dTime += deltaTime) > 0.7f && touchEvents.size() > 0)		// only continue if dTime is > 0.7 seconds
            state = GameState.Running;
    }
    
    @Override
    public void present(float deltaTime) {
        Graphics g = game.getGraphics();
        
        // have methods to draw GUI for each state?
        switch(state) {
        case Running:
            g.drawPixmap(Assets.background, 0, 0);
            g.drawRect((int)ballHitRect.x, (int)ballHitRect.y, (int)ballHitRect.width, (int)ballHitRect.height, Color.BLUE);
            ball.present(g);
            
            restartBtn.present(g);
        	break;
        case Ready:
            g.drawPixmap(Assets.background, 0, 0);
            g.drawRect((int)ballHitRect.x, (int)ballHitRect.y, (int)ballHitRect.width, (int)ballHitRect.height, Color.BLUE);
            ball.present(g);
        	break;
        case Paused:
        	break;
        case GameOver:
        	break;
        }
 
    }
    
    public void restartGame() {
    	game.setScreen(new MainMenuScreen(game));
    }
    
    @Override
    public void pause() {
    }

    @Override
    public void resume() {
        
    }

    @Override
    public void dispose() {
        
    }
}