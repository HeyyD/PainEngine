package painengine.launch;
import painengine.Screen;
import java.awt.Component;

/**
	Game class is responsible of running the game. It draws
	the content of Screen. To utilize Game class user simply
	extends it from desired class.
 */

public abstract class Game extends Component{

    private static Screen screen;

    public Game(){
        setScreen(new Screen());
        init();
        start(screen);
    }

    public void setScreen(Screen screen){
        this.screen = screen;
    }

    public static Screen getScreen(){
        return screen;
    }

    public void init(){}
    public void stop(){}
    public abstract void start(Screen screen);

}