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
    private Animation left = new Animation(spriteSheet);
    private Animation right = new Animation(spriteSheet);
    private Animation up = new Animation(spriteSheet);
    private Animation down = new Animation(spriteSheet);
    private Animator anim = new Animator();

    public Player(BufferedImage image, int x, int y){
        super(image, x, y);

        addComponent(collider);
        addComponent(anim);

        left.setFrames(0, 8);
        anim.addAnimation(left);
        right.setFrames(9, 16);
        anim.addAnimation(right);
        up.setFrames(16, 24);
        anim.addAnimation(up);
        down.setFrames(24, 32);
        anim.addAnimation(down);
        anim.play(0);
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
            setX(getX() - speed); anim.play(0);
        }
        else if (isKeyPressed(KeyEvent.VK_D)){
             setX(getX() + speed); anim.play(1);
        }
        else if (isKeyPressed(KeyEvent.VK_W)){
             setY(getY() - speed); anim.play(2);
        }
        else if (isKeyPressed(KeyEvent.VK_S)){
             setY(getY() + speed); anim.play(3);
        }
    }

    public void setWalls(List<Rectangle> walls) {this.walls = walls;}

}