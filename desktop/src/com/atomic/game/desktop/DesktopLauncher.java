package com.atomic.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.atomic.game.AtomicGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Atomic Game";
		config.resizable = true;
		config.resizable = true;
		config.width = 650;
		config.height = 480;
		new LwjglApplication(new AtomicGame(), config);
	}
}
