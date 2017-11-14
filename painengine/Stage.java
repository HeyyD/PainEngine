package painengine;

import painengine.gameobject.GameObject;

import java.util.List;
import java.util.LinkedList;
/**
    Stage contains canvas and all the needed information
    for the gameObjects. Stages can be used for example
    when switching levels.
*/

public class Stage{
    private Canvas canvas;
    private List<GameObject> gameObjects = new LinkedList<>();

    public Stage(Canvas canvas){
        this.canvas = canvas;
    }

    public void addGameObject(GameObject o){
        gameObjects.add(o);
        getCanvas().addSprite(o);
    }

    public void setCanvas(Canvas canvas) {this.canvas = canvas;}
    public Canvas getCanvas() {return this.canvas;}
    public List<GameObject> getGameObjects(){return this.gameObjects;}
}