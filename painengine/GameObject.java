package painengine;

import java.util.LinkedList;
import java.util.List;


/**
	GameObjects can store multiple components that can modify how
	the GameObject behaves.
 */

public class GameObject extends Sprite
{

	private List<Component> components;

	public GameObject(){
		super();
	}

}

