package demo;
import painengine.Game;
import painengine.Screen;
import painengine.Stage;
import painengine.util.SpriteSheet;
import painengine.gameobject.Sprite;

public class MyGame extends Game{

    private Player player;
    private Enemy enemy;
    private SpriteSheet spriteSheet;

    @Override
    public void init(){
        spriteSheet = new SpriteSheet("demo/assets/spriteSheet.png", 4, 7);
        player = new Player(spriteSheet.getSprites()[0][0]);
        enemy = new Enemy(300, 300, 50, 50);
    }

    @Override
    public void start(Screen screen){
        screen.getStage().addGameObject(player);
        player.startListening(screen);
        screen.getStage().addGameObject(enemy);
        player.enemyColliders.add(enemy.getCollider());
    }
}