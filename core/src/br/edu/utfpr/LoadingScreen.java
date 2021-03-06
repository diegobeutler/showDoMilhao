package br.edu.utfpr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.ScreenUtils;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class LoadingScreen implements Screen {
    private Sprite sprite;
    private SpriteBatch batch;
    private float originalWidth;
    private ShowDoMilhao showDoMilhao;
    private BitmapFont font = new BitmapFont();
    private Texture img;
    private NumberFormat formatarFloat = new DecimalFormat("0.00");

    @Override
    public void show() {
        img = new Texture("imagens\\show-do-milhao.jpg");

        sprite = new Sprite(new Texture("imagens/barra_prog.png"));
        sprite.setCenter(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        batch = new SpriteBatch();
        originalWidth = sprite.getWidth();

        // load
        showDoMilhao.getAssetManager().load("imagens/animacaoMoeda.png", Texture.class);
        showDoMilhao.getAssetManager().load("imagens/eliminar.png", Texture.class);
        showDoMilhao.getAssetManager().load("imagens/parar.png", Texture.class);
        showDoMilhao.getAssetManager().load("imagens/pular.png", Texture.class);
        showDoMilhao.getAssetManager().load("imagens/reiniciar.png", Texture.class);
        showDoMilhao.getAssetManager().load("imagens/sair.png", Texture.class);
        showDoMilhao.getAssetManager().load("imagens/gameOver.png", Texture.class);
        showDoMilhao.getAssetManager().load("imagens/showlogo.png", Texture.class);
        showDoMilhao.getAssetManager().load("imagens/goldbar.png", Texture.class);
        showDoMilhao.getAssetManager().load("imagens/goldbar_ori.png", Texture.class);
        showDoMilhao.getAssetManager().load("imagens/bg.jpg", Texture.class);
        showDoMilhao.getAssetManager().load("imagens/jogar.png", Texture.class);
        showDoMilhao.getAssetManager().load("imagens/show-do-milhao.jpg", Texture.class);
        showDoMilhao.getAssetManager().load("imagens/dialogbox.png", Texture.class);

        showDoMilhao.getAssetManager().load("imagens/sacodemoeda.png", Texture.class);

        showDoMilhao.getAssetManager().load("sons/abertura.wav", Sound.class);
        showDoMilhao.getAssetManager().load("sons/boaSorte.mp3", Sound.class);
        showDoMilhao.getAssetManager().load("sons/moedaGanho.mp3", Sound.class);
        showDoMilhao.getAssetManager().load("sons/certaResposta.wav", Sound.class);
        showDoMilhao.getAssetManager().load("sons/quepenaErrou.mp3", Sound.class);
        showDoMilhao.getAssetManager().load("sons/estaCertoDisso.mp3", Sound.class);
        showDoMilhao.getAssetManager().load("sons/trilhaSonoraMeio.mp3", Sound.class);
        showDoMilhao.getAssetManager().load("sons/trilhaSonoraInicio.mp3", Sound.class);
        showDoMilhao.getAssetManager().load("1milhao.mp3", Sound.class);
        showDoMilhao.getAssetManager().load("sons/trilhaSuspense.mp3", Sound.class);
        showDoMilhao.getAssetManager().load("sons/vaiComecarOShowDoMilhao.mp3", Sound.class);
        showDoMilhao.getAssetManager().load("sons/tempoAcabou.mp3", Sound.class);
        showDoMilhao.getAssetManager().load("sons/1Rodada.mp3", Sound.class);
        showDoMilhao.getAssetManager().load("sons/1milhaoCortado.mp3", Sound.class);
        showDoMilhao.getAssetManager().load("sons/2Rodada.wav", Sound.class);
        showDoMilhao.getAssetManager().load("sons/3Rodada.wav", Sound.class);
        showDoMilhao.getAssetManager().load("sons/200milCortado.mp3", Sound.class);
        showDoMilhao.getAssetManager().load("sons/300milCortado.mp3", Sound.class);
        showDoMilhao.getAssetManager().load("sons/400milCortado.mp3", Sound.class);
        showDoMilhao.getAssetManager().load("sons/500milCortado.mp3", Sound.class);
        showDoMilhao.getAssetManager().load("sons/trilhaSonoraAgitado.mp3", Sound.class);
        showDoMilhao.getAssetManager().load("sons/trilhaSonoraCalmo.mp3", Sound.class);
        showDoMilhao.getAssetManager().load("sons/trilhaSonoraMeio.mp3", Sound.class);
        showDoMilhao.getAssetManager().load("sons/trilhaSuspense.mp3", Sound.class);

        showDoMilhao.getAssetManager().load("skin/neon-ui.json", Skin.class);
        showDoMilhao.getAssetManager().load("skin2/neon-ui.json", Skin.class);
        showDoMilhao.getAssetManager().load("skin3/neon-ui.json", Skin.class);



    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        float progress = showDoMilhao.getAssetManager().getProgress();

        if (showDoMilhao.getAssetManager().update()) {
            showDoMilhao.setGameScreen();
        }

        sprite.setRegion(0, 0, (int) (originalWidth * progress), (int) (sprite.getHeight() * progress));
        sprite.setSize((int) (originalWidth * progress), (int) (sprite.getHeight()));
        batch.begin();
        batch.setPackedColor((float) 0.8);
        batch.draw(img, 0, 0);
        sprite.draw(batch);

        font.draw(batch, "Loading ... " + formatarFloat.format(progress * 100) + " %", 380, 320);
        font.getData().setScale((float) 2, (float) 2);

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
        batch.dispose();
        showDoMilhao.dispose();
        font.dispose();
        img.dispose();
    }
}
