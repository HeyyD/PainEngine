package demo;
import painengine.launch.Game;
import painengine.Screen;

public class MyGame extends Game{
    @Override
    public void start(Screen screen){
        System.out.println("start");
    }
}