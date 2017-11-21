package painengine.util;

import painengine.gameobject.Sprite;

import java.awt.image.BufferedImage;

/**
    Tile class is used to build TileMaps.
    @see Sprite
 */
public class Tile extends Sprite{

    private boolean solid = false;

    /**
        Creates the sprite to be drawn.

        @param image Graphic of the tile
     */
    public Tile(BufferedImage image){
        super(image);
    }

    /**
        Create copy of the tile. This tile will get 
        the graphic of the original tile and the value
        of the solid boolean.

        @param tile Tile to be copied.
     */
    public Tile(Tile tile){
        super(tile.getImage());
        this.solid = tile.getSolid();
    }

    /**
        @return value of the solid boolean
     */
    public boolean getSolid(){return this.solid;}

    /**
        @param solid value of the solid boolean to be set
     */
    public void setSolid(boolean solid) {this.solid = solid;}

}