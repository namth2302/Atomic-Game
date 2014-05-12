package com.atomic.game;
import com.atomic.helper.AbstractScreen;
import com.atomic.helper.BroadGame;
import com.atomic.helper.ButtonGame;
import com.atomic.helper.MenuCreator;
import com.atomic.option.ASSET;
import com.atomic.option.OPTION_GAME;
import com.atomic.option.jlevel;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Json;
import com.sun.java_cup.internal.runtime.Symbol;

public class ScreenGame extends AbstractScreen{
	
	private Image avatar;
	private ButtonGame btnRedo;
	private ButtonGame btnUndo;
	private ButtonGame btnReset;
	private ButtonGame btnUp;

	
	private BroadGame broad;
 	
//	private Lazy lazy;
	
	public ScreenGame(Game _game, String _nameScreen) {
		super(_game, _nameScreen);
	}

	@Override
	public void setUpScreenElement() {
		Json json = new Json();
		jlevel text = json.fromJson(jlevel.class, Gdx.files.internal("item/katomicLevel.json"));
		broad = new BroadGame(text, json);
		setBackButton(true);

		setBackground(new TextureRegion(ASSET.loadTexture("imgBG.jpg")));
		
		
		initial();
	}
	
	private void initial() {
//		lazy = new Lazy(ASSET.imgAtomBr, 1, 1, 53, 53);
//		lazy.setUpConnect("c");
//		getStage().addActor(lazy);
		setUpButtonGame();
		setUpMapGame();
	}
	
	private void setUpButtonGame() {
		btnRedo = MenuCreator.createCustomGameButton(ASSET.btnRecno, ASSET.btnRecno);
		btnRedo.setSize(70, 70);
		btnRedo.setPosition(1030, 200);
		getStage().addActor(btnRedo);
		
		btnUndo = MenuCreator.createCustomGameButton(ASSET.btnUndo, ASSET.btnUndo);
		btnUndo.setSize(70, 70);
		btnUndo.setPosition(900, 200);
		getStage().addActor(btnUndo);
		
		btnReset = MenuCreator.createCustomGameButton(ASSET.btnReset, ASSET.btnReset);
		btnReset.setSize(80, 80);
		btnReset.setPosition(1150, 190);
		getStage().addActor(btnReset);
		
//		btnUp = MenuCreator.createCustomGameButton(ASSET.imgBtnUp, ASSET.imgBtnUp);
//		btnUp.setSize(53, 53);
//		btnUp.setPosition(lazy.getLazyPointX()*53, (lazy.getLazyPointY()+1)*53);
//		getStage().addActor(btnUp);
		
		avatar = new Image(ASSET.imgDefaultAvantarMan);
		avatar.setSize(90, 90);
		avatar.setPosition(850, 700);
		getStage().addActor(avatar);
	}
	
	private void setUpMapGame() {
		for (int i = 0; i < broad.getHeight(); i++) {
			for (int j = 0; j < broad.getWidth(); j++) {
				if (broad.getLocalMap(i, j).equals("#")) {
					createWall(j, i);
				}
			}
		}
	}
	
	private void createWall(int x, int y) {
		Image wall = new Image(ASSET.imgWall);
		wall.setPosition(OPTION_GAME.START_X + broad.getMarginX() + x*53, OPTION_GAME.START_Y + broad.getMarginY() + y*53);
		wall.setSize(53, 53);
		getStage().addActor(wall);
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
	}
}
