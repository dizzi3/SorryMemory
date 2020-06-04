package com.dizzie.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.dizzie.game.MemoryGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = "Sorry Memory";
		config.width = MemoryGame.WIDTH;
		config.height = MemoryGame.HEIGHT;
		config.resizable = false;

		new LwjglApplication(new MemoryGame(), config);
	}
}
