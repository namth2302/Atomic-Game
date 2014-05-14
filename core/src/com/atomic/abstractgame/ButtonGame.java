package com.atomic.abstractgame;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class ButtonGame extends Button{
	
	private boolean isShowActive = true;
	
	public ButtonGame(Drawable _up, Drawable _down) {
		super(_up, _down);
	}
	
	public void setIsActive(boolean _isActive) {
		isShowActive = _isActive;
	}
	
	@Override
	public Actor hit(float x, float y, boolean touchable) {
		if (isShowActive) {
			return super.hit(x, y, touchable);
		} else {
			return null;
		}
		
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
	}
}
