package painengine.component;

import java.awt.Rectangle;
import java.util.List;
import java.util.LinkedList;

import painengine.gameobject.GameObject;
/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Collider extends GameComponent
{
	private static List<Rectangle> colliders = new LinkedList<>();

	private Rectangle collider;
	private GameObject host;

	@Override
	protected void start(){
		host = getHost();
		collider = new Rectangle(host.getX(), host.getY(), host.getWidth(), host.getHeight());
		colliders.add(collider);
	}

	@Override
	public void remove(){
		colliders.remove(collider);
	}

	@Override
	public void run(){
		collider.setBounds(host.getX(), host.getY(), host.getWidth(), host.getHeight());
	}
}

