package painengine.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
	SpriteSheet class divides a image into columns and rows
	and creates array of images that can be utilized in
	animations and TileMaps.
 */

public class SpriteSheet
{

	private BufferedImage spriteSheet;
	private BufferedImage[][] sprites;
	private int rows;
	private int columns;

	public SpriteSheet(String path, int rows, int columns){
		try{
			spriteSheet = ImageIO.read(new File(path));
		} catch(IOException e){
			e.printStackTrace();
		}

		this.rows = rows;
		this.columns = columns;

		sprites = splitSheet();
	}

	private BufferedImage[][] splitSheet(){
		return null;
	}

}

