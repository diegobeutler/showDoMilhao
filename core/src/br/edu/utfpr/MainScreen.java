package br.edu.utfpr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import static br.edu.utfpr.ShowDoMilhao.game;
import static br.edu.utfpr.ShowDoMilhao.multiplexer;

public class MainScreen implements Screen {

    public AssetManager assetManager;
    SpriteBatch batch;
    Texture img;

    public static MainScreen ref;
    private Stage stage;
    private Label outputLabel;
    public Moeda moeda;

    public MainScreen(AssetManager assetManager) {
        this.assetManager = assetManager;
    }


    public void show () {
        batch = new SpriteBatch();

        assetManager.get("sons/abertura.wav", Sound.class).play(1f);;
        img = new Texture("imagens\\show-do-milhao.jpg");

        stage = new Stage(new ScreenViewport());
        ShowDoMilhao.addInputProcessor(stage);

        int row_height = Gdx.graphics.getWidth() / 12;

        Skin mySkin = assetManager.get("skin/neon-ui.json", Skin.class);
        //skin ->
        //Um skin armazena recursos para os widgets da IU usarem (regiões de textura, ninepatches, fontes, cores, etc).
        //Os recursos são nomeados e podem ser pesquisados  por nome e tipo. Os recursos podem ser descritos em JSON.
        //O skin fornece conversões úteis, como permitir o acesso a regiões no atlas como nove manchas, sprites, drawables, etc

        outputLabel = new Label("Clique para comecar o jogo!", mySkin);
        outputLabel.setSize(Gdx.graphics.getWidth(), row_height);
        outputLabel.setPosition(0, row_height);
        outputLabel.setAlignment(Align.center);
        stage.addActor(outputLabel);

        ImageTextButton botaoJogar = new ImageTextButton("Jogar", mySkin);
        botaoJogar.setSize(100, 50);
        botaoJogar.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("imagens\\jogar.png"))));
        //textureRegionDrawable ->  A região da textura deve ser definida antes do uso.
        botaoJogar.setPosition((float) (Gdx.graphics.getWidth()/2), row_height, Align.center);
        final Sound sound =  assetManager.get("sons/abertura.wav", Sound.class);
        botaoJogar.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                outputLabel.setText("Clique para jogar!");
            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.setGameScrean(new JogoScreen());
                sound.stop();
                assetManager.get("sons/vaiComecarOShowDoMilhao.mp3", Sound.class).play(1f);
                return true;
            }
        });
        stage.addActor(botaoJogar);

        ref = this;
        new BulletController();
        moeda = new Moeda();
    }

    @Override
    public void render (float delta) {
        stage.act();
        ScreenUtils.clear(0, 0, 0, 1);
        batch.begin();
        batch.draw(img, 0, 0);
        moeda.draw(batch, delta);
        BulletController.ref.draw(batch, delta);
        stage.draw();
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
