package demo;
import painengine.launch.Game;
import painengine.Screen;
import painengine.Sprite;
import painengine.GameObject;
import java.awt.Image;


public class MyGame extends Game{

    @Override
    public void start(Screen screen){
        GameObject go = new GameObject(10, 10, 50, 100);
        go.setImage("demo/assets/a.jpg");
        screen.getCanvas().addSprite(go);
    }
}