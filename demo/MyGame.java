package demo;
import painengine.Game;
import painengine.Screen;
import painengine.Stage;
import painengine.Canvas;
import painengine.gameobject.Sprite;
import painengine.gameobject.GameObject;


public class MyGame extends Game{

    private Stage demoStage;

    @Override
    public void init(){
        demoStage = new DemoStage(new Canvas(600, 600), getScreen());
    }

    public void start(Screen screen){
        screen.setStage(demoStage);
    }
}