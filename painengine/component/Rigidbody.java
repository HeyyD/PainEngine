package painengine.component;

import painengine.util.Physics;

import painengine.gameobject.GameObject;

public class Rigidbody extends GameComponent
{
	private boolean useGravity = true;

	private float x;
	private float y;
	private float velocityX = 0;
	private float velocityY = 0;
	private float friction = 0.5f;
	private float gravity = 0.5f;

	public Rigidbody(){
		super();
	}

	public Rigidbody(float mass){
		super();
	}

	@Override
	public void start(){
		this.x = getHost().getX();
		this.y = getHost().getY();
	}

	@Override
	public void run(){

		if(velocityX > 0){
			velocityX -= friction;
		} else if (velocityX < 0){
			velocityX += friction;
		}

		if(useGravity){
			velocityY = getVelocityY() + gravity;
		} else{
			if(velocityY > 0){
				velocityY -= friction;
			} else if (velocityY < 0){
				velocityY += friction;
			}
		}

		x += velocityX;
		y += velocityY;

		getHost().setPos(x, y);
	}

	public void setVelocityX(float velocity) {this.velocityX = velocity;}
	public void setVelocityY(float velocity) {this.velocityY = velocity;}

	public void setVelocity(float x, float y) {
		this.velocityX = x;
		this.velocityY = y;
	}

	public float getVelocityX() {return this.velocityX;}
	public float getVelocityY() {return this.velocityY;}
	public float getFriction() {return this.friction;}

	public void setFriction(float friction) {
		if(friction >= 0)
			this.friction = friction;
	}

	public float getX() {return this.x;}
	public float getY() {return this.y;}
	public void setX(float x) {this.x = x;}
	public void setY(float y) {this.y = y;}

	public boolean useGravity() {return this.useGravity;}
	public void useGravity(boolean useGravity) {this.useGravity = useGravity;}

}

