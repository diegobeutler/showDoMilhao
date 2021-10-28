package br.edu.utfpr;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.assets.AssetManager;


public class ShowDoMilhao extends Game {
    public static ShowDoMilhao game;
    public AssetManager assetManager;

    public static InputMultiplexer multiplexer;

    public static void addInputProcessor (InputProcessor inputProcessor){
        if(multiplexer == null){
            multiplexer = new InputMultiplexer();
            Gdx.input.setInputProcessor(multiplexer);
        }
        multiplexer.addProcessor(inputProcessor);
    }
    public AssetManager getAssetManager(){return assetManager;}
    public void setGameScreen(){this.setScreen(new MainScreen());}

    public void create() {
        assetManager = new AssetManager();
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
