package shooter_demo;

import painengine.Game;

public class Main{

    public static void main(String... args){
        SpaceShooter game = new SpaceShooter("Space Shooter", 600, 800);
        game.start();
    }
}