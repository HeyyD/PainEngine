package painengine.component;

import java.awt.Rectangle;

import java.util.List;
import java.util.Optional;

import painengine.gameobject.GameObject;
/**
	Collider component. Uses Rectangles to detect if the
	GameObject collides with anything. Extends GameComponent.

	@see GameComponent
 */

public class Collider extends GameComponent
{
	private Optional<CollisionDetection> detection = Optional.empty();
	private Rectangle collider;
	private GameObject host;

	@Override
	protected void start(){
		host = getHost();
		collider = new Rectangle(host.getX(), host.getY(), host.getWidth(), host.getHeight());
	}



	/** Updates the position of the rectangle */
	@Override
	public void run(){
		collider.setBounds(host.getX(), host.getY(), host.getWidth(), host.getHeight());
		detection.ifPresent(d -> d.updatePosition());
	}

	public void checkCollision(){
		detection = Optional.of(new CollisionDetection(getHost()));
	}

	/**
		Returns true if this collider collides with any rectangle
		given to it.

		@param colliders Rectangles that this can collide with
		@return if hits any of the colliders
	 */
	public boolean collides(List<Rectangle> colliders){
		for(Rectangle r: colliders){
			if(!r.equals(this.collider) && collider.intersects(r))
				return true;
		}
		return false;
	}

	public Rectangle collidesWith(List<Rectangle> colliders){
		for(Rectangle r: colliders){
			if(!r.equals(this.collider) && collider.intersects(r))
				return r;
		}
		return null;
	}

	/**
		@return java.awt.Rectangle of this Colllider
	 */
	public Rectangle getRectangle(){
		return this.collider;
	}
}

