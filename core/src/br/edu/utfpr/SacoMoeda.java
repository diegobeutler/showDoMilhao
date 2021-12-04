package br.edu.utfpr;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SacoMoeda extends Sprite {
    private SacoMoedaProcessor sacoMoedaProcessor;

    SacoMoeda() {
        super(ShowDoMilhao.game.getAssetManager().get("imagens/sacodemoeda.png", Texture.class));
        this.setSize(this.getWidth() / 4, this.getHeight() / 4);
        sacoMoedaProcessor = new SacoMoedaProcessor();
        ShowDoMilhao.addInputProcessor(sacoMoedaProcessor);
    }

    public void draw(SpriteBatch batch) {
        super.draw(batch);
    }


}
