package painengine.component;

import painengine.util.Physics;

import painengine.gameobject.GameObject;

public class Rigidbody extends GameComponent
{
	private GameObject host;

	private float velocityX = 0;
	private float velocityY = 0;
	private float gravity = 0.1f;

	public Rigidbody(){
		super();
	}

	public Rigidbody(float mass){
		super();
	}

	@Override
	public void run(){

		velocityY = getVelocityY() + gravity;

		getHost().setX(getHost().getX() + velocityX);
		getHost().setY(getHost().getY() + velocityY);
	}

	public void setVelocityX(float velocity) {this.velocityX = velocity;}
	public void setVelocityY(float velocity) {this.velocityY = velocity;}

	public void setVelocity(float x, float y) {
		this.velocityX = x;
		this.velocityY = y;
	}

	public float getVelocityX() {return this.velocityX;}
	public float getVelocityY() {return this.velocityY;}

}

