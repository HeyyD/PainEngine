package painengine.gameobject;

import painengine.Game;
import painengine.Screen;
import painengine.component.GameComponent;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;


/**
	GameObjects can store multiple components that can modify how
	the GameObject behaves. Extends Controllable.

	@see Contollable
 */

public abstract class GameObject extends Controllable
{
	private List<GameComponent> components = new LinkedList<>();

	public GameObject(){
		super();
		start();
	}

	public GameObject(String imagePath){
		super(imagePath);
		start();
	}

	public GameObject(BufferedImage image){
		super(image);
		start();
	}

	public GameObject(BufferedImage image, int x, int y){
		super(image, x, y);
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

	/**
		Screen starts to listen for KeyInput.

		@param screen Screen that the listener is added
	 */
	public void startListening(Screen screen){
		screen.addKeyListener(this);
	}

	/** Start is called in every constructor. Can be overrided
		if user wants to initialize something.
	 */
	public void start(){}

	/** Update is called in every game loop round. */
	public abstract void update();

	/**
		@return All components in this GameObject
	 */
	public List<GameComponent> getComponents(){return this.components;}
}

