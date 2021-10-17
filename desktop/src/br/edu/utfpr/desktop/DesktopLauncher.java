package br.edu.utfpr.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import br.edu.utfpr.ShowDoMilhao;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 960;
		config.height = 540;
		config.title = "Show do Milhao";// ver questão do acento
		new LwjglApplication(new ShowDoMilhao(), config);
	}
}
