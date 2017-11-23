package demo;

import painengine.util.SpriteSheet;
import painengine.gameobject.GameObject;
import painengine.component.Collider;
import painengine.component.Animation;
import painengine.component.Animator;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;

import java.util.List;
import java.util.LinkedList;

public class Player extends GameObject{

    public List<Rectangle> enemyColliders = new LinkedList<>();
    public List<Rectangle> walls;

    private int speed = 5;
    private Collider collider = new Collider();
    private SpriteSheet spriteSheet = new SpriteSheet("demo/assets/spritesheet.png", 4, 8);
    private Animator anim = new Animator(spriteSheet);

    public Player(BufferedImage image, int x, int y){
        super(image, x, y);

        addComponent(collider);
        addComponent(anim);

        anim.addAnimation("left", 0, 8);
        anim.addAnimation("right", 9, 16);
        anim.addAnimation("up", 16, 24);
        anim.addAnimation("down", 24, 32);
        
        anim.play("down");
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
        if(isKeyPressed(KeyEvent.VK_A)){
            setX(getX() - speed); anim.play("left");
        }
        else if (isKeyPressed(KeyEvent.VK_D)){
             setX(getX() + speed); anim.play("right");
        }
        else if (isKeyPressed(KeyEvent.VK_W)){
             setY(getY() - speed); anim.play("up");
        }
        else if (isKeyPressed(KeyEvent.VK_S)){
             setY(getY() + speed); anim.play("down");
        }
    }

    public void setWalls(List<Rectangle> walls) {this.walls = walls;}

}