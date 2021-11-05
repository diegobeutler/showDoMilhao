package br.edu.utfpr;

import br.edu.utfpr.jogo.Jogo;
import br.edu.utfpr.jogo.Rodada;
import br.edu.utfpr.json.Dados;
import br.edu.utfpr.json.Questao;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.ScreenUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static br.edu.utfpr.jogo.Jogo.getJogo;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.awt.*;

import com.badlogic.gdx.graphics.Color;
public class JogoScreen implements Screen {
    private ShowDoMilhao showDoMilhao;

    SpriteBatch batch;
    Texture img;

    private Stage stage;
    private Label outputLabel;
    public Moeda moeda;
    private OrthographicCamera camera;
    private Viewport viewport;

    public static JogoScreen ref;
    public JogoScreen() {

    }



    public void show () {
        batch = new SpriteBatch();
        stage = new Stage(new ScreenViewport());
        ShowDoMilhao.addInputProcessor(stage);
        img = new Texture("imagens\\bg.jpg");
        try {
            String url = System.getProperty("user.dir") +"\\core\\assets\\dados\\perguntas.json";
            String json = String.join(" ",
                    Files.readAllLines(
                            Paths.get(url),
                            StandardCharsets.UTF_8)
            );
            Dados dados = new Gson().fromJson(json, Dados.class);
            Jogo jogo = getJogo();
            Questao questao = dados.getQuestao(jogo.getDificuldade());
            System.out.println(questao.getKey());
        } catch (Exception e) {
            e.printStackTrace();
        }

        ref = this;
        new BulletController();
        moeda = new Moeda();
        moeda.setX((float) (Gdx.graphics.getWidth()/1.35));
        camera = new OrthographicCamera(222, 20 * (Gdx.graphics.getWidth() / Gdx.graphics.getHeight()));

        camera.position.set(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, 0);
        viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), camera);

    }

    @Override
    public void render (float delta) {
        stage.act();

        ScreenUtils.clear(0, 0, 0, 1);
        batch.begin();
        //camera
        batch.setProjectionMatrix(camera.combined);

        batch.draw(img, 0, 0);
        moeda.draw(batch, delta);
        BulletController.ref.draw(batch, delta);

        stage.draw();

        //forma


        batch.end();

        ShapeRenderer shape = new ShapeRenderer();
        shape.setProjectionMatrix(camera.combined);
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(Color.WHITE);
        shape.rect(15, (Gdx.graphics.getHeight()/2)-15, Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
        shape.end();

//        ShapeRenderer shape2 = new ShapeRenderer();
//        shape2.setProjectionMatrix(camera.combined);
//        shape2.begin(ShapeRenderer.ShapeType.Filled);
//        shape2.setColor(Color.GRAY);
//        shape2.rect(2, 2, (Gdx.graphics.getWidth()/2)+30, Gdx.graphics.getHeight()/2);
//        shape2.end();

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
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
