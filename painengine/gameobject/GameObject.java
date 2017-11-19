package painengine.gameobject;

import painengine.Game;
import painengine.Screen;
import painengine.component.GameComponent;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;


/**
	GameObjects can store multiple components that can modify how
	the GameObject behaves.
 */

public abstract class GameObject extends Controllable
{

	private List<GameComponent> components = new LinkedList<>();

	public GameObject(){
		super();
		start();
	}

	public GameObject(BufferedImage image){
		super(image);
		start();
	}

	public GameObject(int x, int y, int width, int height){
		super(x, y, width, height);
		start();
	}

	protected void addComponent(GameComponent c){
		components.add(c);
		c.init(this);
	}

	protected void removeComponent(GameComponent c){
		c.remove();
		components.remove(c);
	}

	public void startListening(Screen screen){
		screen.addKeyListener(this);
	}

	public abstract void start();
	public abstract void update();

	public List<GameComponent> getComponents(){return this.components;}
}

