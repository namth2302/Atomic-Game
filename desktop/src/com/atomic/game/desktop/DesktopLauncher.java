package com.atomic.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.atomic.game.AtomicGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Atomic Game";
		config.resizable = false;
		config.width = 870;
		config.height = 520;
		new LwjglApplication(new AtomicGame(), config);
	}
}
