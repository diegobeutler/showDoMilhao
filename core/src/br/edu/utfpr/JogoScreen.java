package br.edu.utfpr;

import br.edu.utfpr.enumeration.Rodada;
import br.edu.utfpr.jogo.Jogo;
import br.edu.utfpr.json.Dados;
import br.edu.utfpr.json.Questao;
import br.edu.utfpr.json.Resposta;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.google.gson.Gson;

import javax.swing.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static br.edu.utfpr.jogo.Jogo.getJogo;

public class JogoScreen implements Screen {
    private ShowDoMilhao showDoMilhao;
    private AssetManager assetManager;

    SpriteBatch batch;
    Texture img;

    private Stage stage;
    private Stage stage2 = new Stage();
    private Label outputLabel;
    public SacoMoeda sacoMoeda;
    private OrthographicCamera camera;
    //    private Viewport viewport;
    private Moeda moeda;
    private boolean emPergunta;
    Questao questao;
    Dados dados;
    Jogo jogo;
    private BitmapFont font1 = new BitmapFont();
    // botoes respostas
    private Skin skinBotoesRespostas;
    private TextButton resposta1;
    private TextButton resposta2;
    private TextButton resposta3;
    private TextButton resposta4;
    private BitmapFont fontPontuacao = new BitmapFont();

    // ajudas
    private TextButton btnPular;
    private TextButton btnEliminar2;
    private TextButton btnParar;
    /// tratar string
    private String retorno = "";
    private boolean flg = false;
    private boolean flg2 = false;
    private int k = 0;
    private int indice = 0;
    private char[] arrayTexto;


    public static JogoScreen ref;

    public JogoScreen(AssetManager assetManager) {
        this.assetManager = assetManager;

    }


    public void show() {
        batch = new SpriteBatch();
        stage = new Stage(new ScreenViewport());
        ShowDoMilhao.addInputProcessor(stage);
        img = new Texture("imagens\\bg.jpg");

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
            questao = dados.getQuestao(jogo.getRodada().getDificuldade());
        } catch (Exception e) {
            e.printStackTrace();
        }

        ref = this;
        new MoedaController();
        sacoMoeda = new SacoMoeda();
        moeda = new Moeda();
        sacoMoeda.setX((float) (Gdx.graphics.getWidth() / 1.35));

//        camera = new OrthographicCamera(222, 20 * (Gdx.graphics.getWidth() / Gdx.graphics.getHeight()));
//
//        camera.position.set(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 0);
//        viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), camera);
//        questao = dados.getQuestao(jogo.getDificuldade());

    }

    @Override
    public void render(float delta) {
        stage.act();

        ScreenUtils.clear(0, 0, 0, 1);
        batch.begin();

        batch.draw(img, 0, 0);
        fontPontuacao.draw(batch, jogo.getPontuacao().toString(), 800, 520);
        sacoMoeda.draw(batch, delta);
        MoedaController.ref.draw(batch, delta);

        int tabulacao = 40;// todo mudar lá para cima
        float heightShape = 100;
        float font1Y = 500;

        font1.draw(batch, tratarString(questao.getPergunta(), tabulacao), 50, font1Y);
        font1.getData().setScale(1.8f, 1.8f);
        font1.setColor(Color.BLACK);

        // respostas

        resposta1 = new TextButton(" 1 - " + questao.getRespostas().get(0).getResposta(), skinBotoesRespostas);
        resposta1.getLabel().setAlignment(Align.left);
//        resposta1.getLabel().setFontScale(1.7f);


        this.resposta1.setSize(Gdx.graphics.getWidth() / 2, 60);
        this.resposta1.setPosition(15, font1Y - heightShape - 20, Align.left);
        this.resposta1.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                confirmaResposta(questao.getRespostas().get(0));
                return true;
            }
        });
        stage.addActor(JogoScreen.this.resposta1);

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
        stage.addActor(JogoScreen.this.resposta2);

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
        stage.addActor(JogoScreen.this.resposta3);

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
        stage.addActor(JogoScreen.this.resposta4);

        btnParar = new TextButton("Parar", skinBotoesRespostas);
        btnParar.getLabel().setAlignment(Align.left);

        this.btnParar.setSize(Gdx.graphics.getWidth() / 2, 60);
        this.btnParar.setPosition(15, font1Y - heightShape - 300, Align.left);
        this.btnParar.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                assetManager.get("sons/estaCertoDisso.mp3", Sound.class).play(1f);
                int valor = JOptionPane.showConfirmDialog(null, "Está certo disso?", "Confirma", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, new ImageIcon(System.getProperty("user.dir") + "\\core\\assets\\imagens\\goldbar.png"));
                if (valor == JOptionPane.YES_OPTION) {
                    jogo.setPontuacao(jogo.getRodada().getParar());
                }
                return true;
            }
        });
        stage.addActor(JogoScreen.this.btnParar);


        stage.draw();

        batch.end();

        ShapeRenderer shape = new ShapeRenderer();
        shape.begin(ShapeRenderer.ShapeType.Line);
        shape.setColor(Color.WHITE);
        shape.rect(15, Gdx.graphics.getHeight() - heightShape - 15, Gdx.graphics.getWidth() / 1.5f, 100);
        shape.end();

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
        batch.dispose();
        img.dispose();
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
    float delta;
    private void tratarAcerto() {
        assetManager.get("sons/certaResposta.mp3", Sound.class).play(1f);
        assetManager.get("sons/moedaGanho.mp3", Sound.class).play(1f);
        MoedaController.ref.addNewBullet(Gdx.graphics.getWidth()-300,(Gdx.graphics.getHeight()/12)+150);
        MoedaController.ref.addNewBullet(Gdx.graphics.getWidth()-250,(Gdx.graphics.getHeight()/12)+100);
        MoedaController.ref.addNewBullet(Gdx.graphics.getWidth()-200,(Gdx.graphics.getHeight()/12)+200);
        jogo.setPontuacao(jogo.getRodada().getAcertar());
        jogo.proximaRodada();
        questao = dados.getQuestao(jogo.getRodada().getDificuldade());
    }

    private void tratarErro() {
        assetManager.get("sons/quepenaErrou.mp3", Sound.class).play(1f);
        jogo.setPontuacao(jogo.getRodada().getErrar());
    }

}
