package br.edu.utfpr;

import br.edu.utfpr.jogo.Jogo;
import br.edu.utfpr.jogo.Rodada;
import br.edu.utfpr.json.Dados;
import br.edu.utfpr.json.Questao;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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

public class JogoScreen implements Screen {
    private ShowDoMilhao showDoMilhao;

    SpriteBatch batch;
    Texture img;

    private Stage stage;
    private Label outputLabel;
    public Moeda moeda;



    public JogoScreen() {

    }



    public void show () {
        batch = new SpriteBatch();
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

    }

    @Override
    public void render (float delta) {

        ScreenUtils.clear(0, 0, 0, 1);
        batch.begin();
        batch.draw(img, 0, 0);
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
