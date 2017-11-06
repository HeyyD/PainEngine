package demo;

import painengine.gameobject.GameObject;

import java.awt.event.KeyEvent;

public class Player extends GameObject{

    public Player(int x, int y, int width, int height){
        super(x, y, width, height);
        setImage("demo/assets/Gaston.png");
        startListening();
        update();
    }

    public void update(){
        Thread t = new Thread(() -> {
            while(true){
                if(isKeyPressed(KeyEvent.VK_D))
                    setX(getX() + 1);
                else if(isKeyPressed(KeyEvent.VK_A))
                    setX(getX() - 1);
                else if(isKeyPressed(KeyEvent.VK_W))
                    setY(getY() - 1);
                else if(isKeyPressed(KeyEvent.VK_S))
                    setY(getY() + 1);
                try{
                    Thread.sleep(50);
                }catch(InterruptedException e){

                }
            }
        });
        t.start();
    }

}