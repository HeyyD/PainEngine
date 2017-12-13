package shooter_demo;

import painengine.Game;

public class Main{

    public static final int SCREEN_WIDTH = 600;
    public static final int SCREEN_HEIGHT = 800;

    public static void main(String... args){
        SpaceShooter game = new SpaceShooter("Space Shooter", SCREEN_WIDTH, SCREEN_HEIGHT);
        game.start();
    }
}