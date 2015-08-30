package com.GGI.Ringer;

import com.GGI.Ringer.Screens.GameScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Ringer extends Game {
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		setScreen(new GameScreen(this));
	}

	
}
