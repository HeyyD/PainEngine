package painengine;

/**
	Base for GameObject class
 */

public class Sprite
{
	private int x;
	private int y;
	private int width;
	private int height;

	public Sprite(int x, int y, int width, int height){
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
	}

	public void draw(){
		
	}

	public void setX(int x) {this.x = x;}
	public int getX() {return this.x;}
	public void setY(int y) {this.y = y;}
	public int getY() {return this.y;}
	public void setWidth(int width) {this.width = width;}
	public int getWidth() {return this.width;}
	public void setHeight(int height) {this.height = height;}
	public int getHeight() {return this.height;}
}