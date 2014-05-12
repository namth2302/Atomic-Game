package com.atomic.game;

import com.atomic.option.ASSET;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;

public class AtomicGame extends Game implements ApplicationListener {

	@Override
	public void create () {
		ASSET.loadAllFile();
		setScreen(new ScreenGame(this, "MAIN GAME SCREEN"));
	}

	@Override
	public void resume() {
		super.resume();
//		ASSET.loadAllFile();
	}
}
