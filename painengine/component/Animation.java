package painengine.component;

import painengine.util.SpriteSheet;
import java.awt.image.BufferedImage;

public class Animation extends GameComponent
{	
	private BufferedImage[] frames;
	private int currentFrame = 0;
	private int lastFrame;
	private int frameDelay = 5;
	private int frameTimer = 0;

	public Animation(SpriteSheet spriteSheet){
		frames = sheetToArray(spriteSheet);
		lastFrame = frames.length - 1;
	}

	@Override
	public void run(){

		if(frameTimer >= frameDelay){
			getHost().setImage(frames[currentFrame]);

			if(currentFrame < lastFrame)
				currentFrame++;
			else
				currentFrame = 0;

			frameTimer = 0;

		} else{
			frameTimer++;
		}

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

		return array;
	}

	public void setFrameDelay(int delay){
		if(delay >= 0)
			this.frameDelay = delay;
	}

	public int getFrameDelay(){
		return this.frameDelay;
	}
}

