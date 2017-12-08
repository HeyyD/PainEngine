package shooter_demo;

import painengine.Stage;
import painengine.gameobject.GameObject;

public class MovingBackground{

    private Piece[] pieces = new Piece[3];

    private Piece lastPiece;
    private int maxPos;

    public MovingBackground(Stage host){

        maxPos = host.getCanvas().getHeight();

        for(int i = 0; i < pieces.length; i++){
            Piece p = new Piece("shooter_demo/assets/space.jpg");
            host.addGameObject(p);
            p.setSize((int) (p.getWidth() * 1.5f), (int) (p.getHeight() * 1.5f));
            p.setPos(0, maxPos - (p.getHeight() * i));
            pieces[i] = p;
        }

        lastPiece = pieces[pieces.length - 1];
    }
    class Piece extends GameObject{

        private float speed = 1.5f;

        public Piece(String imagePath){
            super(imagePath);
        }

        @Override
        public void update(){
            this.setY(getY() + speed);

            if(getY() >= maxPos){
                this.setY(lastPiece.getY() - this.getHeight());
                lastPiece = this;
            }
        }
    }
}