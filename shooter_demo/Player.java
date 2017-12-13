package shooter_demo;

import painengine.Stage;
import painengine.gameobject.GameObject;
import painengine.util.SpriteSheet;
import painengine.component.Animation;

import java.awt.event.KeyEvent;

public class Player extends GameObject{

    private Stage hostStage = null;
    private float speed = 5;

    public Player(SpriteSheet sheet, int x, int y){
        super(sheet.getSprites()[0][0]);
        setPos(x, y);
        setSize((int) (getWidth() * 1.5f), (int) (getHeight() * 1.5f));

        Animation animation = new Animation(sheet);
        addComponent(animation);

    }

    @Override
    public void update(){
        move();

        if(isKeyPressed(KeyEvent.VK_SPACE)){
            shoot();
        }
    }

    private void move(){
        if(getX() > 0 && isKeyPressed(KeyEvent.VK_A)){
            setX(getX() - speed);
        }

        if(getX() < (Main.SCREEN_WIDTH - getWidth()) && isKeyPressed(KeyEvent.VK_D)){
            setX(getX() + speed);
        }
    }

    private void shoot(){
        Bullet b = new Bullet(getX() + getWidth() / 2, getY(), 10, 10, -5);
        hostStage.addGameObject(b);

    }

    public void setStage(Stage stage) {this.hostStage = stage;}
}