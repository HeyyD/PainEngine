package demo;
import painengine.Game;
import painengine.Screen;
import painengine.gameobject.Sprite;
import painengine.gameobject.GameObject;


public class MyGame extends Game{

    private Player player;

    @Override
    public void init(){
        player = new Player(50, 50, 100, 200);
    }

    public void start(Screen screen){
        screen.getStage().getCanvas().addSprite(player);
        player.startListening(screen);

        Enemy enemy = new Enemy(500, 500, 50, 50);
        screen.getStage().getCanvas().addSprite(enemy);

        Enemy enemy2 = new Enemy(300, 300, 50, 50);
        screen.getStage().getCanvas().addSprite(enemy2);
    }
}