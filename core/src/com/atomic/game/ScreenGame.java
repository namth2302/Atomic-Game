package com.atomic.game;
import com.atomic.abstractgame.AbstractScreen;
import com.atomic.abstractgame.BroadGame;
import com.atomic.abstractgame.ButtonGame;
import com.atomic.abstractgame.MenuCreator;
import com.atomic.asset.Asset;
import com.atomic.asset.JsonLevel;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Json;

public class ScreenGame extends AbstractScreen{
	
	private ButtonGame btnRedo;
	private ButtonGame btnUndo;
	private ButtonGame btnReset;
	
	private Image avatar;
	private BroadGame broad;
	
	public ScreenGame(Game _game, String _nameScreen, JsonLevel _jsonInfo) {
		super(_game, _nameScreen);
		broad = new BroadGame(_jsonInfo);
		setUpScreenElement();
	}

	@Override
	public void setUpScreenElement() {
		setBackButton(true);
		setBackground(new TextureRegion(Asset.loadTexture("bg.png")));	
		setUpButtonGame();
		Gdx.app.log(getNameScreen(), "" + broad.getWidthBroad() + " --- " + broad.getHeightBroad());
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
	
	@Override
	public void keyBackPressed() {
		this.dispose();
		getGame().dispose();
	}
}
