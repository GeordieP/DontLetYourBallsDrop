package com.badlogic.androidgames.dontletyourballsdrop;

import java.util.List;

import android.graphics.Color;

import com.badlogic.androidgames.framework.Game;
import com.badlogic.androidgames.framework.Graphics;
import com.badlogic.androidgames.framework.Input.TouchEvent;
import com.badlogic.androidgames.framework.Pixmap;
import com.badlogic.androidgames.framework.Screen;

public class GameScreen extends Screen {
    enum GameState {
        Ready,
        Running,
        Paused,
        GameOver
    }
    
    GameState state = GameState.Ready;
    Ball ball;
    public Rectangle ballHitRect;
    
    public GameScreen(Game game) {
        super(game);
        state = GameState.Ready;
        // create ball, initially center horizontally, place near the top vertically
        ball = new Ball((game.getGraphics().getWidth() / 2 - Assets.ball.getWidth() / 2), game.getGraphics().getHeight() / 4);
        
        ballHitRect = new Rectangle(
        		(game.getGraphics().getWidth() / 2 - (game.getGraphics().getWidth() / 3) / 2),
        		game.getGraphics().getHeight() - game.getGraphics().getHeight() / 4,
        		game.getGraphics().getWidth() / 3,
        		game.getGraphics().getWidth() / 3);
    }

    @Override
    public void update(float deltaTime) {
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();
     
        
        switch(state) {
        case Ready:
        	updateReady(touchEvents);
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
    
    private void updateRunning(List<TouchEvent> touchEvents, float deltaTime) {
        if(touchEvents.size() > 0) { 
        	Vector2 touchPosition = new Vector2(touchEvents.get(0).x, touchEvents.get(0).y);
        }
        
        if ((touchEvents.size() > 0) && (ballHitRect.intersects(ball.collisionRectangle))) {
        	ball.bounce();
        }
        
        ball.update(deltaTime);
    }
    
    private void updateReady(List<TouchEvent> touchEvents) {
        if(touchEvents.size() > 0)
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