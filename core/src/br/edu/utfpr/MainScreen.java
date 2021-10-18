package br.edu.utfpr;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainScreen implements Screen {
    private AssetManager assetManager;
    SpriteBatch batch;
    Texture img;
    ShowDoMilhao showDoMilhao;

    public MainScreen(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    public void show () {
		batch = new SpriteBatch();
//		sound.play(1f);
		img = new Texture("imagens\\show-do-milhao.jpg");

//		assetManager.setS

    }

    @Override
    public void render (float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        batch.begin();
//        assetManager.get("sons\\abertura.wav", Sound.class);
        batch.draw(img, 0, 0);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose () {
        batch.dispose();
        img.dispose();
    }
}
