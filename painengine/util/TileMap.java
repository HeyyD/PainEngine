package painengine.util;

import painengine.gameobject.Sprite;

import java.awt.Graphics;

/**
	Tilemaps are used to draw large amount of sprites
	or GameObjects at the same time.
 */

public class TileMap
{

	private TileSet tileSet;
	private int[][] map;

	public TileMap(TileSet tileSet){
		this.tileSet = tileSet;
	}

	public void setMap(int[][] map){this.map = map;}
	public int[][] getMap() {return this.map;}

	public void draw(Graphics g){
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[i].length; j++){
				Tile t = tileSet.getTiles()[map[i][j]];
				t.setX(t.getWidth() * j);
				t.setY(t.getHeight() * i);
				t.draw(g);
				//tileSet.getTiles()[map[i][j]].draw(g);
			}
		}
	}

}

