package painengine;
import painengine.Screen;
import painengine.gameobject.GameObject;
import painengine.component.GameComponent;

/**
	Game class is responsible of running the game. It draws
	the content of Screen. To utilize Game class user simply
	extends it from desired class.
 */

public class Game{

    private Screen screen;
    private String name;
    private int width;
    private int height;

    public Game(String name, int width, int height){
        this.name = name;
        this.width = width;
        this.height = height;
    }

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

    public void setScreen(Screen screen){
        this.screen = screen;
    }

    public Screen getScreen(){
        return screen;
    }

    public void init(){}
    public void stop(){}

    public void start(){
        setScreen(new Screen(name, width, height));
        gameLoop();
    }

}