package demo;
import painengine.launch.Game;
import painengine.Screen;
import painengine.Sprite;
import painengine.GameObject;


public class MyGame extends Game{

    @Override
    public void start(Screen screen){
        screen.getCanvas().addSprite(new GameObject());
    }
}