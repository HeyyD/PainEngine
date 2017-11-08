package painengine;

import painengine.gameobject.Sprite;
import painengine.gameobject.GameObject;

import javax.swing.JPanel;
import java.util.LinkedList;
import java.util.List;
import java.awt.Graphics;

/**
	Canvas contains all the Sprites and gameobjects that are
	drawn to the Screen. It can extend outside of the screen.
	Canvas can contain multiple CanvasLayers that can be
	drawn on top of eachother.
 */

public class Canvas extends JPanel
{

	private int width;
	private int height;

	private List<Sprite> sprites = new LinkedList<>();
	private List<GameObject> gameObjects = new LinkedList<>();

	public Canvas(int width, int height){
		setWidth(width);
		setHeight(height);
	}

	public void drawCanvas(){
		
	}

	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		for(Sprite s: sprites)
			s.draw(g);
	}

	public void addSprite(Sprite sprite){
		sprites.add(sprite);
		if(sprite instanceof GameObject){
			GameObject go = (GameObject) sprite;
			gameObjects.add(go);
		}
	}

	public void setWidth(int width){
		if(width > 0)
			this.width = width;
	}

	public int getWidth() {return this.width;}

	public void setHeight(int height){
		if(height > 0)
			this.height = height;
	}

	public int getHeight() {return this.height;}

	public List<GameObject> getGameObjects(){return this.gameObjects;}
}
