package painengine.gameobject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import painengine.Game;

/**
	Base for any drawable class
 */

public class Sprite
{
	private float floatX;
	private float floatY;
	private int x;
	private int y;
	private int width;
	private int height;
	private Color color;
	private BufferedImage image;

	/**
		Creates a basic sprite
	 */
	public Sprite(){
		setX(10);
		setY(10);
		setWidth(10);
		setHeight(10);
		setColor(Color.RED);
		image = null;
	}

	/**
		Creates a Sprite accoding to the parameters.

		@param x X coordinate
		@param y Y coordinate
		@param width Width of the sprite
		@param height Height of the sprite
	 */
	public Sprite(int x, int y, int width, int height){
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
		setColor(Color.RED);
		image = null;
	}

	/**
		Creates a Sprite from image

		@param image Graphic of the sprite
	 */
	public Sprite(BufferedImage image){
		setX(10);
		setY(10);
		setWidth(image.getWidth());
		setHeight(image.getHeight());
		this.image = image;
	}

	/**
		Creates a Sprite from image and sets its position

		@param image Graphic of the Sprite
		@param x X coordinate
		@param y Y coordinate
	 */
	public Sprite(BufferedImage image, int x, int y){
		setPos(x, y);
		setWidth(image.getWidth());
		setHeight(image.getHeight());
		this.image = image;
	}

	/**
		Draws this Sprite

		@param g java.awt.Graphics
	 */
	public void draw(Graphics g){
		if(image == null)
			drawSprite(g);
		else
			drawImage(g);
	}

	private void drawSprite(Graphics g){
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}

	private void drawImage(Graphics g){
		Graphics2D g2D = (Graphics2D) g;
		g2D.drawImage(image, x, y, width, height, null);
	}

	public void setX(int x) {this.x = x;}
	public void setX(float x) {
		this.floatX = x;
		this.x = Math.round(floatX);
	}
	public int getX() {return this.x;}
	public float getFloatX() {return this.floatX;}
	public void setY(int y) {this.y = y;}
	public void setY(float y) {
		this.floatY = y;
		this.y = Math.round(floatY);
	}
	public int getY() {return this.y;}
	public float getFloatY() {return this.floatY;}

	public void setPos(int x, int y){
		this.x = x;
		this.y = y;
	}

	public void setPos(float x, float y){
		this.floatX = x; this.floatY = y;
		this.x = Math.round(floatX); this.y = Math.round(floatY);
	}

	public void setWidth(int width) {this.width = width;}
	public int getWidth() {return this.width;}
	public void setSize(int width, int height) {this.width = width; this.height = height;}
	public void setHeight(int height) {this.height = height;}
	public int getHeight() {return this.height;}
	public void setColor(Color color) {this.color = color;}
	public Color getColor() {return this.color;}
	public BufferedImage getImage() {return this.image;}

	public void setImage(String filepath) {

		try{
			File file = new File(filepath);
			BufferedImage image = ImageIO.read(file);
			this.image = image;
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
}