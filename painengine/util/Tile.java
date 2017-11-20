package painengine.util;

import painengine.gameobject.Sprite;

import java.awt.image.BufferedImage;

public class Tile extends Sprite{

    private boolean solid;

    public Tile(BufferedImage image){
        super(image);
    }

    public boolean getSolid(){return this.solid;}
    public void setSolid(boolean solid) {this.solid = solid;}

}