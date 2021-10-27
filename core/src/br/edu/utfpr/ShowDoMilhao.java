package br.edu.utfpr;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
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
    public static ShowDoMilhao game;
    public  AssetManager assetManager;

    public static InputMultiplexer multiplexer;

    public static void addInputProcessor (InputProcessor inputProcessor){
        if(multiplexer == null){
            multiplexer = new InputMultiplexer();
            Gdx.input.setInputProcessor(multiplexer);
        }
        multiplexer.addProcessor(inputProcessor);
    }
    public  AssetManager getAssetManager(){return assetManager;}
    public void setGameScreen(){this.setScreen(new MainScreen());}

    public void create() {
        assetManager = new AssetManager();
//		batch = new SpriteBatch();
//		Sound sound = Gdx.audio.newSound(Gdx.files.internal("sons\\vaiComecarOShowDoMilhao.mp3"));
//		sound.play(1f);
//		img = new Texture("imagens\\show-do-milhao.jpg");
//		MainScreen mainScreen = new MainScreen();
        this.setScreen(new LoadingScreen(this));
        game = this;
    }



    public void setGameScrean() {
        this.setScreen(new MainScreen(assetManager));
    }


    public void render(){ super.render();}

    @Override
    public void dispose() {
//		batch.dispose();
//		img.dispose();
    }

}
