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
    
    public GameScreen(Game game) {
        super(game);
    }

    @Override
    public void update(float deltaTime) {
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();
        
        switch(state) {
        case Running:
        	break;
        case Ready:
        	break;
        case Paused:
        	break;
        case GameOver:
        	break;
        }
    }
    
    private void updateRunning(List<TouchEvent> touchEvents, float deltaTime) {        
    }    

    @Override
    public void present(float deltaTime) {
        Graphics g = game.getGraphics();
        
        // have methods to draw GUI for each state?
        
        g.drawPixmap(Assets.background, 0, 0);
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