package demo;
import painengine.Game;
import painengine.Screen;
import painengine.Stage;
import painengine.util.SpriteSheet;
import painengine.util.TileSet;
import painengine.gameobject.Sprite;

public class MyGame extends Game{

    private Player player;
    private Enemy enemy;
    private SpriteSheet playerSheet;
    private SpriteSheet tileSheet;
    private TileSet tileSet;

    @Override
    public void init(){
        playerSheet = new SpriteSheet("demo/assets/spriteSheet.png", 4, 7);
        tileSheet = new SpriteSheet("demo/assets/tilesheet.png", 4, 1);
        tileSet = new TileSet(tileSheet);
        player = new Player(playerSheet.getSprites()[0][0]);
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