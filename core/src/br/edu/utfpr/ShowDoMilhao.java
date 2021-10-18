package br.edu.utfpr;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class ShowDoMilhao extends Game {
	private AssetManager assetManager;
	SpriteBatch batch;
	Texture img;

	public void create () {
		assetManager = new AssetManager();
//		batch = new SpriteBatch();
//		Sound sound = Gdx.audio.newSound(Gdx.files.internal("sons\\vaiComecarOShowDoMilhao.mp3"));
//		sound.play(1f);
//		img = new Texture("imagens\\show-do-milhao.jpg");
//		MainScreen mainScreen = new MainScreen();
		this.setScreen(new LoadingScreen(this));

	}

	public AssetManager getAssetManager() {
		return assetManager;
	}
	public void setGameScrean() {
		this.setScreen(new MainScreen(assetManager));
	}
	@Override
	public void render () {
//		ScreenUtils.clear(0, 0, 0, 1);
//		batch.begin();
////		batch.draw(img, 0, 0);
//		batch.end();
		super.render();
	}
	
	@Override
	public void dispose () {
//		batch.dispose();
//		img.dispose();
	}
}
