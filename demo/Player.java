package demo;

import painengine.gameobject.GameObject;
import painengine.component.Collider;

import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;

public class Player extends GameObject{

    private int speed = 5;
    private Collider collider;

    public Player(BufferedImage image){
        super(image);
    }

    @Override
    public void start(){
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