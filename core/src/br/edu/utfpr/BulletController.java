package br.edu.utfpr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.HashMap;

public class BulletController {
    public static BulletController ref;
    private HashMap<Integer, Bullet> bullets, deadBullets;

    BulletController() {
        ref = this;
        init();
    }

    public void init() {
        if (bullets == null) {
            bullets = new HashMap<Integer, Bullet>(40);
            deadBullets = new HashMap<Integer, Bullet>(40);
        }
        new BulletsProcessor();
    }

    private int count = 0;

    public void addNewBullet(float x, float y) {
        if (deadBullets.size() > 0) {
            deadBullets.get(0).setPosition(x, y);
            int id = deadBullets.keySet().iterator().next();
            Bullet b = deadBullets.get(id);
            bullets.put(id, b);
        } else {
            Bullet b = new Bullet();
            b.setPosition(x, y);
            bullets.put(count, b);
            count++;
        }
    }

    public void draw(final SpriteBatch batch, float delta) {
        for (final int id : bullets.keySet()) {
            final Bullet b = bullets.get(id);
            b.draw(batch, delta);
            Gdx.app.postRunnable(new Runnable() {
                @Override
                public void run() {
                    if (b.isOutOfScreen()) {
                        deadBullets.put(id, b);
                        bullets.remove(id);
                    }
                }
            });

        }
    }


}
