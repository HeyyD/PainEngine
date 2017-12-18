package shooter_demo;

import painengine.Game;
import painengine.gameobject.GameObject;
import painengine.component.Collider;
import painengine.Stage;

import java.util.List;
import java.util.ArrayList;

import java.awt.Rectangle;

public class Enemy extends GameObject{

    private Player player;
    private Stage stage;
    private float speed = 5;
    private int width = 75;
    private int height = 75;
    private Collider collider = new Collider();

    public Enemy(String sprite, int x, int y){
        super(sprite);
        setPos(x, y);
        setSize(width, height);
        addComponent(collider);
    }

    @Override
    public void update(){
        setY(getY() + speed);

        if(getY() > Main.SCREEN_HEIGHT || bulletHit()){
            stage.removeGameObject(this);
        }

        if(collider.getRectangle().intersects(player.getCollider().getRectangle())){
            Game.RUN = false;
        }
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }

    public void setPlayer(Player player) {this.player = player;}

    private boolean bulletHit(){

        List<Rectangle> rectangles = new ArrayList<>();

        for(int i = 0; i < player.getBullets().size(); i++){
            rectangles.add(player.getBullets().get(i).getCollider().getRectangle());
        }

        return collider.collides(rectangles);
    }

}