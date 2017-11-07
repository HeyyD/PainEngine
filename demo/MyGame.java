package demo;
import painengine.Game;
import painengine.Screen;
import painengine.gameobject.Sprite;
import painengine.gameobject.GameObject;
import java.awt.Image;


public class MyGame extends Game{

    @Override
    public void start(Screen screen){
        Player player = new Player(50, 50, 100, 200);
        screen.getCanvas().addSprite(player);
    }
}