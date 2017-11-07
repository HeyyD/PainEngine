package painengine.gameobject;

import painengine.Game;
import painengine.component.GameComponent;

import java.util.LinkedList;
import java.util.List;


/**
	GameObjects can store multiple components that can modify how
	the GameObject behaves.
 */

public class GameObject extends Controllable
{

	private List<GameComponent> components = new LinkedList<>();

	public GameObject(){
		super();
	}

	public GameObject(int x, int y, int width, int height){
		super(x, y, width, height);
	}

	public void addComponent(GameComponent c){
		components.add(c);
		c.init(this);
	}

	public void startListening(){
		Game.getScreen().addKeyListener(this);
	}

	public void update(){

	}

	public List<GameComponent> getComponents(){return this.components;}
}

