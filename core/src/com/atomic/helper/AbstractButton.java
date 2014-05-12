package com.atomic.helper;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public abstract class AbstractButton extends Button{
	
	protected boolean isLockActive = false;
	protected TextureRegion textureLocked;
	
	protected boolean isTextActive = false;
	protected float textPosX = 0;
	protected float textPosY = 0;
	protected String text = "";
	protected BitmapFont bitMapFont;
	
	protected boolean isExternalTextureActive = false;
	protected float externalTexturePosX = 0;
	protected float externalTexturePosY = 0;
	protected float externalTextureSizeW = 50;
	protected float externalTextureSizeH = 50;
	protected TextureRegion textureExternal;
	
	public AbstractButton(Drawable up, Drawable down) {
		super(up, down);
	}
	
	@Override
	public Actor hit(float x, float y, boolean touchable) {
		if (!isLockActive) {
			return super.hit(x, y, touchable);
		} else {
			return null;
		}
	}
	
	public boolean isLockActive() {
		return isLockActive;
	}
	
	public void setLockActive(boolean _isLockActive) {
		isLockActive = _isLockActive;
	}
	
	public TextureRegion getTextureLocked() {
		return textureLocked;
	}
	
	public void setTextureLocked(TextureRegion textureLocked, boolean isLockActive) {
		this.textureLocked = textureLocked;
		this.isLockActive = isLockActive;
	}

	public boolean isTextActive() {
		return isTextActive;
	}
	
	public void setTextActive(boolean isTextActive) {
		this.isTextActive = isTextActive;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(BitmapFont bitMapFont, String text, boolean isTextActive) {
		this.bitMapFont = bitMapFont;
		this.text = text;
		this.isTextActive = isTextActive;
	}
	
	public void setTextChange(String newText){
		this.text = newText;
	}
	
	public void setTextPosXY(float x, float y){
		textPosX = x;
		textPosY = y;
	}
	
	public BitmapFont getBitMapFont() {
		return bitMapFont;
	}
	
	public void setBitMapFont(BitmapFont bitMapFont) {
		this.bitMapFont = bitMapFont;
	}
	
	public boolean isExternalTextureActive() {
		return isExternalTextureActive;
	}
	
	public void setExternalTextureActive(boolean isExternalTextureActive) {
		this.isExternalTextureActive = isExternalTextureActive;
	}
	
	public TextureRegion getTextureExternal() {
		return textureExternal;
	}
	
	public void setTextureExternal(TextureRegion textureExternal, boolean isExternalTextureActive) {
		this.textureExternal = textureExternal;
		this.isExternalTextureActive = isExternalTextureActive;
	}
	
	public void setTextureExternalPosXY(float x, float y){
		externalTexturePosX = x;
		externalTexturePosY = y;
	}
	
	public void setTextureExternalSize(float width, float height){
		externalTextureSizeW = width;
		externalTextureSizeH = width;
	}
}
