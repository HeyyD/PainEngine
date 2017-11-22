package painengine.component;
import java.util.LinkedList;
import java.util.List;

public class Animator extends GameComponent
{	
	private List<Animation> animations = new LinkedList<>();
	private Animation currentAnimation = null;

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

	public void play(int animation){
		currentAnimation = animations.get(animation);
	}
}

