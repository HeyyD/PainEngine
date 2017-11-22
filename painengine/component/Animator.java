package painengine.component;

import painengine.util.SpriteSheet;

import java.util.LinkedList;
import java.util.List;

public class Animator extends GameComponent
{	
	private SpriteSheet spriteSheet;
	private List<Animation> animations = new LinkedList<>();
	private Animation currentAnimation = null;

	public Animator(){

	}

	public Animator(SpriteSheet spriteSheet){
		this.spriteSheet = spriteSheet;
	}

	@Override
	public void run(){
		if(currentAnimation != null){
			currentAnimation.run();
		}
	}

	public void addAnimation(Animation animation){
		animation.setHost(getHost());
		animations.add(animation);
	}

	public void addAnimation(int firstFrame, int lastFrame){

		try{
			Animation a = new Animation(spriteSheet);
			a.setHost(getHost());
			a.setFrames(firstFrame, lastFrame);
			animations.add(a);
		}catch(NullPointerException e){
			e.printStackTrace();
		}

	}

	public void play(int animation){
		currentAnimation = animations.get(animation);
	}
}

