package painengine;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
/**
	Base for GameObject class
 */

public class Sprite
{
	private int x;
	private int y;
	private int width;
	private int height;
	private Color color;

	public Sprite(){
		setX(10);
		setY(10);
		setWidth(10);
		setHeight(10);
		setColor(Color.RED);
	}

	public Sprite(int x, int y, int width, int height){
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
		setColor(Color.RED);
	}

	public void draw(Graphics g){
		g.setColor(color);
		g.fillRect(x, y, width, height);
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
}