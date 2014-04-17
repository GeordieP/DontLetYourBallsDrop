package com.badlogic.androidgames.dontletyourballsdrop;

import aurelienribon.tweenengine.TweenAccessor;

public class BallAccessor implements TweenAccessor<Ball> {

	public static final int SHAKE = 1;
	@Override
	public int getValues(Ball target, int tweenType, float[] returnValues) {
	       switch (tweenType) {
           case SHAKE: returnValues[0] = target.sprite.getWidth();
           			   returnValues[1] = target.sprite.getHeight();
           			   return 1;
           default: assert false; return -1;
       }
	}

	@Override
	public void setValues(Ball target, int tweenType, float[] newValues) {
	      switch (tweenType) {
           case SHAKE: target.sprite.setWidth((int) newValues[0]);
           			   target.sprite.setHeight((int) newValues[1]);
           break;
           default: target.sprite.setWidth(target.sprite.getWidth());
	      }
	}

}
