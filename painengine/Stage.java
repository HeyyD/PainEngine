package painengine;

import painengine.gameobject.GameObject;
import painengine.gameobject.Sprite;

import java.util.List;
import java.util.LinkedList;

/**
    Stage contains canvas and a List of
    all the GameObjects in the current stage. 
    Stages can be used for example
    when switching levels. The main game loop updates
    every GameObject that the current stage has.
*/

public class Stage{
    
    /** Current canvas that is drawn */
    private Canvas canvas;
    /** GameObjects that this Stage has */
    private List<GameObject> gameObjects = new LinkedList<>();

    /**
        Constructor that sets the canvas
        @param canvas Canvas to be drawn
     */
    public Stage(Canvas canvas){
        this.canvas = canvas;
    }

    /**
        Add GameObject to the gameObjects list. Also
        adds the GameObjects to canvas's sprites list
        so that it can be drawn.

        @param o GameObject to be added
     */
    public void addGameObject(GameObject o){
        gameObjects.add(o);
        getCanvas().addSprite(o);
    }

    /**
        Add sprite to canvas so that it can be drawn.

        @param s Sprite to be added
     */
    public void addSprite(Sprite s){
        getCanvas().addSprite(s);
    }

    /**
        @param canvas New canvas for of this Stage
     */
    public void setCanvas(Canvas canvas) {this.canvas = canvas;}
    /**
        @return Current canvas of this stage
     */
    public Canvas getCanvas() {return this.canvas;}
    /**
        @return List of GameObjects of the Stage
     */
    public List<GameObject> getGameObjects(){return this.gameObjects;}
}