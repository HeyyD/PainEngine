package painengine.component;

import painengine.util.SpriteSheet;

import java.util.HashMap;
import java.util.Map;

public class Animator extends GameComponent
{	
	private SpriteSheet spriteSheet;
	private Map<String, Animation> animations = new HashMap<>();
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

	public void removeAnimation(String name){
		animations.remove(name);
	}

	public void addAnimation(String name, Animation animation){
		animation.setHost(getHost());
		animations.put(name, animation);
	}

	public void addAnimation(String name, int firstFrame, int lastFrame){

		try{
			Animation a = new Animation(spriteSheet);
			a.setHost(getHost());
			a.setFrames(firstFrame, lastFrame);
			animations.put(name, a);
		}catch(NullPointerException e){
			e.printStackTrace();
		}

	}

	public Animation get(String name){
		return animations.get(name);
	}

	public void play(String name){
		currentAnimation = animations.get(name);
	}
}

