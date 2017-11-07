package demo;

import painengine.gameobject.GameObject;

import java.awt.event.KeyEvent;

public class Player extends GameObject{

    private int speed = 5;

    public Player(int x, int y, int width, int height){
        super(x, y, width, height);
        setImage("demo/assets/Gaston.png");
        startListening();
    }

    @Override
    public void update(){
        move();
    }

    private void move(){
        if(isKeyPressed(KeyEvent.VK_A)) setX(getX() - speed);
        else if (isKeyPressed(KeyEvent.VK_D)) setX(getX() + speed);
        else if (isKeyPressed(KeyEvent.VK_W)) setY(getY() - speed);
        else if (isKeyPressed(KeyEvent.VK_S)) setY(getY() + speed);
    }
}