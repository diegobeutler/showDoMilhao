package br.edu.utfpr;

import br.edu.utfpr.jogo.Jogo;
import br.edu.utfpr.json.Dados;
import br.edu.utfpr.json.Questao;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.google.gson.Gson;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static br.edu.utfpr.jogo.Jogo.getJogo;
public class JogoScreen implements Screen {
    private ShowDoMilhao showDoMilhao;

    SpriteBatch batch;
    Texture img;

    private Stage stage;
    private Label outputLabel;
    public Moeda moeda;
    private OrthographicCamera camera;
    private Viewport viewport;
    private boolean emPergunta;
    Questao  questao;
    Dados dados;
    Jogo jogo;
    private BitmapFont font1 = new BitmapFont();
    private BitmapFont font2 = new BitmapFont();
    private BitmapFont font3 = new BitmapFont();
    private BitmapFont font4 = new BitmapFont();
    private BitmapFont font5 = new BitmapFont();


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
            dados = new Gson().fromJson(json, Dados.class);
            jogo = getJogo();
            questao = dados.getQuestao(jogo.getDificuldade());
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
        questao = dados.getQuestao(jogo.getDificuldade());

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

//        ShapeRenderer shape = new ShapeRenderer();
//        shape.setProjectionMatrix(camera.combined);
//        shape.begin(ShapeRenderer.ShapeType.Filled);
//        shape.setColor(Color.WHITE);
//        shape.rect(15, (Gdx.graphics.getHeight()/2)-15, Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
//        shape.end();

        font1.draw(batch, questao.getPergunta(), 50, 520);
        font1.getData().setScale((float) 2, (float) 2);
        font1.setColor(Color.BLACK);

        font2.draw(batch, questao.getRespostas().get(0).getResposta(), 50, 450);
        font2.getData().setScale((float) 2, (float) 2);
        font2.setColor(Color.GRAY);

        font3.draw(batch, questao.getRespostas().get(1).getResposta(), 50, 400);
        font3.getData().setScale((float) 2, (float) 2);
        font3.setColor(Color.GRAY);

        font4.draw(batch, questao.getRespostas().get(2).getResposta(), 50, 350);
        font4.getData().setScale((float) 2, (float) 2);
        font4.setColor(Color.GRAY);

        font5.draw(batch, questao.getRespostas().get(3).getResposta(), 50, 300);
        font5.getData().setScale((float) 2, (float) 2);
        font5.setColor(Color.GRAY);
        batch.end();




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
