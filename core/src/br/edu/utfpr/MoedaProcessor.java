package br.edu.utfpr;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class MoedaProcessor implements InputProcessor {
    public boolean isSPressed = false, isWPressed=false;
    MoedaProcessor() {
        ShowDoMilhao.addInputProcessor(this);
    }
    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.S){
            isSPressed=true;
        }
        if(keycode == Input.Keys.W){
            isWPressed = true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(keycode == Input.Keys.S){
            isSPressed=false;
        }
        if(keycode == Input.Keys.W){
            isWPressed = false;
        }
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
