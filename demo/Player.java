package demo;

import painengine.util.SpriteSheet;
import painengine.gameobject.GameObject;
import painengine.component.Collider;
import painengine.component.Animation;
import painengine.component.Animator;
import painengine.component.Rigidbody;
import painengine.sound.SoundManager;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;

import java.util.List;
import java.util.LinkedList;

public class Player extends GameObject{

    public List<Rectangle> enemyColliders = new LinkedList<>();
    public List<Rectangle> walls;

    private boolean grounded = false;

    private int speed = 1;
    private float jumpForce = -10;
    private Collider collider = new Collider();
    private SpriteSheet spriteSheet = new SpriteSheet("demo/assets/spritesheet.png", 4, 8);
    private Animator anim = new Animator(spriteSheet);
    private Rigidbody rb = new Rigidbody();
    private SoundManager sm = new SoundManager();

    public Player(BufferedImage image, int x, int y){
        super(image, x, y);
        addComponent(collider);
        addComponent(anim);
        addComponent(rb);

        anim.addAnimation("left", 1, 8);
        anim.addAnimation("right", 9, 16);
        anim.addAnimation("down", 24, 32);
        
        anim.play("down");
    }

    @Override
    public void update(){
        rb.useGravity(!grounded);
        move();
    }

    private void move(){

        if(collider.bottomCollides(walls)){
            grounded = true;
            rb.setVelocityY(0);
        }

        if(collider.topCollides(walls)){
            rb.setVelocityY(0);
        }

        if(isKeyPressed(KeyEvent.VK_D)){
            rb.setVelocityX(rb.getVelocityX() + speed); anim.play("right");
        } else if(isKeyPressed(KeyEvent.VK_A)){
            rb.setVelocityX(rb.getVelocityX() - speed); anim.play("left");
        }

        if(isKeyPressed(KeyEvent.VK_SPACE)){
            if(grounded){
                rb.setVelocityY(jumpForce);
                sm.playSound("demo/assets/jump.wav");
                grounded = false;
            }
        }
    }

    public void setWalls(List<Rectangle> walls) {this.walls = walls;}

}