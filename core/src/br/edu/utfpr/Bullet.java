package br.edu.utfpr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pool;

public class Bullet extends Sprite {
    private static Texture txt;

    public Bullet() {
        super(ShowDoMilhao.game.getAssetManager().get("imagens/barra.jpg", Texture.class));
        //this.setSize(this.getWidth()/3, this.getHeight()/3);
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
            this.setX(this.getX() + 100 * delta);
        }




}
