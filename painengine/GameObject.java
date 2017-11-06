package painengine;

import java.util.LinkedList;
import java.util.List;


/**
	GameObjects can store multiple components that can modify how
	the GameObject behaves.
 */

public class GameObject extends Sprite
{

	private List<Component> components = new LinkedList<>();

	public GameObject(){
		super();
	}

	public GameObject(int x, int y, int width, int height){
		super(x, y, width, height);
	}

	public void addComponent(Component c){
		components.add(c);
	}
}

