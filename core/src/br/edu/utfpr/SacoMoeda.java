package br.edu.utfpr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SacoMoeda extends Sprite {
    private SacoMoedaProcessor sacoMoedaProcessor;

    SacoMoeda(){
        super(ShowDoMilhao.game.getAssetManager().get("imagens/sacodemoeda.png",  Texture.class));
        this.setSize(this.getWidth()/4, this.getHeight()/4);
        sacoMoedaProcessor = new SacoMoedaProcessor();
        ShowDoMilhao.addInputProcessor(sacoMoedaProcessor);
    }

    public void update (final float delta){
        //if(sacoMoedaProcessor.isWPressed){
        //    this.setY(this.getY()+100*delta);
       /// }
       // if(sacoMoedaProcessor.isSPressed){
       //     this.setY(this.getY()-100*delta);
        //}


    }

    public void draw (SpriteBatch batch, float delta){
        update(delta);
        super.draw(batch);
    }

    public float getCenterX(){
        return this.getX()+this.getWidth()/2;
    }

    public float getCenterY(){
        return this.getY()+this.getHeight()/2;
    }

    public boolean isOutOfScreen(){
        return (this.getCenterX()<0 || this.getCenterX() > Gdx.graphics.getWidth() || this.getCenterY()<0 || this.getCenterY() >Gdx.graphics.getHeight());
    }



}
