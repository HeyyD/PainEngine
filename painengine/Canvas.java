package painengine;

import painengine.gameobject.Sprite;
import painengine.gameobject.GameObject;
import painengine.util.TileMap;

import javax.swing.JPanel;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
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
	private Optional<TileMap> tileMap = Optional.empty();

	public Canvas(int width, int height){
		setWidth(width);
		setHeight(height);
	}

	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);

		tileMap.ifPresent(t -> t.draw(g));

		for(Sprite s: sprites)
			s.draw(g);
	}

	public void addSprite(Sprite sprite){
		sprites.add(sprite);
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

	public Optional<TileMap> getTilemap(){
		return this.tileMap;
	}

	public void setTilemap(TileMap tileMap) {
		this.tileMap = Optional.ofNullable(tileMap);
	}
}

