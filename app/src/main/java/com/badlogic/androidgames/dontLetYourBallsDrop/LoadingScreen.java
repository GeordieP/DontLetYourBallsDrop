package com.badlogic.androidgames.dontLetYourBallsDrop;

import com.badlogic.androidgames.framework.Audio;
import com.badlogic.androidgames.framework.Game;
import com.badlogic.androidgames.framework.Graphics;
import com.badlogic.androidgames.framework.Screen;

public class LoadingScreen extends Screen {
    public LoadingScreen(Game game) {
        super(game);
    }

    @Override
    public void update(float deltaTime) {
        Graphics gfx = game.getGraphics();
        Audio snd = game.getAudio();

        /* Load 'Assets.variable' content here */
        /* Using snd.newSound(), gfx.newPixmap(), etc*/

        game.setScreen(new GameScreen(game));
    }

    @Override
    public void present(float deltaTime) {

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