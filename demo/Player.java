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
    private Animation animation = new Animation(spriteSheet);
    private Animator anim = new Animator();

    public Player(BufferedImage image, int x, int y){
        super(image, x, y);

        addComponent(collider);
        addComponent(anim);

        animation.setFrames(0, 8);
        animation.setFrameDelay(3);
        anim.addAnimation(animation);
        animation.setFrames(9, 16);
        anim.addAnimation(animation);
        animation.setFrames(16, 24);
        anim.addAnimation(animation);
        animation.setFrames(24, 32);
        anim.addAnimation(animation);

        anim.play(3);
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