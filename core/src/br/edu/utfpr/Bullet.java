package br.edu.utfpr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Bullet extends Sprite {

    public Bullet() {
        super(ShowDoMilhao.game.getAssetManager().get("imagens/moeda.png", Texture.class));
        this.setSize(this.getWidth()/8, this.getHeight()/8);
    }

    public float getCenterX(){
        return this.getX()+this.getWidth()/3;
    }

    public float getCenterY(){
        return this.getY()+this.getHeight()/3;
    }

     public boolean isOutOfScreen(){
            return (this.getCenterX()<0 || this.getCenterX() > Gdx.graphics.getWidth() || this.getCenterY()<0 || this.getCenterY() >Gdx.graphics.getHeight());
     }

     public void draw(SpriteBatch batch, float delta) {
            super.draw(batch);
            this.setX(this.getX() + 110 * delta);
     }




}
