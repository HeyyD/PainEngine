package demo;

import painengine.gameobject.GameObject;
import painengine.component.Collider;

import java.awt.event.KeyEvent;

public class Player extends GameObject{

    private int speed = 5;
    private Collider collider;

    public Player(int x, int y, int width, int height){
        super(x, y, width, height);
    }

    @Override
    public void start(){
        setImage("demo/assets/Gaston.png");
        startListening();
        collider = new Collider();
        addComponent(collider);
    }

    @Override
    public void update(){
        move();

        if(collider.collides())
            System.out.println("ouch");
    }

    private void move(){
        if(isKeyPressed(KeyEvent.VK_A)) setX(getX() - speed);
        else if (isKeyPressed(KeyEvent.VK_D)) setX(getX() + speed);
        else if (isKeyPressed(KeyEvent.VK_W)) setY(getY() - speed);
        else if (isKeyPressed(KeyEvent.VK_S)) setY(getY() + speed);
    }
}