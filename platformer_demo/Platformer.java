package platformer_demo;

import painengine.Game;
import painengine.util.SpriteSheet;
import painengine.util.TileMap;
import painengine.util.TileSet;

public class Platformer extends Game{

    private SpriteSheet tileSheet = new SpriteSheet("platformer_demo/assets/tiles.png", 8, 8);
    private TileSet tileSet = new TileSet(tileSheet);

    private int[][] map = new int[][] {{4, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 4},
                                        {4, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 4},
                                        {4, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 4},
                                        {4, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 4},
                                        {4, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 4},
                                        {4, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 4},
                                        {4, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 4},
                                        {4, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 4},                                       
                                        {4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4}};

    private TileMap tileMap;

    public Platformer(String name, int width, int height){
        super(name, width, height);
    }

    @Override
    public void init(){
        tileSet.getTiles()[4].setSolid(true);
        tileSet.getTiles()[0].setSolid(true);
        tileMap = new TileMap(tileSet, map);
        getScreen().getStage().getCanvas().setTilemap(tileMap);
    }

}