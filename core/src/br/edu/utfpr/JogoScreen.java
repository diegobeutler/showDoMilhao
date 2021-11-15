package br.edu.utfpr;

import br.edu.utfpr.jogo.Jogo;
import br.edu.utfpr.json.Dados;
import br.edu.utfpr.json.Questao;
import br.edu.utfpr.json.Resposta;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.google.gson.Gson;

import javax.swing.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static br.edu.utfpr.jogo.Jogo.getJogo;

public class JogoScreen implements Screen {
    private ShowDoMilhao showDoMilhao;
    private AssetManager assetManager;
    private SpriteBatch batch;
    private Texture fundo;
    private ShapeRenderer shape = new ShapeRenderer();

    private Stage stage;
    public SacoMoeda sacoMoeda;
    private Moeda moeda;
    private Questao questao;
    private Dados dados;
    private Jogo jogo;
    private BitmapFont font1 = new BitmapFont();
    // botoes respostas
    private Skin skinBotoesRespostas;
    private TextButton resposta1;
    private TextButton resposta2;
    private TextButton resposta3;
    private TextButton resposta4;
    private ImageTextButton botaoJogar;
    private TextureRegionDrawable textureRegionDrawable, textureRegionDrawable2, textureRegionDrawable3;
    private TextureRegion textureRegion, textureRegion2, textureRegion3 ;
    private BitmapFont fontPontuacao = new BitmapFont();
    // ajudas
    private ImageTextButton btnPular;
    private TextButton btnEliminar2;
    private ImageTextButton btnParar;
    /// tratar string
    private String retorno = "";
    private boolean flg = false;
    private boolean flg2 = false;
    private int k = 0;
    private int indice = 0;
    private char[] arrayTexto;
    private int tabulacao = 40;
    private float heightShape = 100;
    private float font1Y = 500;

    public static JogoScreen ref;

    public JogoScreen(AssetManager assetManager, ShowDoMilhao showDoMilhao) {
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
        try {
            String url = System.getProperty("user.dir") + "\\core\\assets\\dados\\perguntas.json";
            String json = String.join(" ",
                    Files.readAllLines(
                            Paths.get(url),
                            StandardCharsets.UTF_8)
            );
            dados = new Gson().fromJson(json, Dados.class);
            jogo = getJogo();
            questao = sortearNovaQuestao();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ref = this;
        new MoedaController();
        sacoMoeda = new SacoMoeda();
        moeda = new Moeda();
        sacoMoeda.setX((float) (Gdx.graphics.getWidth() / 1.35));

        resposta1 = new TextButton("", skinBotoesRespostas);
        resposta1.getLabel().setAlignment(Align.left);
        this.resposta1.setSize(Gdx.graphics.getWidth() / 2, 60);
        this.resposta1.setPosition(15, font1Y - heightShape - 20, Align.left);
        this.resposta1.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                confirmaResposta(questao.getRespostas().get(0));
                return true;
            }
        });

        resposta2 = new TextButton(" 2 - " + questao.getRespostas().get(1).getResposta(), skinBotoesRespostas);
        resposta2.getLabel().setAlignment(Align.left);
        this.resposta2.setSize(Gdx.graphics.getWidth() / 2, 60);
        this.resposta2.setPosition(15, font1Y - heightShape - 80, Align.left);
        this.resposta2.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                confirmaResposta(questao.getRespostas().get(1));
                return true;
            }
        });

        resposta3 = new TextButton(" 3 - " + questao.getRespostas().get(2).getResposta(), skinBotoesRespostas);
        resposta3.getLabel().setAlignment(Align.left);
        this.resposta3.setSize(Gdx.graphics.getWidth() / 2, 60);
        this.resposta3.setPosition(15, font1Y - heightShape - 140, Align.left);
        this.resposta3.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                confirmaResposta(questao.getRespostas().get(2));
                return true;
            }
        });

        resposta4 = new TextButton(" 4 - " + questao.getRespostas().get(3).getResposta(), skinBotoesRespostas);
        resposta4.getLabel().setAlignment(Align.left);
        this.resposta4.setSize(Gdx.graphics.getWidth() / 2, 60);
        this.resposta4.setPosition(15, font1Y - heightShape - 200, Align.left);
        this.resposta4.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                confirmaResposta(questao.getRespostas().get(3));
                return true;
            }
        });

        //botão parar
        btnParar = new ImageTextButton("Parar", skinBotoesRespostas);
        textureRegion = new TextureRegion(assetManager.get("imagens/parar.jpg", Texture.class));
        textureRegionDrawable = new TextureRegionDrawable(textureRegion);
        btnParar.getStyle().imageUp = textureRegionDrawable;
        btnParar.getLabel().setAlignment(Align.left);
        this.btnParar.setSize(100, 60);
        this.btnParar.setPosition(15, font1Y - heightShape - 300, Align.left);
        this.btnParar.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                tratarParar();
                return true;
            }
        });

        btnPular = new ImageTextButton("Pular", skinBotoesRespostas);
        textureRegion2 = new TextureRegion(assetManager.get("imagens/pular.jpg", Texture.class));
        textureRegionDrawable2 = new TextureRegionDrawable(textureRegion2);
        btnPular.getStyle().imageUp = textureRegionDrawable2;
        btnPular.getLabel().setAlignment(Align.left);
        this.btnPular.setSize(100, 60);
        this.btnPular.setPosition(130, font1Y - heightShape - 300, Align.left);
        this.btnPular.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                tratarPular();
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
        fontPontuacao.getData().setScale(1.5f);
        fontPontuacao.draw(batch, "Pontuação: " + jogo.getPontuacao().toString(), 750, 520);
        fontPontuacao.getData().setScale(1.8f);
        sacoMoeda.draw(batch);
        MoedaController.ref.draw(batch, delta);

        font1.draw(batch, tratarString(questao.getPergunta(), tabulacao), 50, font1Y);
        font1.getData().setScale(1.8f, 1.8f);
        font1.setColor(Color.BLACK);

        // respostas
        resposta1.getLabel().setText(" 1 - " + questao.getRespostas().get(0).getResposta());
        stage.addActor(JogoScreen.this.resposta1);

        resposta2.getLabel().setText(" 2 - " + questao.getRespostas().get(1).getResposta());
        stage.addActor(JogoScreen.this.resposta2);

        resposta3.getLabel().setText(" 3 - " + questao.getRespostas().get(2).getResposta());
        stage.addActor(JogoScreen.this.resposta3);

        resposta4.getLabel().setText(" 4 - " + questao.getRespostas().get(3).getResposta());
        stage.addActor(JogoScreen.this.resposta4);

        stage.addActor(JogoScreen.this.btnParar);


        btnPular.getLabel().setText("Pular " + jogo.getQuantidePulos());
        stage.addActor(JogoScreen.this.btnPular);

        stage.draw();

        batch.end();

        shape.begin(ShapeRenderer.ShapeType.Line);
        shape.setColor(Color.WHITE);
        shape.rect(15, Gdx.graphics.getHeight() - heightShape - 15, Gdx.graphics.getWidth() / 1.5f, heightShape);
        shape.end();
    }

    private void tratarPular() {
        jogo.setQuantidadePulos((jogo.getQuantidePulos() - 1));
        questao = sortearNovaQuestao();
        if (jogo.getQuantidePulos() == 0) {
            btnPular.setTouchable(Touchable.disabled);
        }
    }

    private void tratarParar() {
        assetManager.get("sons/estaCertoDisso.mp3", Sound.class).play(1f);
        int valor = JOptionPane.showConfirmDialog(null, "Está certo disso?\nPontuação se parar: " + jogo.getRodada().getParar(), "Confirma", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, new ImageIcon(System.getProperty("user.dir") + "\\core\\assets\\imagens\\goldbar.png"));
        if (valor == JOptionPane.YES_OPTION) {
            jogo.setPontuacao(jogo.getRodada().getParar());
            showDoMilhao.setGameScreen(new PararScreen(assetManager, showDoMilhao));
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
        sacoMoeda = null;
        moeda = null;
        questao = null;
        dados = null;
        font1.dispose();
        resposta1.clear();
        resposta1 = null;
        resposta2.clear();
        resposta2 = null;
        resposta3.clear();
        resposta3 = null;
        resposta4.clear();
        resposta4 = null;
        fontPontuacao.dispose();
        btnPular.clear();
        btnPular = null;
        btnEliminar2.clear();
        btnEliminar2 = null;
        btnParar.clear();
        btnParar = null;
        retorno = null;
        arrayTexto = null;
    }


    private String tratarString(String texto, int tabulacao) {
        arrayTexto = texto.toCharArray();
        retorno = "";
        flg = false;
        flg2 = false;
        k = 0;
        indice = 0;

        for (int i = 0; i < arrayTexto.length; i++) {

            if (indice > 0 && indice % tabulacao == 0 || flg) {
                flg = true;
                if (arrayTexto[i] == ' ') {
                    flg2 = true;
                } else {
                    if (flg2 && arrayTexto[i] != ' ') {
                        retorno += "\n";
                        k++;
                        flg = false;
                        flg2 = false;
                    }
                }
            }
            retorno += arrayTexto[i];
            k++;
            indice++;
        }

        return retorno;
    }

    private void confirmaResposta(Resposta resposta) {
        assetManager.get("sons/estaCertoDisso.mp3", Sound.class).play(1f);
        int valor = JOptionPane.showConfirmDialog(null, "Está certo disso?" + "\n" + resposta.getResposta(), "Confirma", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, new ImageIcon(System.getProperty("user.dir") + "\\core\\assets\\imagens\\goldbar.png"));
        if (valor == JOptionPane.YES_OPTION) {
            if (resposta.isCorreta()) {
                tratarAcerto();
            } else {
                tratarErro();
            }
        }
    }


    private void tratarAcerto() {
        jogarMoedas();
        assetManager.get("sons/certaResposta.mp3", Sound.class).play(1f);
        assetManager.get("sons/moedaGanho.mp3", Sound.class).play(1f);
        jogo.setPontuacao(jogo.getRodada().getAcertar());
        jogo.proximaRodada();
        questao = sortearNovaQuestao();
    }

    private void tratarErro() {
        assetManager.get("sons/quepenaErrou.mp3", Sound.class).play(1f);
        jogo.setPontuacao(jogo.getRodada().getErrar());
    }

    private Questao sortearNovaQuestao() {
        return dados.getQuestao(jogo.getRodada().getDificuldade());
    }

    private void jogarMoedas() {
        MoedaController.ref.addNewBullet(Gdx.graphics.getWidth() - 150, (Gdx.graphics.getHeight() / 12) + 100);
        MoedaController.ref.addNewBullet(Gdx.graphics.getWidth() - 200, (Gdx.graphics.getHeight() / 12) + 50);
        MoedaController.ref.addNewBullet(Gdx.graphics.getWidth() - 250, (Gdx.graphics.getHeight() / 12) + 75);
    }

}
