package com.atomic.game;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import com.atomic.abstractgame.AbstractScreen;
import com.atomic.abstractgame.ActorGame;
import com.atomic.abstractgame.BroadGame;
import com.atomic.abstractgame.ButtonGame;
import com.atomic.abstractgame.MenuCreator;
import com.atomic.asset.Asset;
import com.atomic.asset.JsonLevel;
import com.atomic.option.OptionGame;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

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
		setUpMapGame();
	}
	
	private void setUpMapGame() {
		for (int i = 0; i < broad.getHeightBroad(); i++) {
			for (int j = 0; j < broad.getWidthBroad(); j++) {
				if (broad.getLocal(i, j).equals(OptionGame.WALL)) {
					drawWall(broad.getWidthBroad() - i, j);
				} else {
					for (int j2 = 0; j2 < OptionGame.ITEM_KIND.length; j2++) {
						if (broad.getLocal(i, j).equals(OptionGame.ITEM_KIND[j2][0])) {
							ActorGame actor = new ActorGame(new TextureRegion(Asset.loadTexture("katomic/"+OptionGame.ITEM_KIND[j2][1]+".png")), i, j, broad.getStartDrawX(), broad.getStartDrawY(), broad.getWidthBroad() - i);
							getStage().addActor(actor);
						}
					}
				}
			}
		}
	}
	
	private void drawWall(int x, int y) {
		Image imgWall = new Image(Asset.imgWall);
		imgWall.setPosition((broad.getStartDrawX() + (y*53)), broad.getStartDrawY() + x*53);
		getStage().addActor(imgWall);
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
