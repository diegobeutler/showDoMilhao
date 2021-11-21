package br.edu.utfpr;

import br.edu.utfpr.jogo.Jogo;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import javax.swing.*;

import static br.edu.utfpr.jogo.Jogo.getJogo;

public class GanhouScreen implements Screen {
    private AssetManager assetManager;
    private ShowDoMilhao showDoMilhao;

    private SpriteBatch batch;
    private Texture fundo, showlogo, goldBar;
    private Stage stage;
    private ImageIcon imageIconGoldBar = new ImageIcon(System.getProperty("user.dir") + "\\core\\assets\\imagens\\goldbar.png");

    private Jogo jogo;
    private TextButton btnReiniciar;
    private TextButton btnSair;
    private BitmapFont font1 = new BitmapFont();
    private Skin skinBotoesRespostas;

    private float heightShape = 160;
    private float font1Y = 280;

    public GanhouScreen(AssetManager assetManager, ShowDoMilhao showDoMilhao) {
        this.assetManager = assetManager;
        this.showDoMilhao = showDoMilhao;
    }


    public void show() {
        batch = new SpriteBatch();
        stage = new Stage(new ScreenViewport());
        ShowDoMilhao.addInputProcessor(stage);
        fundo = assetManager.get("imagens/bg.jpg", Texture.class);

        //botoes respostas
        skinBotoesRespostas = assetManager.get("skin/neon-ui.json", Skin.class);
        jogo = getJogo();
        showlogo = assetManager.get("imagens/showlogo.png", Texture.class);
        goldBar = assetManager.get("imagens/goldbar_ori.png", Texture.class);

        btnReiniciar = new TextButton("Reiniciar", skinBotoesRespostas);
        this.btnReiniciar.setSize(120, 60);
        this.btnReiniciar.setPosition(400, 60, Align.center);
        this.btnReiniciar.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                jogo.reiniciar();
                showDoMilhao.setGameScreen(new JogoScreen(assetManager, showDoMilhao));
                return true;
            }
        });

        btnSair = new TextButton("Sair", skinBotoesRespostas);
        this.btnSair.setSize(120, 60);
        this.btnSair.setPosition(535, 60, Align.center);
        this.btnSair.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                tratarSair();
                return true;
            }
        });
    }

    @Override
    public void render(float delta) {
        stage.act();

        ScreenUtils.clear(0, 0, 0, 1);
        batch.begin();

        batch.draw(fundo, 0, 0);
        batch.draw(showlogo, 253, Gdx.graphics.getHeight() - showlogo.getHeight() - 20);
        batch.draw(goldBar, 740, 50);

        font1.draw(batch, "Parabéns você ganhou!!!\nPontuação: " + jogo.getPontuacao() + "\n"+ jogo.getRodada().getLabel() + " / 16", 283, font1Y);
        font1.getData().setScale(1.8f, 1.8f);
        font1.setColor(Color.BLACK);

        stage.addActor(this.btnReiniciar);
        stage.addActor(this.btnSair);

        stage.draw();

        batch.end();

        ShapeRenderer shape = new ShapeRenderer();
        shape.begin(ShapeRenderer.ShapeType.Line);
        shape.setColor(Color.WHITE);
        shape.rect(Gdx.graphics.getWidth() / 2 - 217, Gdx.graphics.getHeight() - heightShape - 230, Gdx.graphics.getWidth() / 2.2f, heightShape);
        shape.end();
    }

    private void tratarSair() {
        assetManager.get("sons/estaCertoDisso.mp3", Sound.class).play(1f);
        int valor = JOptionPane.showConfirmDialog(null, "Está certo disso?", "Sair", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, imageIconGoldBar);
        if (valor == JOptionPane.YES_OPTION) {
            Gdx.app.exit();
        }
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
        dispose();
    }

    @Override
    public void dispose() {
        batch.dispose();
        stage.dispose();
        btnReiniciar.clear();
        btnReiniciar = null;
        btnSair.clear();
        btnSair = null;
        font1.dispose();
        imageIconGoldBar = null;
    }

}