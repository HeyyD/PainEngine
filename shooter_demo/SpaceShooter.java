package shooter_demo;

import painengine.Game;
import painengine.util.SpriteSheet;

public class SpaceShooter extends Game{

    private MovingBackground background;
    private SpriteSheet spriteSheet = new SpriteSheet("shooter_demo/assets/Player.png", 1, 4);
    private Player player = new Player(spriteSheet, 5, 625);

    public SpaceShooter(String name, int width, int height){
        super(name, width, height);
    }

    @Override
    public void init(){
        background = new MovingBackground(getScreen().getStage());
        getScreen().getStage().addGameObject(player);
        player.setStage(getScreen().getStage());
        player.startListening(getScreen());
    }
}