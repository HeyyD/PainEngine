package painengine.gameobject;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.awt.image.BufferedImage;

abstract class Controllable extends Sprite implements KeyListener{

    protected Controllable(){
        super();
    }
    
    protected Controllable(BufferedImage image){
        super(image);
    }

    protected Controllable(int x, int y, int width, int height){
        super(x,y,width,height);
    }

    private boolean[] keys = new boolean[256];
 
    @Override
    public void keyPressed(KeyEvent event){
        keys[event.getKeyCode()] = true;
    }
 
    @Override
    public void keyTyped(KeyEvent event){
       
    }
 
    @Override
    public void keyReleased(KeyEvent event){
        keys[event.getKeyCode()] = false;  
    }
 
    public boolean isKeyPressed(int key){
        return keys[key];
    }
 
    public boolean isKeyReleased(int key){
        return !keys[key];
    }

}