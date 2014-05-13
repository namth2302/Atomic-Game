package com.atomic.game;

import com.atomic.asset.Asset;
import com.atomic.asset.JsonLevel;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;

public class AtomicGame extends Game implements ApplicationListener {
	
	public Json jsonInfoMap;
	
	@Override
	public void create () {
		jsonInfoMap = new Json();
		JsonLevel jsonInfo = jsonInfoMap.fromJson(JsonLevel.class, Gdx.files.internal("item/level.json"));
		Asset.loadAllFile();
		setScreen(new ScreenGame(this, "MAIN GAME SCREEN", jsonInfo));
	}

	@Override
	public void resume() {
		super.resume();
		Asset.loadAllFile();
	}
}
