package br.edu.utfpr;

import com.badlogic.gdx.InputProcessor;

public class BulletsProcessor implements InputProcessor {
    BulletsProcessor(){
        ShowDoMilhao.addInputProcessor(this);
    }
    @Override
    public boolean keyDown(int keycode) {
        BulletController.ref.addNewBullet(MainScreen.ref.moeda.getX()+150,MainScreen.ref.moeda.getY()+40);
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
