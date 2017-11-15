package painengine.gameobject;

import java.awt.Component;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import painengine.Game;

/**
	Base for GameObject class
 */

public class Sprite extends Component
{
	private int x;
	private int y;
	private int width;
	private int height;
	private Color color;
	private BufferedImage image;

	public Sprite(){
		setX(10);
		setY(10);
		setWidth(10);
		setHeight(10);
		setColor(Color.RED);
		image = null;
	}

	public Sprite(int x, int y, int width, int height){
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
		setColor(Color.RED);
		image = null;
	}

	public Sprite(BufferedImage image){
		setX(10);
		setY(10);
		setWidth(image.getWidth());
		setHeight(image.getHeight());
		this.image = image;
	}

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
	public int getX() {return this.x;}
	public void setY(int y) {this.y = y;}
	public int getY() {return this.y;}
	public void setWidth(int width) {this.width = width;}
	public int getWidth() {return this.width;}
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