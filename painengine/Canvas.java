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
	drawn to the Screen.

	@see JPanel
 */

public class Canvas extends JPanel
{
	/** Width of the canvas */
	private int width;
	/** Height of the canvas */
	private int height;

	/** Sprites that are drawn on this canvas */
	private List<Sprite> sprites = new LinkedList<>();
	/** Optional TileMap that can be drawn before sprites */
	private Optional<TileMap> tileMap = Optional.empty();

	/**
		Constructor that creates canvas.

		@param width Width of the canvas
		@param height Height of the canvas
	 */
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

	/**
		Add Sprite to be drawn to this canvas

		@param sprite Sprite to be added
	 */
	public void addSprite(Sprite sprite){
		sprites.add(sprite);
	}

	public void removeSprite(Sprite sprite){
		sprites.remove(sprite);
	}

	/**
		@param width New width of the canvas
	 */
	public void setWidth(int width){
		if(width > 0)
			this.width = width;
	}

	/**
		@return current width of this canvas
	 */
	public int getWidth() {return this.width;}

	/**
		@param height New height of this canvas
	 */
	public void setHeight(int height){
		if(height > 0)
			this.height = height;
	}

	/**
		@return current height of this canvas
	 */
	public int getHeight() {return this.height;}

	/**
		@return current TileMap
	 */
	public Optional<TileMap> getTilemap(){
		return this.tileMap;
	}

	/**
		@param tileMap New TileMap to be drawn
	 */
	public void setTilemap(TileMap tileMap) {
		this.tileMap = Optional.ofNullable(tileMap);
	}
}

