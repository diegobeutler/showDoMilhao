package br.edu.utfpr;

import com.badlogic.gdx.*;
import com.badlogic.gdx.assets.AssetManager;
import java.util.*;

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

    public void create() {
        assetManager = new AssetManager();
        this.setScreen(new LoadingScreen(this));
        game = this;
    }

    public void setGameScrean() {
        this.setScreen(new MainScreen(assetManager));
    }

    public void setGameScrean(Screen asdas) {
        this.setScreen(asdas);
    }


    public void render(){ super.render();}

    @Override
    public void dispose() {
    }

}
