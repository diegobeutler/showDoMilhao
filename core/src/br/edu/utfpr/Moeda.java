package br.edu.utfpr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Moeda extends Sprite {
    private MoedaProcessor moedaProcessor;
    private Moeda moeda;
    private float timer;
    private int idRegion = 0;

    public Moeda() {
        super(ShowDoMilhao.game.getAssetManager().get("imagens/animacaoMoeda.png", Texture.class), 0, 0, 2500, 2500);
        this.setSize(this.getWidth() / 16, this.getHeight() / 16);
        moedaProcessor = new MoedaProcessor();
        ShowDoMilhao.addInputProcessor(moedaProcessor);
    }

    public float getCenterX() {
        return this.getX() + this.getWidth() / 3;
    }

    public float getCenterY() {
        return this.getY() + this.getHeight() / 3;
    }

    public boolean isOutOfScreen() {
        return (this.getCenterX() < 0 || this.getCenterX() > Gdx.graphics.getWidth() || this.getCenterY() < 0 || this.getCenterY() > Gdx.graphics.getHeight());
    }

    public void draw(SpriteBatch batch, float delta) {

        update(delta);
        super.draw(batch);

        if (hasHitPipe()) {
            ShowDoMilhao.game.setScreen(new GameOverScreen());
        }
        this.setY(this.getY() + 110 * delta);
    }

    public void update(final float delta) {
        timer += delta;
        if (timer > 0.2) {
            timer -= 0.2;
            idRegion++;
            if (idRegion >= 6) idRegion = 0;
            this.setRegion(idRegion * 2500, 0, 2500, 2500);
        }
    }

    public boolean hasHitPipe(){
        return MoedaController.verifyHit(this);
    }

    public boolean verifyPointHit(float x, float y) {
        return this.moeda.getX() < x && this.moeda.getY() < y
                && x < this.moeda.getX()+this.moeda.getWidth() && y < this.moeda.getY()+this.moeda.getHeight();
    }

}


