package demo;

import painengine.Stage;
import painengine.Canvas;
import painengine.Screen;

import java.awt.Color;

public class DemoStage extends Stage{

    private Player player = new Player(50, 50, 100, 200);
    private Enemy enemy = new Enemy(500, 500, 50, 50);

    public DemoStage(Canvas canvas, Screen host){
        super(canvas);
        canvas.setBackground(Color.BLUE);
        player.startListening(host);
        addGameObject(player);
        addGameObject(enemy);
    }
}