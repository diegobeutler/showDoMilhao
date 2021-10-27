package br.edu.utfpr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
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

public class MainScreen implements Screen {
    private static MainScreen mainScreen;
    private AssetManager assetManager;
    SpriteBatch batch;
    Texture img;
    ShowDoMilhao showDoMilhao;
    TextureAtlas mAtlas;
    public static MainScreen ref;
    private Stage stage;
    private Label outputLabel;
    public Moeda moeda;
    public MainScreen(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    public MainScreen() {

    }

    public void show () {



        batch = new SpriteBatch();
        assetManager.get("sons/abertura.wav", Sound.class).play(1f);
        img = new Texture("imagens\\show-do-milhao.jpg");
        batch = new SpriteBatch();
        img = new Texture("imagens\\show-do-milhao.jpg");
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        int Help_Guides = 12;
        int row_height = Gdx.graphics.getWidth() / 12;
        int col_width = Gdx.graphics.getWidth() / 12;
        ref = this;
        new BulletController();

        moeda = new Moeda();
        Skin mySkin = new Skin(Gdx.files.internal("skin/neon-ui.json"));
        ImageTextButton button4 = new ImageTextButton("Jogar", mySkin);
        button4.setSize(100, 50);
        button4.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("imagens\\jogar.png"))));
        button4.getStyle().imageDown = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("imagens\\jogar.png"))));
        button4.setPosition(Gdx.graphics.getWidth()/2, 50);
        button4.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                outputLabel.setText("Clique para jogar!");
            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                outputLabel.setText("Entrando...");
                return true;
            }
        });
        stage.addActor(button4);
//        580
//        |
//        |
//        |
//        |
//       0 ________________________960

        outputLabel = new Label("JOGAR!", mySkin);
        outputLabel.setSize(Gdx.graphics.getWidth(), row_height);
        outputLabel.setPosition(0, row_height);
        outputLabel.setAlignment(Align.center);
        stage.addActor(outputLabel);
    }

    @Override
    public void render (float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        batch.begin();
        batch.draw(img, 0, 0);

        stage.act();
        stage.draw();
        moeda.draw(batch, delta);
        BulletController.ref.draw(batch, delta);

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
