package br.edu.utfpr;

import com.badlogic.gdx.InputProcessor;

public class MoedaProcessor implements InputProcessor {
    MoedaProcessor(){
        ShowDoMilhao.addInputProcessor(this);
    }
    @Override
    public boolean keyDown(int keycode) {
        MoedaController.ref.addNewBullet(MainScreen.ref.sacoMoeda.getX()+150,MainScreen.ref.sacoMoeda.getY()+450);
        MoedaController.ref.addNewBullet(MainScreen.ref.sacoMoeda.getX()+100,MainScreen.ref.sacoMoeda.getY()+150);
        MoedaController.ref.addNewBullet(MainScreen.ref.sacoMoeda.getX()+50,MainScreen.ref.sacoMoeda.getY()+300);
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
