package com.atomic.game;

import com.atomic.asset.Asset;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;

public class AtomicGame extends Game implements ApplicationListener {

	@Override
	public void create () {
		Asset.loadAllFile();
//		setScreen(new ScreenGame(this, "MAIN GAME SCREEN"));
	}

	@Override
	public void resume() {
		super.resume();
		Asset.loadAllFile();
	}
}
