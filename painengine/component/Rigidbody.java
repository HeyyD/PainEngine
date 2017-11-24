package painengine.component;

import painengine.util.Physics;

import painengine.gameobject.GameObject;

public class Rigidbody extends GameComponent
{

	private GameObject host;
	private Physics physics = new Physics();

	private int velocityX = 0;
	private int velocityY = 0;
	private int mass = 5;

	public Rigidbody(){
		super();
	}

	public Rigidbody(int mass){
		super();
	}

	@Override
	public void run(){
		getHost().setX(getHost().getX() + velocityX);
		getHost().setY(getHost().getY() + velocityY);
	}

	public void setVelocityX(int velocity) {this.velocityX = velocity;}
	public void setVelocityY(int velocity) {this.velocityY = velocity;}

	public void setVelocity(int x, int y) {
		this.velocityX = x;
		this.velocityY = y;
	}

	public int getVelocityX() {return this.velocityX;}
	public int getVelocityY() {return this.velocityY;}

}

