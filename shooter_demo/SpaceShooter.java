package shooter_demo;

import painengine.Game;

public class SpaceShooter extends Game{

    private MovingBackground background;

    public SpaceShooter(String name, int width, int height){
        super(name, width, height);
    }

    @Override
    public void init(){
        background = new MovingBackground(getScreen().getStage());   
    }
}