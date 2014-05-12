package com.atomic.game;

import java.util.ArrayList;

import com.atomic.helper.AbstractActor;
import com.atomic.helper.ButtonGame;
import com.atomic.helper.MenuCreator;
import com.atomic.option.ASSET;
import com.atomic.option.OPTION_GAME;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Lazy extends AbstractActor{

	private int x;
	private int y;
	private String id;
	private int col = 7;
	private ArrayList connect = new ArrayList();
	
	public Lazy(TextureRegion _textureRegion, int _posX, int _posY, int _width,
			int _height) {
		super(_textureRegion, _posX*53, _posY*53, _width, _height);
		x = _posX;
		y = _posY;
		
	}
	
	public void setUpConnect(String con) {
		for (int i = 0; i < OPTION_GAME.BOND_KIND.length; i++) {
			if (OPTION_GAME.BOND_KIND[i][0].equals(con)) {
				System.out.print("katomic/"+OPTION_GAME.BOND_KIND[i][1]+".png");
				TextureRegion textu = new TextureRegion(ASSET.loadTexture("katomic/"+OPTION_GAME.BOND_KIND[i][1]+".png"));
				connect.add(textu);
			}
		}
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		for (int i = 0; i < connect.size(); i++) {
			batch.draw((TextureRegion) connect.get(i), x*53, y*53);
		}
		super.draw(batch, parentAlpha);
	}
	
	public int getLazyPointX() {
		return x;
	}

	public int getLazyPointY() {
		return y;
	}
}
