package com.badlogic.androidgames.framework.impl;

import android.graphics.Bitmap;

import com.badlogic.androidgames.framework.Graphics.PixmapFormat;
import com.badlogic.androidgames.framework.Pixmap;

public class AndroidPixmap implements Pixmap {
    Bitmap bitmap;
    PixmapFormat format;
    
    public AndroidPixmap(Bitmap bitmap, PixmapFormat format) {
        this.bitmap = bitmap;
        this.format = format;
    }
    
    public AndroidPixmap(Bitmap bitmap, PixmapFormat format, int width, int height) {
        this.bitmap = Bitmap.createScaledBitmap(bitmap, width, height, false);
        this.format = format;
    }

    @Override
    public int getWidth() {
        return bitmap.getWidth();
    }

    @Override
    public int getHeight() {
        return bitmap.getHeight();
    }
    
    @Override
    public void setWidth(int width) {
    	this.bitmap = Bitmap.createScaledBitmap(bitmap, width, bitmap.getHeight(), false);
    }
    
    @Override
    public void setHeight(int height) {
    	this.bitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), height, false);
    }
    
    @Override
    public void setSize(int width, int height) {
    	this.bitmap = Bitmap.createScaledBitmap(bitmap, width, height, false);
    }
    
    @Override
    public PixmapFormat getFormat() {
        return format;
    }

    @Override
    public void dispose() {
        bitmap.recycle();
    }

}
