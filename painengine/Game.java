package painengine;
import painengine.Screen;
import painengine.gameobject.GameObject;
import painengine.component.GameComponent;

/**
	Game class has the main loop of the program. It is used
    to update every Sprite and GameComponent in the game.
 */

public class Game{

    /** The current game window */
    private Screen screen;
    /** Name of the screen */
    private String name;
    /** Width of the screen */
    private int width;
    /** Height of the screen */
    private int height;

    /**
        @param name Name of the game
        @param width Width of the game screen
        @param height Height of the game screen
    */

    public Game(String name, int width, int height){
        this.name = name;
        this.width = width;
        this.height = height;
    }

    /**
        Creates a thread that updates the game. It goes through
        all the GameObjects of the current stage and calls their 
        update method. If the GameObject has any components, the
        loop will call every components run method.
    */
    private void gameLoop(){
        Thread t = new Thread(() -> {
            while(true){
                for(GameObject go: screen.getStage().getGameObjects()){
                    go.update();
                    for(GameComponent gc: go.getComponents()){
                        gc.run();
                    }
                }

                screen.repaint();

                try{
                    Thread.sleep(10);
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }

    /**
        @param screen The new screen for the game
    */
    public void setScreen(Screen screen){
        this.screen = screen;
    }

    /**
        @return Current screen of the game
    */
    public Screen getScreen(){
        return screen;
    }

    /**
        Init is called in start method before gameLoop starts.
        User can utilize this if they need to initialize something
        before the loop starts.
    */
    public void init(){}

    /**
        Start method creates the gameScreen, initializes the game
        and then starts the main loop.
    */
    public void start(){
        setScreen(new Screen(name, width, height));
        init();
        gameLoop();
    }

}