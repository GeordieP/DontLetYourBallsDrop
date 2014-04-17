package com.badlogic.androidgames.dontletyourballsdrop;

import java.util.ArrayList;
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
    Ball ball2;

    public Rectangle ballHitRect;

    Vector2 touchPosition;
    float dTime = 0.0f;
    int score = 0;
    
    public GameScreen(Game game) {
        super(game);
        game.getInput().clearTouches();
        Graphics g = game.getGraphics();
        state = GameState.Ready;
        dTime = 0.0f;
        
        ball = new Ball(game.getGraphics().getWidth() / 3 - Assets.ball.getWidth(), (game.getGraphics().getHeight() / 4) + (int)(Math.random() * (120 - (-120) + 1)) + (-120));
        ball2 = new Ball(game.getGraphics().getWidth() - game.getGraphics().getWidth() / 3, (game.getGraphics().getHeight() / 4) + (int)(Math.random() * (120 - (-120) + 1)) + (-120));

        ballHitRect = new Rectangle(
                (0),
                game.getGraphics().getHeight() - game.getGraphics().getHeight() / 4,
                game.getGraphics().getWidth(),
                game.getGraphics().getWidth() / 3);
        
        restartBtn = new GUIButton(Assets.restartBtn, (g.getWidth() / 2 - Assets.restartBtn.getWidth() / 2), (g.getHeight() - (g.getHeight() - 20) - Assets.settingsBtn.getHeight() / 2));
        
       //Assets.bgMusic.play();
    }

    @Override
    public void update(float deltaTime) {
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
//       game.getInput().getKeyEvents();
     
        
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
        	updateGameOver(touchEvents, deltaTime);
        	break;
        }
    }
    
	boolean canBounce = true;
	
    private void updateRunning(List<TouchEvent> touchEvents, float deltaTime) {
        if (ball.isOOB(game.getGraphics()) || ball2.isOOB(game.getGraphics())) { 
        	 state = GameState.GameOver;
        }
        
        
    	if(touchEvents.size() > 0) {
    		Vector2 touchPosition= new Vector2(touchEvents.get(0).x, touchEvents.get(0).y);		// position of the first touch
        	dTime += deltaTime;	// count seconds that the screen has been touched
        	if (dTime > 0.1) {
        		canBounce = false;
        	}
        	
        	if (canBounce && ballHitRect.intersects((ball.collisionRectangle))) {
        		
        		for (int i = 0; i < touchEvents.size(); i++) {
    				if (touchEvents.get(i).x < game.getGraphics().getWidth() / 2) {
        				Assets.ballhit.play(1);
                		ball.bounce((int)ballHitRect.y);
                		score++;
                		canBounce = false;
                		break;
        			}
        		}
        	}
        	
            if (canBounce && ballHitRect.intersects((ball2.collisionRectangle))) {
            	
            	for (int i = 0; i < touchEvents.size(); i++) {
        			if (touchEvents.get(i).x > game.getGraphics().getWidth() / 2) {
            			Assets.ballhit.play(1);
            			ball2.bounce((int)ballHitRect.y);
            			score++;
            			canBounce = false;
            		}
            	}
            }

        	if (restartBtn.checkTapped(touchPosition)) {
        		Assets.click.play(1);
             	restartGame();
            }
    	}
        
    	// an issue with doing it this way -- if the player taps one ball, taps the other, and taps the first again without releasing, they won't hit  
        if (touchEvents.size() == 0) {
        	canBounce = true;
        	dTime = 0;
        	
        }
        
        ball.update(deltaTime);
        ball2.update(deltaTime);
    }
    
    private void updateReady(List<TouchEvent> touchEvents, float deltaTime) {
        if((dTime += deltaTime) > 0.7f && touchEvents.size() > 0)		// only continue if dTime is > 0.7 seconds
            state = GameState.Running;
    }
    
    private void updateGameOver(List<TouchEvent> touchEvents, float deltaTime) {
   	 if((dTime += deltaTime) > 0.7f && touchEvents.size() > 0)		// only continue if dTime is > 0.7 seconds
   		game.setScreen(new MainMenuScreen(game));
	}
    
    @Override
    public void present(float deltaTime) {
        Graphics g = game.getGraphics();
        
        // have methods to draw GUI for each state?
        switch(state) {
        case Running:
            g.drawPixmap(Assets.background, 0, 0);
//            g.drawRect((int)ballHitRect.x, (int)ballHitRect.y, (int)ballHitRect.width, (int)ballHitRect.height, Color.BLUE);
            ball.present(g);
            ball2.present(g);
            g.drawText("Helvetica", "Score: " + score, 20, 15, 15);
            restartBtn.present(g);
        	break;
        case Ready:
            g.drawPixmap(Assets.background, 0, 0);
//            g.drawRect((int)ballHitRect.x, (int)ballHitRect.y, (int)ballHitRect.width, (int)ballHitRect.height, Color.BLUE);
            ball.present(g);
            ball2.present(g);
            
            g.drawText("Helvetica", "Tap to begin", 20, 100, 100);
        	break;
        case Paused:
        	break;
        case GameOver:
        	g.drawPixmap(Assets.background1, 0, 0);
        	g.drawText("Helvetica", "Game Over!", 20, 110, 50);
        	g.drawText("Helvetica", "Score: " + score, 20, 120, 100);
        	g.drawText("Helvetica", "Tap to restart", 20, 120, 130);
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