package br.edu.utfpr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.ScreenUtils;

public class LoadingScreen implements Screen {
    private Sprite sprite;
    private SpriteBatch batch;
    private float originalWidth;
    private ShowDoMilhao showDoMilhao;



    @Override
    public void show() {
        sprite = new Sprite(new Texture("imagens\\barra_prog.png"));
        sprite.setCenter(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        batch = new SpriteBatch();
        originalWidth = sprite.getWidth();
        // load
        showDoMilhao.getAssetManager().load("imagens/moeda.png", Texture.class);
        showDoMilhao.getAssetManager().load("imagens/sacodemoeda.png", Texture.class);
        showDoMilhao.getAssetManager().load("sons\\abertura.wav", Sound.class);
        showDoMilhao.getAssetManager().load("sons\\boaSorte.mp3", Sound.class);
        showDoMilhao.getAssetManager().load("sons\\certaResposta.mp3", Sound.class);
        showDoMilhao.getAssetManager().load("sons\\estaCertoDisso.mp3", Sound.class);
        showDoMilhao.getAssetManager().load("1milhao.mp3", Sound.class);
        showDoMilhao.getAssetManager().load("sons\\trilhaSuspense.mp3", Sound.class);
        showDoMilhao.getAssetManager().load("sons\\vaiComecarOShowDoMilhao.mp3", Sound.class);
        showDoMilhao.getAssetManager().load("skin/neon-ui.json", Skin.class);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        float progress = showDoMilhao.getAssetManager().getProgress();

        if (showDoMilhao.getAssetManager().update()) {
            showDoMilhao.setGameScrean();
        }
        sprite.setRegion(0,0, (int)(originalWidth*progress), (int)(sprite.getHeight()*progress));
        sprite.setSize((int)(originalWidth*progress), (int)(sprite.getHeight()));
        batch.begin();
        sprite.draw(batch);
        batch.end();



    }

    public LoadingScreen(ShowDoMilhao showDoMilhao) {
        this.showDoMilhao = showDoMilhao;
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
    public void dispose() {

    }
}
