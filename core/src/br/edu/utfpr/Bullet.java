package br.edu.utfpr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Bullet extends Sprite {

    public Bullet() {
        super(ShowDoMilhao.game.getAssetManager().get("imagens/animacaoMoeda.png", Texture.class), 0, 0 , 2500, 2500);
        this.setSize(this.getWidth()/12, this.getHeight()/12);
        moedaProcessor = new MoedaProcessor();
        ShowDoMilhao.addInputProcessor(moedaProcessor);
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
    private MoedaProcessor moedaProcessor;
     public void draw(SpriteBatch batch, float delta) {
            update(delta);
            super.draw(batch);
            this.setX(this.getX() + 110 * delta);
     }
    private float timer;
    private int idRegion = 0;

    public void update (final float delta){
        //if(moedaProcessor.isWPressed || moedaProcessor.isSPressed){
            timer +=delta;
            if (timer > 0.2){
                timer -= 0.2;
                idRegion++;
                if(idRegion>=6) idRegion = 0;
                this.setRegion(idRegion*2500, 0 , 2500, 2500);
            }

       // }else{
      //      idRegion = 0 ;
       //}



    }
}
