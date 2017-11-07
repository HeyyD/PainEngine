package demo;
import painengine.Game;
import painengine.Screen;
import painengine.gameobject.Sprite;
import painengine.gameobject.GameObject;
import painengine.component.Collider;


public class MyGame extends Game{

    @Override
    public void start(Screen screen){

        Collider collider = new Collider();

        Player player = new Player(50, 50, 100, 200);
        screen.getCanvas().addSprite(player);
        player.addComponent(collider);

        GameObject enemy = new GameObject(300,300,50,50);
        screen.getCanvas().addSprite(enemy);
        enemy.addComponent(collider);
    }
}