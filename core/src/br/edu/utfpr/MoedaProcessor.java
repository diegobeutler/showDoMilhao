package br.edu.utfpr;

import com.badlogic.gdx.InputProcessor;

public class MoedaProcessor implements InputProcessor {
    public boolean isSPressed = false, isWPressed=false;
    MoedaProcessor(){
        ShowDoMilhao.addInputProcessor(this);
    }
    @Override
    public boolean keyDown(int keycode) {

        //MoedaController.ref.addNewBullet(Gdx.graphics.getWidth()-300,MainScreen.ref.moeda.getY()+150);
        //MoedaController.ref.addNewBullet(Gdx.graphics.getWidth()-250,MainScreen.ref.moeda.getY()+100);
       // MoedaController.ref.addNewBullet(Gdx.graphics.getWidth()-200,MainScreen.ref.moeda.getY()+200);
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
