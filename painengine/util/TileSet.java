package painengine.util;

import java.awt.image.BufferedImage;

/**
    Set of tiles that are created accoding to a
    SpriteSheet.
 */
public class TileSet{

    private Tile[] tiles;

    /**
        Creates array of tiles accoding to the SpriteSheet.
        All the tiles are not solid by default.

        @param spriteSheet SpriteSheet that the set is build from
     */
    public TileSet(SpriteSheet spriteSheet){
        tiles = arrayTransform(spriteSheet.getSprites());
    }

    private Tile[] arrayTransform(BufferedImage[][] imageArray){

        Tile[] array = new Tile[imageArray.length * imageArray[0].length];

        int index = 0;

        for(int i = 0; i < imageArray.length; i++){
            for(int j = 0; j < imageArray[i].length; j++){
                array[index] = new Tile(imageArray[i][j]);
                index++;
            }
        }

        return array;
    }

    /**
        @return Tiles of this TileSet
     */
    public Tile[] getTiles() {return this.tiles;}

}