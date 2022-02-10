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
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.google.gson.Gson;
import sun.java2d.pipe.OutlineTextRenderer;

import javax.swing.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    private Skin skinBotoesRespostas2;
    private Skin skinBotoesRespostas3;
    private TextButton resposta1;
    private TextButton resposta2;
    private TextButton resposta3;
    private TextButton resposta4;
    private TextButton botaoPara;
    private TextureRegionDrawable textureRegionDrawable, textureRegionDrawable2, textureRegionDrawable3;
    private TextureRegion textureRegion, textureRegion2, textureRegion3;
    private BitmapFont fontPontuacao = new BitmapFont();
    private BitmapFont fontRodada = new BitmapFont();
    private BitmapFont fontTempo = new BitmapFont();
    private int tempo = 45;
    private ImageIcon imageIconGoldBar = new ImageIcon(System.getProperty("user.dir") + "\\core\\assets\\imagens\\goldbar.png");
    // ajudas
    private ImageTextButton btnPular;
    private ImageTextButton btnEliminar2;
    private ImageTextButton btnParar;
    private String retorno = "";
    private boolean flg = false;
    private boolean flg2 = false;
    private int k = 0;
    private int indice = 0;
    private char[] arrayTexto;
    private int tabulacao = 40;
    private float heightShape = 100;
    private float font1Y = 500;
    private boolean revertElimina2 = false;
    private float timeSeconds = 0f;
    private float period = 1f;
    private NinePatch patch;
    private NinePatchDrawable patchDrawable;
    private ParticleEffect effect = new ParticleEffect();


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
        effect.load(Gdx.files.internal("particles/myparticle.p"), Gdx.files.internal("particles"));

        //botoes respostas
        skinBotoesRespostas = assetManager.get("skin/neon-ui.json", Skin.class);
        skinBotoesRespostas2 = assetManager.get("skin2/neon-ui.json", Skin.class);
        skinBotoesRespostas3 = assetManager.get("skin3/neon-ui.json", Skin.class);

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
                confirmaResposta(0);
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
                confirmaResposta(1);
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
                confirmaResposta(2);
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
                confirmaResposta(3);
                return true;
            }
        });
        //botão parar
        btnParar = new ImageTextButton("Parar", skinBotoesRespostas);
        textureRegion = new TextureRegion(assetManager.get("imagens/parar.png", Texture.class));
        textureRegionDrawable = new TextureRegionDrawable(textureRegion);
        btnParar.getStyle().imageUp = textureRegionDrawable;
        btnParar.getLabel().setAlignment(Align.left);
        this.btnParar.setSize(140, 80);
        this.btnParar.setPosition(25, font1Y - heightShape - 300, Align.left);
        this.btnParar.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                tratarParar();
                return true;
            }
        });


        btnPular = new ImageTextButton("Pular", skinBotoesRespostas2);
        textureRegion2 = new TextureRegion(assetManager.get("imagens/pular.png", Texture.class));
        textureRegionDrawable2 = new TextureRegionDrawable(textureRegion2);
        btnPular.getStyle().imageUp = textureRegionDrawable2;
        btnPular.getLabel().setAlignment(Align.left);
        this.btnPular.setSize(140, 80);
        this.btnPular.setPosition(btnParar.getX() + 160, font1Y - heightShape - 300, Align.left);
        this.btnPular.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                tratarPular();
                return true;
            }
        });


        btnEliminar2 = new ImageTextButton("Eliminar 2", skinBotoesRespostas3);
        textureRegion3 = new TextureRegion(assetManager.get("imagens/eliminar.png", Texture.class));
        textureRegionDrawable3 = new TextureRegionDrawable(textureRegion3);
        btnEliminar2.getStyle().imageUp = textureRegionDrawable3;
        btnEliminar2.getLabel().setAlignment(Align.left);
        this.btnEliminar2.setSize(140, 80);
        this.btnEliminar2.setPosition(btnPular.getX() + 160, font1Y - heightShape - 300, Align.left);
        this.btnEliminar2.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                tratarEliminar2();
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
        fontTempo.draw(batch, "Tempo: " + tempo, 700, 520);
        fontTempo.getData().setScale(1.8f);
        fontPontuacao.draw(batch, "Pontuação: " + jogo.getPontuacao().toString(), 700, 470);
        fontPontuacao.getData().setScale(1.8f);
        fontRodada.draw(batch, "Rodada: " + jogo.getRodada().getLabel().replaceAll("[\\D]", "") + " / 16", 700, 420);
        fontRodada.getData().setScale(1.8f);

        sacoMoeda.draw(batch);
        MoedaController.ref.draw(batch, delta);

        font1.draw(batch, tratarString(questao.getPergunta(), tabulacao), 50, font1Y);
        font1.getData().setScale(1.8f, 1.8f);
        font1.setColor(Color.WHITE);

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

        stage.addActor(JogoScreen.this.btnEliminar2);

        stage.draw();
        effect.draw(batch, delta);
        batch.end();

        shape.begin(ShapeRenderer.ShapeType.Line);
        shape.setColor(Color.WHITE);
        shape.rect(15, Gdx.graphics.getHeight() - heightShape - 15, Gdx.graphics.getWidth() / 1.5f, heightShape);
        shape.end();
        timeSeconds += Gdx.graphics.getRawDeltaTime();
        if (timeSeconds > period) {
            timeSeconds -= period;
            if (tempo <= 0) {
                tratarFimTempo();
            } else {
                tempo--;
            }
        }
    }

    private void tratarPular() {
        if (revertElimina2) {
            revertEliminar2();
            revertElimina2 = false;
        }
        jogo.setQuantidadePulos((jogo.getQuantidePulos() - 1));
        questao = sortearNovaQuestao();
        if (jogo.getQuantidePulos() == 0) {
            btnPular.setTouchable(Touchable.disabled);
            btnPular.setColor(Color.GRAY);
            btnPular.getLabel().setColor(Color.GRAY);
        }
    }

    private void tratarEliminar2() {
        List listaEmbaralhada = new ArrayList<Integer>();
        listaEmbaralhada.add(1);
        listaEmbaralhada.add(2);
        listaEmbaralhada.add(3);
        listaEmbaralhada.add(4);
        Collections.shuffle(listaEmbaralhada);
        List<Resposta> respostas = questao.getRespostas();
        for (int i = 0; i < 4; i++) {
            if (listaEmbaralhada.get(i).toString().equals("1") && !respostas.get(0).isCorreta()) {
                resposta1.getLabel().setColor(Color.RED);
                resposta1.setTouchable(Touchable.disabled);
                listaEmbaralhada.remove((Integer) 1);
            } else if (listaEmbaralhada.get(i).toString().equals("2") && !respostas.get(1).isCorreta()) {
                resposta2.getLabel().setColor(Color.RED);
                resposta2.setTouchable(Touchable.disabled);
                listaEmbaralhada.remove((Integer) 2);
            } else if (listaEmbaralhada.get(i).toString().equals("3") && !respostas.get(2).isCorreta()) {
                resposta3.getLabel().setColor(Color.RED);
                resposta3.setTouchable(Touchable.disabled);
                listaEmbaralhada.remove((Integer) 3);
            } else if (listaEmbaralhada.get(i).toString().equals("4") && !respostas.get(3).isCorreta()) {
                resposta4.getLabel().setColor(Color.RED);
                resposta4.setTouchable(Touchable.disabled);
                listaEmbaralhada.remove((Integer) 4);
            }
            if (listaEmbaralhada.size() <= 2) {
                break;
            }
        }
        jogo.setPossuiElimina2(false);
        btnEliminar2.setTouchable(Touchable.disabled);
        btnEliminar2.setColor(Color.GRAY);
        btnEliminar2.getLabel().setColor(Color.GRAY);
        revertElimina2 = true;
    }

    private void revertEliminar2() {
        resposta1.getLabel().setColor(Color.WHITE);
        resposta1.setTouchable(Touchable.enabled);
        resposta2.getLabel().setColor(Color.WHITE);
        resposta2.setTouchable(Touchable.enabled);
        resposta3.getLabel().setColor(Color.WHITE);
        resposta3.setTouchable(Touchable.enabled);
        resposta4.getLabel().setColor(Color.WHITE);
        resposta4.setTouchable(Touchable.enabled);
    }


    private void tratarParar() {
        assetManager.get("sons/estaCertoDisso.mp3", Sound.class).play(1f);

        patch = new NinePatch(new Texture(Gdx.files.internal("skin/dialogbox.png")), 12, 12, 12, 12);
        patchDrawable = new NinePatchDrawable(patch);
        patch.setColor(Color.WHITE);
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("skin/neon-ui.atlas"));
        skinBotoesRespostas.addRegions(atlas);



        BitmapFont font32 = new BitmapFont(Gdx.files.internal("skin/abc.fnt"));
        font32.setColor(Color.WHITE);


        TextButton.TextButtonStyle buttonStyle = new TextButton.TextButtonStyle();
        buttonStyle.font = font32;
        buttonStyle.fontColor = Color.WHITE;
        buttonStyle.up = new NinePatchDrawable(skinBotoesRespostas.getPatch("button"));
        buttonStyle.pressedOffsetX = -2;


        botaoPara = new TextButton("Está certo disso? \n Pontuação se parar: " + jogo.getRodada().getParar(), buttonStyle);
        botaoPara.setPosition((Gdx.graphics.getWidth()/2)+20, (Gdx.graphics.getHeight()/2)+2);


        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle(patchDrawable, patchDrawable, patchDrawable, font32);
        style.fontColor = Color.WHITE; style.pressedOffsetX = -2;
        style.overFontColor = Color.WHITE;


        final TextButton buttonSim = new TextButton("Sim", style);
        buttonSim.setPosition(botaoPara.getX()+85, botaoPara.getY()-65);

        buttonSim.setSize(75,75);


        final TextButton buttonNao = new TextButton("Não", style);
        buttonNao.setPosition(buttonSim.getX()+90, botaoPara.getY()-65);
        buttonNao.setSize(75,75);
        buttonSim.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                jogo.setPontuacao(jogo.getRodada().getParar());
                showDoMilhao.setGameScreen(new PararScreen(assetManager, showDoMilhao));
                return true;
            }
        });

        buttonNao.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                botaoPara.remove();
                buttonSim.remove();
                buttonNao.remove();
                return true;
            }
        });

        stage.addActor(botaoPara);
        stage.addActor(buttonSim);
        stage.addActor(buttonNao);


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
        imageIconGoldBar = null;
        effect.dispose();
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

    private void confirmaResposta(final int i) {
        final Resposta resposta = questao.getRespostas().get(i);
        assetManager.get("sons/estaCertoDisso.mp3", Sound.class).play(1f);

        patch = new NinePatch(new Texture(Gdx.files.internal("skin/dialogbox.png")), 12, 12, 12, 12);
        patchDrawable = new NinePatchDrawable(patch);
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("skin/neon-ui.atlas"));
        skinBotoesRespostas.addRegions(atlas);

        BitmapFont font32 = new BitmapFont(Gdx.files.internal("skin/abc.fnt"));

        TextButton.TextButtonStyle buttonStyle = new TextButton.TextButtonStyle();
        buttonStyle.font = font32;
        buttonStyle.fontColor = Color.WHITE;
        buttonStyle.up = new NinePatchDrawable(skinBotoesRespostas.getPatch("button"));
        buttonStyle.down = new NinePatchDrawable(skinBotoesRespostas.getPatch("button"));
        buttonStyle.pressedOffsetX = -2;

        botaoPara = new TextButton("Está certo disso? ", buttonStyle);
        botaoPara.setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);

        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle(patchDrawable, patchDrawable, patchDrawable, font32);

        style.pressedOffsetX = -2;
        style.focusedFontColor = Color.WHITE;
        style.fontColor = Color.WHITE;

        final TextButton buttonSim = new TextButton("Sim", style);
        buttonSim.setPosition(botaoPara.getX()+40, botaoPara.getY()-65);
        buttonSim.setSize(75,75);

        final TextButton buttonNao = new TextButton("Não", style);
        buttonNao.setPosition(buttonSim.getX()+75, botaoPara.getY()-65);
        buttonNao.setSize(75,75);


        buttonSim.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                tempo = 45;
                if (resposta.isCorreta()) {
                    tratarAcerto(i);
                    if (revertElimina2) {
                        revertEliminar2();
                        revertElimina2 = false;
                    }
                } else {
                    tratarErro();
                }
                botaoPara.remove();
                buttonSim.remove();
                buttonNao.remove();
                return true;
            }
        });

        buttonNao.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                botaoPara.remove();
                buttonSim.remove();
                buttonNao.remove();
                return true;
            }
        });

        stage.addActor(botaoPara);
        stage.addActor(buttonSim);
        stage.addActor(buttonNao);

    }

    private void tratarAcerto(int i) {
        jogarMoedas();
        jogarParticulas(i);
        assetManager.get("sons/certaResposta.wav", Sound.class).play(1f);
        assetManager.get("sons/moedaGanho.mp3", Sound.class).play(1f);
        jogo.setPontuacao(jogo.getRodada().getAcertar());
        if (jogo.getRodada().equals(Rodada.RODADA_16)) {
            showDoMilhao.setGameScreen(new GanhouScreen(assetManager, showDoMilhao));
        } else {
            jogo.proximaRodada();
            if (jogo.getRodada().getSom() != null) {
                assetManager.get(jogo.getRodada().getSom(), Sound.class).play(1f);
            }
            questao = sortearNovaQuestao();
        }

    }

    private void jogarParticulas(int i) {
        float laguraBotaoSobre2 = resposta1.getWidth() / 2;
        switch (i) {
            case 0:
                effect.setPosition(resposta1.getX() + laguraBotaoSobre2, resposta1.getY());
                effect.start();
                break;
            case 1:
                effect.setPosition(resposta2.getX() + laguraBotaoSobre2, resposta2.getY());
                effect.start();
                break;
            case 2:
                effect.setPosition(resposta3.getX() + laguraBotaoSobre2, resposta3.getY());
                effect.start();
                break;
            case 3:
                effect.setPosition(resposta4.getX() + laguraBotaoSobre2, resposta4.getY());
                effect.start();
        }
    }

    private void tratarErro() {
        assetManager.get("sons/quepenaErrou.mp3", Sound.class).play(1f);
        jogo.setPontuacao(jogo.getRodada().getErrar());
        showDoMilhao.setGameScreen(new GameOverScreen(assetManager, showDoMilhao));
    }

    private void tratarFimTempo() {
        assetManager.get("sons/tempoAcabou.mp3", Sound.class).play(1f);
        jogo.setPontuacao(jogo.getRodada().getErrar());
        showDoMilhao.setGameScreen(new GameOverScreen(assetManager, showDoMilhao));
    }

    private Questao sortearNovaQuestao() {
        tempo = 45;
        return dados.getQuestao(jogo.getRodada().getDificuldade());
    }

    private void jogarMoedas() {
        MoedaController.ref.addNewBullet(Gdx.graphics.getWidth() - 150, (Gdx.graphics.getHeight() / 12) + 100);
        MoedaController.ref.addNewBullet(Gdx.graphics.getWidth() - 200, (Gdx.graphics.getHeight() / 12) + 50);
        MoedaController.ref.addNewBullet(Gdx.graphics.getWidth() - 250, (Gdx.graphics.getHeight() / 12) + 75);
    }

}
