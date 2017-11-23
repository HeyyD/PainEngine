package painengine.component;

import painengine.gameobject.GameObject;
/**
    Base for every Component
 */
public abstract class GameComponent {

    private GameObject host = null;

    /**
        Constructor sets the host GameObject of this
        component and calls for start method.

        @param host Host GameObject of this component
     */
    public void init(GameObject host){
        this.host = host;
        start();
    }

    /** Called when this component is removed */
    public void remove(){}
    
    protected void start(){}

    /** Called in every game loop round */
    public void run(){

    }

    /**
        @return Host GameObject of this component
     */
    public GameObject getHost(){return this.host;}

    /**
        @param host new host of this component
     */
    public void setHost(GameObject host){this.host = host;}
}

