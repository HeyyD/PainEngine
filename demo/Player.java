package demo;

import painengine.util.SpriteSheet;
import painengine.gameobject.GameObject;
import painengine.component.Collider;
import painengine.component.Animation;
import painengine.component.Animator;
import painengine.component.Rigidbody;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;

import java.util.List;
import java.util.LinkedList;

public class Player extends GameObject{

    public List<Rectangle> enemyColliders = new LinkedList<>();
    public List<Rectangle> walls;

    private int speed = 1;
    private Collider collider = new Collider();
    private SpriteSheet spriteSheet = new SpriteSheet("demo/assets/spritesheet.png", 4, 8);
    private Animator anim = new Animator(spriteSheet);
    private Rigidbody rb = new Rigidbody();

    public Player(BufferedImage image, int x, int y){
        super(image, x, y);

        addComponent(collider);
        addComponent(anim);
        addComponent(rb);

        anim.addAnimation("down", 24, 32);
        
        anim.play("down");
    }

    @Override
    public void update(){
        move();
    }

    private void move(){
        if(isKeyPressed(KeyEvent.VK_D)){
            rb.setVelocityX(rb.getVelocityX() + speed);
        } else if(isKeyPressed(KeyEvent.VK_A)){
            rb.setVelocityX(rb.getVelocityX() - speed);
        }
    }

    public void setWalls(List<Rectangle> walls) {this.walls = walls;}

}