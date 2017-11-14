package demo;
import painengine.Game;
import painengine.Screen;
import painengine.gameobject.Sprite;
import painengine.gameobject.GameObject;


public class MyGame extends Game{

    private Player player;
    private Enemy enemy;

    private DemoStage demoStage;

    @Override
    public void init(){
        player = new Player(50, 50, 100, 200);
        enemy = new Enemy(500, 500, 50, 50);
    }

    public void start(Screen screen){
        screen.getStage().addGameObject(player);
        player.startListening(screen);

        screen.getStage().addGameObject(enemy);
    }
}