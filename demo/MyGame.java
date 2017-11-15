package demo;
import painengine.Game;
import painengine.Screen;
import painengine.gameobject.Sprite;
import painengine.util.SpriteSheet;

public class MyGame extends Game{

    private SpriteSheet spriteSheet;
    private Sprite sprite;

    @Override
    public void init(){
        spriteSheet = new SpriteSheet("demo/assets/spriteSheet.png", 4, 7);
        sprite = new Sprite(spriteSheet.getSprites()[0][0]);
    }

    @Override
    public void start(Screen screen){
        screen.getStage().addSprite(sprite);
    }
}