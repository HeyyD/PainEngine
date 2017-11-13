package painengine;
import painengine.Screen;
import painengine.gameobject.GameObject;
import painengine.component.GameComponent;

/**
	Game class is responsible of running the game. It draws
	the content of Screen. To utilize Game class user simply
	extends it from desired class.
 */

public abstract class Game{

    private Screen screen;

    public Game(){
        setScreen(new Screen());
        init();
        start(screen);
        gameLoop();
    }

    private void gameLoop(){
        Thread t = new Thread(() -> {
            while(true){
                for(GameObject go: screen.getCanvas().getGameObjects()){
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

    public void setScreen(Screen screen){
        this.screen = screen;
    }

    public Screen getScreen(){
        return screen;
    }

    public void init(){}
    public void stop(){}
    public abstract void start(Screen screen);

}