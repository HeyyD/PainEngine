package painengine;

/**
    Stage contains canvas and all the needed information
    for the gameObjects. Stages can be used for example
    when switching levels.
 */
public class Stage{

    private Canvas canvas;

    public Stage(){

    }

    public Stage(Canvas canvas){
        this.canvas = canvas;
    }

    public void setCanvas(Canvas canvas){
        this.canvas = canvas;
    }

    public Canvas getCanvas(){
        return this.canvas;
    }

}