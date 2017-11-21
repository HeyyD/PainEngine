package painengine.util;

import java.awt.image.BufferedImage;

public class TileSet{

    private Tile[] tiles;

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

        System.out.println(array.length);
        return array;
    }

    public Tile[] getTiles() {return this.tiles;}

}