package demo;
import painengine.Game;
import painengine.Screen;
import painengine.Stage;
import painengine.util.SpriteSheet;
import painengine.util.TileSet;
import painengine.util.TileMap;
import painengine.gameobject.Sprite;

public class MyGame extends Game{

    private Player player;
    private Enemy enemy;
    private SpriteSheet playerSheet;
    private SpriteSheet tileSheet;
    private TileSet tileSet;
    private TileMap tileMap;
    private int[][] map;

    @Override
    public void init(){
        playerSheet = new SpriteSheet("demo/assets/spriteSheet.png", 4, 7);
        tileSheet = new SpriteSheet("demo/assets/tilesheet.png", 5, 10);
        tileSet = new TileSet(tileSheet);

        map = new int[][]   {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 20, 20, 20, 20, 20, 20, 20, 0},
                            {0, 20, 20, 20, 20, 20, 20, 20, 0},
                            {0, 20, 20, 20, 20, 20, 20, 20, 0},
                            {0, 20, 20, 20, 20, 20, 20, 20, 0},
                            {0, 20, 20, 20, 20, 20, 20, 20, 0},
                            {0, 20, 20, 20, 20, 20, 20, 20, 0},
                            {0, 20, 20, 20, 20, 20, 20, 20, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0}};

        tileMap = new TileMap(tileSet, map);

        player = new Player(playerSheet.getSprites()[0][0]);
        enemy = new Enemy(300, 300, 50, 50);
    }

    @Override
    public void start(Screen screen){
        screen.getStage().getCanvas().setTilemap(tileMap);
        screen.getStage().addGameObject(player);
        player.startListening(screen);
        screen.getStage().addGameObject(enemy);
        player.enemyColliders.add(enemy.getCollider());
    }
}