package com.atomic.game;

import java.util.ArrayList;

import com.atomic.abstractgame.AbstractScreen;
import com.atomic.abstractgame.ActorGame;
import com.atomic.abstractgame.BroadGame;
import com.atomic.abstractgame.ButtonGame;
import com.atomic.abstractgame.MenuCreator;
import com.atomic.asset.Asset;
import com.atomic.asset.JsonLevel;
import com.atomic.option.OptionGame;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.RemoveAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;

public class ScreenGame extends AbstractScreen {

	private ButtonGame btnRedo;
	private ButtonGame btnUndo;
	private ButtonGame btnReset;
	private ButtonGame btnLeft;
	private ButtonGame btnRight;
	private ButtonGame btnDown;
	private ButtonGame btnUp;

	private String idCurrent;
	private int pointCurrentX;
	private int pointCurrentY;

	int idUndo = -1;
	int idRedo = -1;

	private Image avatar;
	private BroadGame broad;

	private ArrayList<ActorGame> lstActor = new ArrayList<ActorGame>();
	private ArrayList<Btn> lstundo = new ArrayList<Btn>();
	private ArrayList<Btn> lstredo = new ArrayList<Btn>();

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
		setUpLstActor();
		setUpMapGame();
		setUpbtnMoveGame();
	}

	private void setUpbtnMoveGame() {
		btnLeft = MenuCreator.createCustomGameButton(Asset.btnLeft,
				Asset.btnLeft);
		btnRight = MenuCreator.createCustomGameButton(Asset.btnRight,
				Asset.btnRight);
		btnDown = MenuCreator.createCustomGameButton(Asset.btnDown,
				Asset.btnDown);
		btnUp = MenuCreator.createCustomGameButton(Asset.btnUp, Asset.btnUp);
		idCurrent = lstActor.get(0).getId();
		setPointCurrent();
		setPosBtnMove();
		btnListener();
		getStage().addActor(btnLeft);
		getStage().addActor(btnRight);
		getStage().addActor(btnDown);
		getStage().addActor(btnUp);
		showBtnMove();
	}

	private void setPointCurrent() {
		for (int i = 0; i < lstActor.size(); i++) {
			if (lstActor.get(i).getId().equals(idCurrent)) {
				pointCurrentX = lstActor.get(i).getPosX();
				pointCurrentY = lstActor.get(i).getPoxY();
			}
		}
	}

	private void btnListener() {
		btnLeft.addListener(new ActorGestureListener() {
			@Override
			public void touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				super.touchDown(event, x, y, pointer, button);
				Gdx.app.log("BUTTON ", "LEFT");
				setMoveLeft();
				lstredo.clear();
				idRedo = -1;
			}
		});
		btnRight.addListener(new ActorGestureListener() {
			@Override
			public void touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				super.touchDown(event, x, y, pointer, button);
				Gdx.app.log("BUTTON ", "RIGHT");
				setMoveRight();
				lstredo.clear();
				idRedo = -1;
			}
		});
		btnDown.addListener(new ActorGestureListener() {
			@Override
			public void touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				super.touchDown(event, x, y, pointer, button);
				Gdx.app.log("BUTTON ", "DOWN");
				setMoveDown();
				lstredo.clear();
				idRedo = -1;
			}
		});
		btnUp.addListener(new ActorGestureListener() {
			@Override
			public void touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				super.touchDown(event, x, y, pointer, button);
				Gdx.app.log("BUTTON ", "UP");
				setMoveUp();
				lstredo.clear();
				idRedo = -1;
			}
		});
		btnRedo.addListener(new ActorGestureListener() {
			@Override
			public void touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				super.touchDown(event, x, y, pointer, button);
				Gdx.app.log("BUTTON ", "REDO");
				if (idRedo > -1) {
					if (idUndo > -2) {
						idUndo += 1;
						Btn btn3 = new Btn(idCurrent, pointCurrentX,
								pointCurrentY);
						lstundo.add(btn3);
						btnRedo();
						lstredo.remove(idRedo);
						idRedo -= 1;
						Gdx.app.log("IdRedo", "" + idRedo);
						Gdx.app.log("IdUndo", "" + idUndo);
					}
				}
			}
		});
		btnUndo.addListener(new ActorGestureListener() {
			@Override
			public void touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				super.touchDown(event, x, y, pointer, button);
				Gdx.app.log("BUTTON ", "UNDO");
				if (idUndo > -1) {
					if (idRedo > -2) {

						Btn btn4 = new Btn(idCurrent, pointCurrentX,
								pointCurrentY);
						lstredo.add(btn4);
						idRedo += 1;
						Gdx.app.log("IdRedo", "" + idRedo);
						btnUndo();
						lstundo.remove(idUndo);
						idUndo -= 1;
						Gdx.app.log("IdUndo", "" + idUndo);

					}
				}
			}
		});
		btnReset.addListener(new ActorGestureListener() {
			@Override
			public void touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				super.touchDown(event, x, y, pointer, button);
				Gdx.app.log("BUTTON ", "RESET");
				broad.reset();
				for (int i = 0; i < broad.getHeightBroad(); i++) {
					for (int j = 0; j < broad.getWidthBroad(); j++) {
						for (int j2 = 0; j2 < lstActor.size(); j2++) {
							if (broad.getLocal(i, j).equals(
									lstActor.get(j2).getId())) {
								lstActor.get(j2).setPosActor(i, j);
								lstActor.get(j2).setStartBroad(
										broad.getStartDrawX(),
										broad.getStartDrawY());
								lstActor.get(j2).setPosScreen(
										broad.getWidthBroad() - i);
								lstActor.get(j2).setUpActor();
							}
						}
					}
				}
				idCurrent = lstActor.get(0).getId();
				lstundo.clear();
				idUndo = -1;
				lstredo.clear();
				idRedo = -1;
				setPointCurrent();
				setPosBtnMove();
				showBtnMove();

			}
		});
	}

	// private void listredo() {
	// Btn btn2 = new Btn();
	// btn2 = lstundo.get(idUndo);
	// idRedo += 1;
	// lstredo.add(btn2);
	// Gdx.app.log("IdRedo", "" + idRedo);
	// }

	private void btnRedo() {
		Btn redo = new Btn();
		redo = lstredo.get(idRedo);
		int tempX = redo.getPosX();
		int tempY = redo.getPosY();
		for (int i = 0; i < lstActor.size(); i++) {
			if (lstActor.get(i).getId() == redo.getID()) {
				int x = lstActor.get(i).getPosX();
				int y = lstActor.get(i).getPoxY();
				lstActor.get(i).setPosActor(tempX, tempY);
				lstActor.get(i).setPosScreen(broad.getWidthBroad() - tempX);
				lstActor.get(i).setUpActor();
				broad.getMapBroad()[x][y] = ".";
				broad.getMapBroad()[tempX][tempY] = redo.getID();
			}
		}
		setID(redo.getID());
		setPointXY(tempX, tempY);
		setPosBtnMove();
		showBtnMove();
	}

	private void listundo() {
		Btn btn = new Btn(idCurrent, pointCurrentX, pointCurrentY);
		idUndo += 1;
		lstundo.add(btn);
		Gdx.app.log("IdUndo", "" + idUndo);
	}

	private void btnUndo() {
		Btn undo = new Btn();
		undo = lstundo.get(idUndo);

		int tempX = undo.getPosX();
		int tempY = undo.getPosY();
		for (int i = 0; i < lstActor.size(); i++) {
			if (lstActor.get(i).getId() == undo.getID()) {
				int x = lstActor.get(i).getPosX();
				int y = lstActor.get(i).getPoxY();
				lstActor.get(i).setPosActor(tempX, tempY);
				lstActor.get(i).setPosScreen(broad.getWidthBroad() - tempX);
				lstActor.get(i).setUpActor();

				broad.getMapBroad()[x][y] = ".";
				broad.getMapBroad()[tempX][tempY] = undo.getID();
			}
		}
		setID(undo.getID());
		setPointXY(tempX, tempY);
		setPosBtnMove();
		showBtnMove();

	}

	private void setMoveRight() {
		setAllUnvisiableBtn();
		int tempX = pointCurrentX;
		int tempY = pointCurrentY;
		listundo();
		while (broad.getMapBroad()[pointCurrentX][pointCurrentY + 1]
				.equals(".")) {
			pointCurrentY += 1;
		}
		for (int i = 0; i < lstActor.size(); i++) {
			if (lstActor.get(i).getId() == idCurrent) {
				lstActor.get(i).setPosActor(pointCurrentX, pointCurrentY);
				lstActor.get(i).setPosScreen(
						broad.getWidthBroad() - pointCurrentX);
				lstActor.get(i).setUpActor();
				broad.getMapBroad()[tempX][tempY] = ".";
				broad.getMapBroad()[pointCurrentX][pointCurrentY] = lstActor
						.get(i).getId();

			}
		}
		setPosBtnMove();
		showBtnMove();
	}

	private void setMoveLeft() {
		setAllUnvisiableBtn();
		int tempX = pointCurrentX;
		int tempY = pointCurrentY;
		listundo();
		while (broad.getMapBroad()[pointCurrentX][pointCurrentY - 1]
				.equals(".")) {
			pointCurrentY -= 1;
		}
		for (int i = 0; i < lstActor.size(); i++) {
			if (lstActor.get(i).getId() == idCurrent) {
				lstActor.get(i).setPosActor(pointCurrentX, pointCurrentY);
				lstActor.get(i).setPosScreen(
						broad.getWidthBroad() - pointCurrentX);
				lstActor.get(i).setUpActor();
				broad.getMapBroad()[tempX][tempY] = ".";
				broad.getMapBroad()[pointCurrentX][pointCurrentY] = lstActor
						.get(i).getId();
			}
		}
		setPosBtnMove();
		showBtnMove();
	}

	private void setMoveDown() {
		setAllUnvisiableBtn();
		int tempX = pointCurrentX;
		int tempY = pointCurrentY;
		listundo();
		while (broad.getMapBroad()[pointCurrentX + 1][pointCurrentY]
				.equals(".")) {
			pointCurrentX += 1;
		}
		for (int i = 0; i < lstActor.size(); i++) {
			if (lstActor.get(i).getId() == idCurrent) {
				lstActor.get(i).setPosActor(pointCurrentX, pointCurrentY);
				lstActor.get(i).setPosScreen(
						broad.getWidthBroad() - pointCurrentX);
				lstActor.get(i).setUpActor();
				broad.getMapBroad()[tempX][tempY] = ".";
				broad.getMapBroad()[pointCurrentX][pointCurrentY] = lstActor
						.get(i).getId();
			}
		}
		setPosBtnMove();
		showBtnMove();
	}

	private void setMoveUp() {
		setAllUnvisiableBtn();
		int tempX = pointCurrentX;
		int tempY = pointCurrentY;
		listundo();
		while (broad.getMapBroad()[pointCurrentX - 1][pointCurrentY]
				.equals(".")) {
			pointCurrentX -= 1;
		}
		for (int i = 0; i < lstActor.size(); i++) {
			if (lstActor.get(i).getId() == idCurrent) {
				lstActor.get(i).setPosActor(pointCurrentX, pointCurrentY);
				lstActor.get(i).setPosScreen(
						broad.getWidthBroad() - pointCurrentX);
				lstActor.get(i).setUpActor();
				broad.getMapBroad()[tempX][tempY] = ".";
				broad.getMapBroad()[pointCurrentX][pointCurrentY] = lstActor
						.get(i).getId();
				Gdx.app.log("SHOW ", pointCurrentX + " - "
						+ (pointCurrentY - 1));
			}
		}
		setPosBtnMove();
		showBtnMove();
	}

	public void setAllUnvisiableBtn() {
		btnDown.setVisible(false);
		btnUp.setVisible(false);
		btnLeft.setVisible(false);
		btnRight.setVisible(false);
	}

	public void setPosBtnMove() {
		btnLeft.setPosition(broad.getStartDrawX() + (pointCurrentY - 1) * 53,
				broad.getStartDrawY() + (broad.getWidthBroad() - pointCurrentX)
						* 53);
		btnRight.setPosition(broad.getStartDrawX() + (pointCurrentY + 1) * 53,
				broad.getStartDrawY() + (broad.getWidthBroad() - pointCurrentX)
						* 53);
		btnDown.setPosition(broad.getStartDrawX() + pointCurrentY * 53,
				broad.getStartDrawY()
						+ (broad.getWidthBroad() - pointCurrentX - 1) * 53);
		btnUp.setPosition(broad.getStartDrawX() + pointCurrentY * 53,
				broad.getStartDrawY()
						+ (broad.getWidthBroad() - pointCurrentX + 1) * 53);
	}

	public void showBtnMove() {
		if (broad.getMapBroad()[pointCurrentX - 1][pointCurrentY].equals(".")) {
			btnUp.setIsActive(true);
			btnUp.setVisible(true);
		} else {
			btnUp.setIsActive(false);
			btnUp.setVisible(false);
		}
		if (broad.getMapBroad()[pointCurrentX + 1][pointCurrentY].equals(".")) {
			btnDown.setIsActive(true);
			btnDown.setVisible(true);
		} else {
			btnDown.setIsActive(false);
			btnDown.setVisible(false);
		}
		if (broad.getMapBroad()[pointCurrentX][pointCurrentY - 1].equals(".")) {
			btnLeft.setIsActive(true);
			btnLeft.setVisible(true);
		} else {
			btnLeft.setIsActive(false);
			btnLeft.setVisible(false);
		}
		if (broad.getMapBroad()[pointCurrentX][pointCurrentY + 1].equals(".")) {
			btnRight.setIsActive(true);
			btnRight.setVisible(true);
		} else {
			btnRight.setIsActive(false);
			btnRight.setVisible(false);
		}
	}

	private void setUpLstActor() {
		for (int i = 0; i < broad.getMapInfo().getListAtoms().size(); i++) {
			ActorGame actorG = new ActorGame(this);
			actorG.setId(broad.getMapInfo().getListAtoms().get(i).getID());
			actorG.setType(broad.getMapInfo().getListAtoms().get(i).getType());
			actorG.setLstLink(broad.getMapInfo().getListAtoms().get(i)
					.getTypeCon());
			actorG.setUpAuto();
			lstActor.add(actorG);
		}
	}

	private void setUpMapGame() {
		for (int i = 0; i < broad.getHeightBroad(); i++) {
			for (int j = 0; j < broad.getWidthBroad(); j++) {
				if (broad.getLocal(i, j).equals(OptionGame.WALL)) {
					drawWall(broad.getWidthBroad() - i, j);
				} else {
					for (int j2 = 0; j2 < lstActor.size(); j2++) {
						if (broad.getLocal(i, j).equals(
								lstActor.get(j2).getId())) {
							lstActor.get(j2).setPosActor(i, j);
							lstActor.get(j2).setStartBroad(
									broad.getStartDrawX(),
									broad.getStartDrawY());
							lstActor.get(j2).setPosScreen(
									broad.getWidthBroad() - i);
							lstActor.get(j2).setUpActor();
							lstActor.get(j2).addInputListeners();
							getStage().addActor(lstActor.get(j2));
						}
					}
				}
			}
		}
	}

	public void setID(String _id) {
		idCurrent = _id;
	}

	public void setPointXY(int x, int y) {
		pointCurrentX = x;
		pointCurrentY = y;
	}

	public String getID() {
		return idCurrent;
	}

	private void drawWall(int x, int y) {
		Image imgWall = new Image(Asset.imgWall);
		imgWall.setPosition((broad.getStartDrawX() + (y * 53)),
				broad.getStartDrawY() + x * 53);
		getStage().addActor(imgWall);
	}

	private void setUpButtonGame() {
		btnRedo = MenuCreator.createCustomGameButton(Asset.btnRecno,
				Asset.btnRecno);
		btnRedo.setSize(70, 70);
		btnRedo.setPosition(1030, 200);
		btnRedo.setIsActive(true);
		getStage().addActor(btnRedo);

		btnUndo = MenuCreator.createCustomGameButton(Asset.btnUndo,
				Asset.btnUndo);
		btnUndo.setSize(70, 70);
		btnUndo.setPosition(900, 200);
		btnUndo.setIsActive(true);
		getStage().addActor(btnUndo);

		btnReset = MenuCreator.createCustomGameButton(Asset.btnReset,
				Asset.btnReset);
		btnReset.setSize(80, 80);
		btnReset.setPosition(1150, 190);
		btnReset.setIsActive(true);
		getStage().addActor(btnReset);

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
