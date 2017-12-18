package shooter_demo;

import painengine.gameobject.GameObject;
import painengine.component.Collider;
import painengine.Stage;

public class Enemy extends GameObject{

    private Stage stage;
    private float speed = 5;
    private int width = 50;
    private int height = 50;
    private Collider collider = new Collider();

    public Enemy(String sprite, int x, int y){
        super(sprite);
        setPos(x, y);
        setSize(width, height);
    }

    @Override
    public void update(){
        setY(getY() + speed);

        if(getY() > Main.SCREEN_HEIGHT){
            System.out.println("here");
            stage.removeGameObject(this);
        }
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }

}