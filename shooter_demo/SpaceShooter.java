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
        spawnEnemy();
    }

    private void spawnEnemy(){
        Thread t = new Thread (() -> {
            while(true){

                int x = random(0, Main.SCREEN_WIDTH);

                Enemy enemy = new Enemy("shooter_demo/assets/alien.png", x, 0);
                enemy.setStage(getScreen().getStage());
                enemy.setPlayer(player);
                getScreen().getStage().addGameObject(enemy);

                try{
                    Thread.sleep(2000);
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }

        });
        t.start();
    }

    private int random(int min, int max){
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }
}