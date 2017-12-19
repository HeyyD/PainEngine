package platformer_demo;

import painengine.gameobject.GameObject;
import painengine.util.SpriteSheet;
import painengine.sound.SoundManager;
import painengine.component.Collider;
import painengine.component.Animator;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import java.util.List;

public class Player extends GameObject{

    private float gravity = 0.5f;
    private float velocityY = 0;
    private float speed = 5;
    private boolean grounded = false;
    private Collider collider = new Collider();
    private List<Rectangle> walls;
    private SpriteSheet spriteSheet = new SpriteSheet("demo/assets/spritesheet.png", 4, 8);
    private Animator anim = new Animator(spriteSheet);
    private SoundManager sm = new SoundManager();

    public Player(int x, int y, int width, int height){
        super(x, y, width, height);
        setImage(spriteSheet.getSprites()[0][0]);
        addComponent(collider);
        addComponent(anim);

        anim.addAnimation("left", 1, 8);
        anim.addAnimation("right", 9, 16);
        anim.addAnimation("down", 24, 32);
        
        anim.play("down");
    }

    @Override
    public void update(){

        if(!grounded){
            velocityY += gravity;
        }

        move();
    }

    private void move(){
        if(!collider.leftCollides(walls) && isKeyPressed(KeyEvent.VK_A)){
            setX(getX() - speed); anim.play("left");
        }

        else if(!collider.rightCollides(walls) && isKeyPressed(KeyEvent.VK_D)){
            setX(getX() + speed); anim.play("right");
        }

        else if(collider.topCollides(walls)){
            velocityY = 0;
            setY((float) collider.collidesWith(walls).getY() + getHeight() + 1);
        }

        if(grounded && isKeyPressed(KeyEvent.VK_SPACE)){
            velocityY = -10;
            grounded = false;
            sm.playSound("demo/assets/jump.wav");
        }

        if(!grounded){
            float oldPos = getY();
            setY(getY() + velocityY);
            if(collider.bottomCollides(walls)){
                grounded = true;
                setY((float) collider.collidesWith(walls).getY() - getHeight() - 1);
                velocityY = 0;
            }
        }
    }

    public void setWalls(List<Rectangle> walls) {this.walls = walls;}

}