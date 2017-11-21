package painengine.util;

import painengine.gameobject.Sprite;

import java.awt.image.BufferedImage;

public class Tile extends Sprite{

    private boolean solid = false;

    public Tile(BufferedImage image){
        super(image);
    }

    public Tile(Tile tile){
        super(tile.getImage());
        this.solid = tile.getSolid();
    }

    public boolean getSolid(){return this.solid;}
    public void setSolid(boolean solid) {this.solid = solid;}

}