package com.atomic.abstractgame;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActorGame extends Actor {
	
	private TextureRegion textureActor;
	private int posX;
	private int posY;
	private float startBroadX;
	private float startBroadY;
	
	public ActorGame(TextureRegion _textureActor, int _posX, int _posY, float _startBroadX, float _startBroady) {
		textureActor = _textureActor;
		startBroadX = _startBroadX;
		startBroadY = _startBroady;
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		batch.setColor(this.getColor());
		batch.draw(textureActor, (startBroadY + posY)*53, (startBroadX + posX)*53);
	}
}
