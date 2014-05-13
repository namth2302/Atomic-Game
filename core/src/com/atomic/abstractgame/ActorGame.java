package com.atomic.abstractgame;

import com.atomic.option.OptionGame;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActorGame extends Actor {
	
	private TextureRegion textureActor;
	private int posX;
	private int posY;
	private float startBroadX;
	private float startBroadY;
	private int posScreen;
	
	public ActorGame(TextureRegion _textureActor, int _posX, int _posY, float _startBroadX, float _startBroadY, int _posScreen) {
		textureActor = _textureActor;
		startBroadX = _startBroadX;
		startBroadY = _startBroadY;
		posX = _posX;
		posY = _posY;
		posScreen = _posScreen;
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		batch.setColor(this.getColor());
		batch.draw(textureActor, startBroadX + posY*53, startBroadY + posScreen*53);
	}
}
