package painengine.component;

import java.awt.Rectangle;
import java.util.List;

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
	public void remove(){

	}

	@Override
	public void run(){
		collider.setBounds(host.getX(), host.getY(), host.getWidth(), host.getHeight());
	}

	public boolean collides(List<Collider> colliders){
		for(Collider c: colliders){
			if(!c.equals(this) && collider.intersects(c.getRectangle()))
				return true;
		}
		return false;
	}

	public Rectangle getRectangle(){
		return this.collider;
	}
}

