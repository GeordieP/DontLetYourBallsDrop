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
        Assets.ball = g.newPixmap("ball.png",  PixmapFormat.RGB565);
        
//        Assets.logo = g.newPixmap("logo.png", PixmapFormat.ARGB4444);
//        Assets.mainMenu = g.newPixmap("mainmenu.png", PixmapFormat.ARGB4444);
//        Assets.buttons = g.newPixmap("buttons.png", PixmapFormat.ARGB4444);
//        Assets.help1 = g.newPixmap("help1.png", PixmapFormat.ARGB4444);
//        Assets.help2 = g.newPixmap("help2.png", PixmapFormat.ARGB4444);
//        Assets.help3 = g.newPixmap("help3.png", PixmapFormat.ARGB4444);
//        Assets.numbers = g.newPixmap("numbers.png", PixmapFormat.ARGB4444);
//        Assets.ready = g.newPixmap("ready.png", PixmapFormat.ARGB4444);
//        Assets.pause = g.newPixmap("pausemenu.png", PixmapFormat.ARGB4444);
//        Assets.gameOver = g.newPixmap("gameover.png", PixmapFormat.ARGB4444);
//        Assets.headUp = g.newPixmap("headup.png", PixmapFormat.ARGB4444);
//        Assets.headLeft = g.newPixmap("headleft.png", PixmapFormat.ARGB4444);
//        Assets.headDown = g.newPixmap("headdown.png", PixmapFormat.ARGB4444);
//        Assets.headRight = g.newPixmap("headright.png", PixmapFormat.ARGB4444);
//        Assets.tail = g.newPixmap("tail.png", PixmapFormat.ARGB4444);
//        Assets.stain1 = g.newPixmap("stain1.png", PixmapFormat.ARGB4444);
//        Assets.stain2 = g.newPixmap("stain2.png", PixmapFormat.ARGB4444);
//        Assets.stain3 = g.newPixmap("stain3.png", PixmapFormat.ARGB4444);
//        Assets.click = game.getAudio().newSound("click.ogg");
//        Assets.eat = game.getAudio().newSound("eat.ogg");
//        Assets.bitten = game.getAudio().newSound("bitten.ogg");
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