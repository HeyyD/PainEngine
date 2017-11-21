package painengine.component;

import painengine.util.SpriteSheet;
import java.awt.image.BufferedImage;

public class Animation extends GameComponent
{	
	private BufferedImage[] frames;
	private int currentFrame = 0;
	private int lastFrame;

	public Animation(SpriteSheet spriteSheet){
		frames = sheetToArray(spriteSheet);
		lastFrame = frames.length - 1;
	}

	@Override
	public void run(){
		getHost().setImage(frames[currentFrame]);
		if(currentFrame < lastFrame)
			currentFrame++;
		else
			currentFrame = 0;
	}

	private BufferedImage[] sheetToArray(SpriteSheet spriteSheet){

		BufferedImage[] array = new BufferedImage[spriteSheet.getRows() * spriteSheet.getColumns()];

		int index = 0;

		for(int i = 0; i < spriteSheet.getRows(); i++){
			for(int j = 0; j < spriteSheet.getColumns(); j++){
				array[index] = spriteSheet.getSprites()[i][j];
				index++;
			}
		}

		System.out.println(array.length);
		return array;
	}
}

