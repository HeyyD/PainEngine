package painengine.component;

import painengine.gameobject.GameObject;
/**

 */
public abstract class GameComponent {

    private GameObject host = null;

    public void init(GameObject host){
        this.host = host;
        start();
    }

    public void remove(){}
    
    protected void start(){}

    public void run(){

    }

    public GameObject getHost(){return this.host;}
}

