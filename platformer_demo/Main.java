package platformer_demo;

import painengine.Game;

public class Main{

    public static int SCREEN_WIDTH = 837;
    public static int SCREEN_HEIGHT = 600;

    public static void main(String... args){
        Platformer game = new Platformer("Platformer", SCREEN_WIDTH, SCREEN_HEIGHT);
        game.start();
    }
}