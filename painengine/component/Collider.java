package painengine.component;

import java.awt.Rectangle;

import painengine.gameobject.GameObject;
/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Collider extends GameComponent
{

	private Rectangle collider;
	private GameObject host;

	@Override
	protected void start(){
		host = getHost();
		collider = new Rectangle(host.getX(), host.getY(), host.getWidth(), host.getHeight());
	}

	@Override
	public void run(){
		collider.setBounds(host.getX(), host.getY(), host.getWidth(), host.getHeight());
	}
}

