package br.edu.utfpr;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class ShowDoMilhao extends Game {
    private AssetManager assetManager;


    public void create() {
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
    public void render() {
//		ScreenUtils.clear(0, 0, 0, 1);
//		batch.begin();
////		batch.draw(img, 0, 0);
//		batch.end();
        super.render();

    }

    @Override
    public void dispose() {
//		batch.dispose();
//		img.dispose();
    }

}
