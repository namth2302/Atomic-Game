package com.atomic.abstractgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;

public class AbstractActors extends Actor{
	
	private TextureRegion textureRegion;
	private int posX;
	private int posY;
	
	public AbstractActors(TextureRegion _textureRegion, int _posX, int _posY
			, int _width, int _height) {
		super();
		textureRegion = _textureRegion;
		setPosition(_posX, _posY);
		setSize(_width, _height);
	}
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		batch.setColor(this.getColor());
		
		batch.draw(textureRegion, getX(), getY(), getWidth(), getHeight());
	}
	
	public void addInputListeners() {
		addListener(new InputListener(){
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				Gdx.app.log("InputLog", "TOUCH DOWN");
				return true;
			}
			
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				Gdx.app.log("IngputLog", "TOUCH UP");
			}
		});
	}
	
	public void actionMoveTo (float x, float y, float duration) {
		// Move to a specific position by time
		MoveToAction action = new MoveToAction();
		action.setPosition(x, y);
		if (duration > 0) {
			action.setDuration(duration);
		}
		addAction(action);
	}
	
	public void actionMoveBy (float x ,float y, float duration) {
		// Move towards a direction during given time (NON-STOP)
		MoveByAction action = new MoveByAction();
		action.setAmount(x, y);
		if (duration > 0) {
			action.setDuration(duration);
		}
		addAction(action);
	}
}
