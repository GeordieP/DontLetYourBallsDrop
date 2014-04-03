package com.badlogic.androidgames.dontLetYourBallsDrop;

import java.util.Random;
import android.graphics.Color;
import com.badlogic.androidgames.framework.Game;
import com.badlogic.androidgames.framework.Graphics;
import com.badlogic.androidgames.framework.Screen;

public class GameScreen extends Screen {
    private short screenWidth, screenHeight;
    public Graphics gfx;
    Random random = new Random();

    public GameScreen(Game game) {
        super(game);

        gfx = game.getGraphics();

        screenWidth = (short)gfx.getWidth();
        screenHeight = (short)gfx.getHeight();
    }


    /* -- UPDATE -- */
    @Override
    public void update(float deltaTime) { }


    /* -- DRAW -- */
    @Override
    public void present(float deltaTime) {
        gfx.clear(Color.BLACK);
    }

    @Override
    public void pause() { }

    @Override
    public void resume() { }

    @Override
    public void dispose() { }
}