package painengine;

/**
	Game class is responsible of running the game. It draws
	the content of Screen
 */

public abstract class Game
{

	public Game(){
		super();
	}

	public abstract void start(Screen screen);

}

