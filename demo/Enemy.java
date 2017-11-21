package demo;

import painengine.gameobject.GameObject;
import painengine.component.Collider;

import java.awt.Rectangle;

public class Enemy extends GameObject{

    private Collider collider;

    public Enemy(int x, int y, int width, int height){
        super(x, y, width, height);
    }

    @Override
    public void start(){
        collider = new Collider();
        addComponent(collider);
    }

    @Override 
    public void update(){

    }

    public Rectangle getCollider(){
        return this.collider.getRectangle();
    }
}