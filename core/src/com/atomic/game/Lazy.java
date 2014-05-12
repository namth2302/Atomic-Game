package com.atomic.game;

import java.util.ArrayList;

import com.atomic.abstractgame.AbstractActor;
import com.atomic.abstractgame.ButtonGame;
import com.atomic.abstractgame.MenuCreator;
import com.atomic.asset.Asset;
import com.atomic.option.OptionGame;
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
		for (int i = 0; i < OptionGame.BOND_KIND.length; i++) {
			if (OptionGame.BOND_KIND[i][0].equals(con)) {
				System.out.print("katomic/"+OptionGame.BOND_KIND[i][1]+".png");
				TextureRegion textu = new TextureRegion(Asset.loadTexture("katomic/"+OptionGame.BOND_KIND[i][1]+".png"));
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
