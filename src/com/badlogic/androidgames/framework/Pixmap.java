package com.badlogic.androidgames.framework;

import com.badlogic.androidgames.framework.Graphics.PixmapFormat;

public interface Pixmap {
    public int getWidth();

    public int getHeight();
    
    public void setWidth(int width);
    public void setHeight(int height);
    public void setSize(int width, int height);

    public PixmapFormat getFormat();

    public void dispose();
}
