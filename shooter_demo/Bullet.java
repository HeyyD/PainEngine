package shooter_demo;

import painengine.gameobject.GameObject;

public class Bullet extends GameObject{

    private float speed;

    public Bullet(int x, int y, int width, int height, float speed){
        super(x, y, width, height);
        this.speed = speed;
    }

    public Bullet(Bullet bullet){
        super(bullet.getX(), bullet.getY(), bullet.getWidth(), bullet.getHeight());
        this.speed = bullet.getSpeed();
    }

    public void update(){
        setY(getY() + speed);
    }

    public float getSpeed() {return this.speed;}
    public void setSpeed(float speed) {this.speed = speed;}
}