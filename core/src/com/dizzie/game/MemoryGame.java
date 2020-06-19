package com.dizzie.game;

import Screens.MenuScreen;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MemoryGame extends Game {

	public static final int WIDTH = 1366;
	public static final int HEIGHT = 768;

	private boolean paused;

	@Override
	public void create () {
		playMusicOnLoop();
		setScreen(new MenuScreen(this));
	}

	private void playMusicOnLoop() {
		Music menuMusic = Gdx.audio.newMusic(Gdx.files.internal("music/soundtrack.mp3"));
		menuMusic.setVolume(.2f);
		menuMusic.setLooping(true);
		menuMusic.play();
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {

	}

	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}
}
