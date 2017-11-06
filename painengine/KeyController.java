package painengine;

import painengine.Screen;
import painengine.launch.Game;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

/**
	User can add KeyController to a GameObject. 
 */

public class KeyController implements Component, KeyListener
{

	public KeyController(){
		Game.getScreen().addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent e){

	}

	@Override
	public void keyReleased(KeyEvent e){

	}

	@Override
	public void keyTyped(KeyEvent e){

	}

	@Override
	public void run(){

	}
}

