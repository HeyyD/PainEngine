package painengine.component;

import painengine.util.SpriteSheet;
import java.awt.image.BufferedImage;

/**
	Animation created from SpriteSheet. Can be
	used to animate GameObjects.
 */
public class Animation extends GameComponent
{	
	private boolean loop = true;
	private boolean isFinished = false;

	private SpriteSheet spriteSheet;
	private BufferedImage[] allFrames;
	private BufferedImage[] frames;
	private int currentFrame = 0;
	private int lastFrame;
	private int frameDelay = 5;
	private int frameTimer = 0;

	/**
		Create animation frames according to SpriteSheet.
	 */
	public Animation(SpriteSheet spriteSheet){
		this.spriteSheet = spriteSheet;
		frames = sheetToArray(spriteSheet);
		allFrames = frames;
		lastFrame = frames.length - 1;
	}

	/**
		If the SpriteSheet has multiple animations or dead frames,
		the user can pick the first and last frame of this animation
		from the sheet.

		@param first First frame of the animation
		@param last Last frame of the animation
	 */
	public void setFrames(int first, int last){
		int frameCount = last - first;
		BufferedImage[] temp = new BufferedImage[frameCount];

		int index = 0;

		for(int i = first; i < last; i++){
			temp[index] = this.allFrames[i];
			index++;
		}

		this.lastFrame = temp.length - 1;
		this.frames = temp;

	}

	/** Changes the current frame of the animation */
	@Override
	public void run(){

		if(!isFinished){
			if(frameTimer >= frameDelay){
				getHost().setImage(frames[currentFrame]);

				if(currentFrame < lastFrame)
					currentFrame++;
				else if(loop)
					currentFrame = 0;
				else
					isFinished = true;

				frameTimer = 0;

			} else{
				frameTimer++;
			}
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

	/**
		Set the time it takes to change a frame.

		@param delay Time it takes to change the frame
	 */
	public void setFrameDelay(int delay){
		if(delay >= 0)
			this.frameDelay = delay;
	}

	/**
		@return Time it takes to change the frame
	 */
	public int getFrameDelay(){
		return this.frameDelay;
	}

	public void setLooping(boolean loop) {this.loop = loop;}
	public boolean isFinished() { return this.isFinished;}
}

