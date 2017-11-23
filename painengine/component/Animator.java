package painengine.component;

import painengine.util.SpriteSheet;

import java.util.HashMap;
import java.util.Map;


/**
	Animator in used to manage many Animations. User can
	save sprite animations to to the animator and call them.
 */
public class Animator extends GameComponent
{	
	private SpriteSheet spriteSheet;
	private Map<String, Animation> animations = new HashMap<>();
	private Animation currentAnimation = null;

	public Animator(){
		super();
	}

	/**
		Constructor which sets animators SpriteSheet. Useful for example
		when creating animations for characters.

		@param spriteSheet Animators SpriteSheet
	 */
	public Animator(SpriteSheet spriteSheet){
		this.spriteSheet = spriteSheet;
	}

	/** Animate the current animation of the host */
	@Override
	public void run(){
		if(currentAnimation != null){
			currentAnimation.run();
		}
	}

	/**
		Remove a animation from animator

		@param name Name of the animation that is removed
	 */
	public void removeAnimation(String name){
		animations.remove(name);
	}

	/**
		Add animation to the animator

		@param name Name of the animation
		@param animation Animation to be added
	 */
	public void addAnimation(String name, Animation animation){
		animation.setHost(getHost());
		animations.put(name, animation);
	}

	/**
		Add animation to the animator

		@param name 		Name of the animation
		@param firstFrame 	The frame of animators SpriteSheet where the 
							animation starts.
		@param lastFrame	The frame of animators SpriteSheet where the 
							animation ends.
	 */
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

	/**
		@param name Name of the animation
		@return Animation from the key name
	 */
	public Animation get(String name){
		return animations.get(name);
	}

	/**
		Play animation of the name
		
		@param name Name of the animation that is played
	 */
	public void play(String name){
		currentAnimation = animations.get(name);
	}
}

