package demo;

import painengine.gameobject.GameObject;
import painengine.component.Collider;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;

import java.util.List;
import java.util.LinkedList;

public class Player extends GameObject{

    public List<Rectangle> enemyColliders = new LinkedList<>();
    public List<Rectangle> walls;

    private int speed = 5;
    private Collider collider;

    public Player(BufferedImage image, int x, int y){
        super(image, x, y);
    }

    @Override
    public void start(){
        collider = new Collider();
        addComponent(collider);
    }

    @Override
    public void update(){
        move();

        if(collider.collides(enemyColliders))
            System.out.println("ouch");
        if(collider.collides(walls))
            System.out.println("wall");
    }

    private void move(){
        if(isKeyPressed(KeyEvent.VK_A)) setX(getX() - speed);
        else if (isKeyPressed(KeyEvent.VK_D)) setX(getX() + speed);
        else if (isKeyPressed(KeyEvent.VK_W)) setY(getY() - speed);
        else if (isKeyPressed(KeyEvent.VK_S)) setY(getY() + speed);
    }

    public void setWalls(List<Rectangle> walls) {this.walls = walls;}

}