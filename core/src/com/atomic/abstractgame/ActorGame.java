package com.atomic.abstractgame;

import java.util.ArrayList;

import com.atomic.asset.Asset;
import com.atomic.game.ScreenGame;
import com.atomic.option.OptionGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class ActorGame extends Actor {
	
	private TextureRegion textureActor;
	private int posX;
	private int posY;
	private float startBroadX;
	private float startBroadY;
	private int posScreen;
	private String id;
	private String type;
	private String lstLink;
	
	private ArrayList<TextureRegion> lstDrawLink = new ArrayList<TextureRegion>();
	private ScreenGame screen;
	
	public ActorGame(ScreenGame _screen){
		super();
		screen = _screen;
	}
	
	public void setUpActor() {
		setPosition(startBroadX + posY*53, startBroadY + posScreen*53);
		setSize(53, 53);
	}
	
	public void addInputListeners() {
		addListener(new InputListener(){
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				screen.setID(getId());
				screen.setPointXY(posX, posY);
				screen.setPosBtnMove();
				screen.showBtnMove();
				Gdx.app.log("SHOW: ", "" + id);
				return false;
			}
			
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
	
			}
		});
	}
	
	public void setUpAuto() {
		String[] lstTemp = lstLink.split("");
		for (int i = 0; i < OptionGame.ITEM_KIND.length; i++) {
			if (type.equals(OptionGame.ITEM_KIND[i][0])) {
				textureActor = new TextureRegion(Asset.loadTexture("katomic/"+OptionGame.ITEM_KIND[i][1]+".png"));				
			}
		}
		for (int i = 0; i < lstTemp.length; i++) {
			for (int j = 0; j < OptionGame.BOND_KIND.length; j++) {
				if (lstTemp[i].equals(OptionGame.BOND_KIND[j][0])) {
					TextureRegion region = new TextureRegion(Asset.loadTexture("katomic/"+OptionGame.BOND_KIND[j][1]+".png"));
					lstDrawLink.add(region);
				}
			}
		}
	}
	
	public ActorGame(TextureRegion _textureActor, int _posX, int _posY, float _startBroadX, float _startBroadY, int _posScreen) {
		textureActor = _textureActor;
		startBroadX = _startBroadX;
		startBroadY = _startBroadY;
		posX = _posX;
		posY = _posY;
		posScreen = _posScreen;
	}
	
	
	public void setPosActor(int _x, int _y) {
		posX = _x;
		posY = _y;
	}
	
	public void setStartBroad(float x, float y) {
		startBroadX = x;
		startBroadY = y;
	}
	
	public void setPosScreen(int n) {
		posScreen = n;
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		batch.setColor(this.getColor());
		batch.draw(textureActor, startBroadX + posY*53, startBroadY + posScreen*53);
		for (int i = 0; i < lstDrawLink.size(); i++) {
			batch.draw((TextureRegion)lstDrawLink.get(i), startBroadX + posY*53, startBroadY + posScreen*53);
		}
	}
	
	public void setId(String _id) {
		id = _id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setType(String _type) {
		type = _type;
	}
	
	public void setLstLink(String _lstLink) {
		lstLink = _lstLink;
	}
	
	public int getPosX() {
		return posX;
	}
	
	public int getPoxY() {
		return posY;
	}
}
