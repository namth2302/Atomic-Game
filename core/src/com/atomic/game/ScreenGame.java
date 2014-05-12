package com.atomic.game;
import com.atomic.abstractgame.AbstractScreen;
import com.atomic.abstractgame.BroadGame;
import com.atomic.abstractgame.ButtonGame;
import com.atomic.abstractgame.MenuCreator;
import com.atomic.asset.Asset;
import com.atomic.option.OptionGame;
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

		setBackground(new TextureRegion(Asset.loadTexture("imgBG.jpg")));
		
		
		initial();
	}
	
	private void initial() {
//		lazy = new Lazy(ASSET.imgAtomBr, 1, 1, 53, 53);
//		lazy.setUpConnect("c");
//		getStage().addActor(lazy);
		setUpButtonGame();
	}
	
	private void setUpButtonGame() {
		btnRedo = MenuCreator.createCustomGameButton(Asset.btnRecno, Asset.btnRecno);
		btnRedo.setSize(70, 70);
		btnRedo.setPosition(1030, 200);
		getStage().addActor(btnRedo);
		
		btnUndo = MenuCreator.createCustomGameButton(Asset.btnUndo, Asset.btnUndo);
		btnUndo.setSize(70, 70);
		btnUndo.setPosition(900, 200);
		getStage().addActor(btnUndo);
		
		btnReset = MenuCreator.createCustomGameButton(Asset.btnReset, Asset.btnReset);
		btnReset.setSize(80, 80);
		btnReset.setPosition(1150, 190);
		getStage().addActor(btnReset);
		
//		btnUp = MenuCreator.createCustomGameButton(ASSET.imgBtnUp, ASSET.imgBtnUp);
//		btnUp.setSize(53, 53);
//		btnUp.setPosition(lazy.getLazyPointX()*53, (lazy.getLazyPointY()+1)*53);
//		getStage().addActor(btnUp);
		
		avatar = new Image(Asset.imgDefaultAvantarMan);
		avatar.setSize(90, 90);
		avatar.setPosition(850, 700);
		getStage().addActor(avatar);
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
	}
}
