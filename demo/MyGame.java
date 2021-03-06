package demo;
import painengine.Game;
import painengine.Screen;
import painengine.Stage;
import painengine.util.SpriteSheet;
import painengine.util.TileSet;
import painengine.util.TileMap;
import painengine.gameobject.Sprite;
import painengine.sound.SoundManager;

public class MyGame extends Game{

    private SpriteSheet playerSheet = new SpriteSheet("demo/assets/spriteSheet.png", 4, 7);
    private Player player = new Player(playerSheet.getSprites()[0][0], 100, 100);
    private Stage demoStage;
    private SpriteSheet tileSheet = new SpriteSheet("demo/assets/tilesheet.png", 5, 10);
    private TileSet tileSet = new TileSet(tileSheet);
    private TileMap tileMap;
    private SoundManager sm = new SoundManager();

    private int[][] map = new int[][]   {{20, 20, 20, 20, 20, 20, 20, 20, 20},
                                        {20, 20, 20, 20, 20, 20, 20, 20, 20},
                                        {20, 20, 20, 20, 20, 20, 20, 20, 20},
                                        {20, 20, 20, 20, 20, 20, 20, 20, 20},
                                        {20, 20, 20, 20, 20, 20, 20, 20, 20},
                                        {20, 20, 20, 20, 20, 20, 0, 20, 20},
                                        {20, 20, 20, 20, 20, 20, 20, 20, 20},
                                        {20, 20, 20, 20, 20, 20, 20, 20, 20},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0}};

    public MyGame(String name, int width, int height){
        super(name, width, height);
    }

    @Override
    public void init(){
        demoStage = new Stage(getScreen().getStage().getCanvas());
        getScreen().setStage(demoStage);

        tileSet.getTiles()[0].setSolid(true);
        tileMap = new TileMap(tileSet, map);

        player.startListening(getScreen());
        player.setWalls(tileMap.getSolidTiles());

        demoStage.getCanvas().setTilemap(tileMap);
        demoStage.addGameObject(player);

        sm.setMusic("demo/assets/music.wav");
        sm.startMusic();
    }
}