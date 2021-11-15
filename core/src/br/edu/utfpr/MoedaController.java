package br.edu.utfpr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.HashMap;

public class MoedaController {
    public static MoedaController ref;
    private HashMap<Integer, Moeda> bullets, deadBullets;
    private int count = 0;

    MoedaController() {
        ref = this;
        init();
    }

    public void init() {
        if (bullets == null) {
            bullets = new HashMap<Integer, Moeda>(100);
            deadBullets = new HashMap<Integer, Moeda>(100);
        }
        new MoedaProcessor();
    }

    public void addNewBullet(float x, float y) {
//        if (deadBullets.size() > 0) {
//            deadBullets.get(0).setPosition(x, y);
//            int id = deadBullets.keySet().iterator().next();
//            Moeda b = deadBullets.get(id);
//            bullets.put(id, b);
//        } else {
            Moeda b = new Moeda();
            b.setPosition(x, y);
            bullets.put(count, b);
            count++;
       // }
    }

    public void draw(final SpriteBatch batch, float delta) {
        for (final int id : bullets.keySet()) {
            final Moeda moeda = bullets.get(id);
            moeda.draw(batch, delta);
            Gdx.app.postRunnable(new Runnable() {
                @Override
                public void run() {
                    if (moeda.isOutOfScreen()) {
                        deadBullets.put(id, moeda);
                        bullets.remove(id);
                    }
                }
            });

        }
    }


}
