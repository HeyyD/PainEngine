package painengine.util;

import java.util.List;
import java.util.LinkedList;

public class TileSet{

    private List<Tile> tiles = new LinkedList<>();

    public TileSet(SpriteSheet spriteSheet){
        
    }

    public List<Tile> getTiles() {return this.tiles;}

}