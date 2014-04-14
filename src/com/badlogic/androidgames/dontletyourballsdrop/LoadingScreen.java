package com.badlogic.androidgames.dontletyourballsdrop;

import com.badlogic.androidgames.framework.Game;
import com.badlogic.androidgames.framework.Graphics;
import com.badlogic.androidgames.framework.Screen;
import com.badlogic.androidgames.framework.Graphics.PixmapFormat;

public class LoadingScreen extends Screen {
    public LoadingScreen(Game game) {
        super(game);
    }

    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        
        /* Main Menu */
        Assets.mainMenuBackground = g.newPixmap("mainMenuBackground.png", PixmapFormat.RGB565);
        Assets.mainMenuLogo = g.newPixmap("mainMenuLogo.png", PixmapFormat.RGB565);
        Assets.mainMenuLogo.setSize(relativeToScreenW(Assets.mainMenuLogo.getWidth()), relativeToScreenH(Assets.mainMenuLogo.getHeight()));
                
        Assets.playBtn = g.newPixmap("playBtn.png", PixmapFormat.RGB565);
        Assets.playBtn.setSize(relativeToScreenW(Assets.playBtn.getWidth()), relativeToScreenH(Assets.playBtn.getHeight()));
        
        Assets.settingsBtn = g.newPixmap("settingsBtn.png", PixmapFormat.RGB565);
        Assets.settingsBtn.setSize(relativeToScreenW(Assets.settingsBtn.getWidth()), relativeToScreenH(Assets.settingsBtn.getHeight()));
        
        Assets.creditsBtn = g.newPixmap("creditsBtn.png", PixmapFormat.RGB565);
        Assets.creditsBtn.setSize(relativeToScreenW(Assets.creditsBtn.getWidth()), relativeToScreenH(Assets.creditsBtn.getHeight()));
        
        
        /* In-Game */
        Assets.background = g.newPixmap("background.png", PixmapFormat.RGB565);
        Assets.background.setSize(g.getWidth(), g.getHeight());
        
        Assets.ball = g.newPixmap("ball.png",  PixmapFormat.RGB565);

        Assets.click = game.getAudio().newSound("click.ogg");
        Assets.ballhit = game.getAudio().newSound("ballhit.ogg");
        //Assets.bgMusic = game.getAudio().newMusic("countysidebg.ogg");
        
        /* In-Credits */
        Assets.creditNames = g.newPixmap("Credits.png", PixmapFormat.RGB565);
        
        game.setScreen(new MainMenuScreen(game));
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
    
    // Utility methods to return a size based on the ratio of the original image to the resolution it was created at (all images should be based on a 720p screen template)
    public int relativeToScreenW(int origValue) {
    	Graphics g = game.getGraphics();
    	float percentRelativeTo720 = (origValue / 720.0f) * 100.0f;
    	return (int)(g.getWidth() * (percentRelativeTo720 / 100));
    }
    
    public int relativeToScreenH(int origValue) {
    	Graphics g = game.getGraphics();
    	float percentRelativeTo720 = (origValue / 1280.0f) * 100.0f;
    	return (int)(g.getHeight() * (percentRelativeTo720 / 100));
    }
}