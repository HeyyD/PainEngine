package painengine.util;

import painengine.gameobject.Sprite;

import java.awt.Graphics;
import java.awt.Rectangle;

import java.util.List;
import java.util.LinkedList;

/**
	Tilemaps are used to draw large amount of sprites
	or GameObjects at the same time.
 */

public class TileMap
{

	private List<Rectangle> solidTiles = new LinkedList<>();

	private TileSet tileSet;
	private Tile[] tiles;
	private int[][] map;

	public TileMap(TileSet tileSet, int[][] map){
		this.tileSet = tileSet;
		this.map = map;
		this.tiles = tileArray();
	}

	private Tile[] tileArray(){
		Tile[] array = new Tile[map.length * map[0].length];

		int index = 0;

		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[i].length; j++){
				Tile t = new Tile(tileSet.getTiles()[map[i][j]]);
				t.setX(t.getWidth() * j);
				t.setY(t.getHeight() * i);

				if(t.getSolid()){
					solidTiles.add(new Rectangle(t.getX(), t.getY(),
									t.getWidth(), t.getHeight()));
				}

				array[index] = t;
				index++;
			}
		}

		return array;
	}

	public void setMap(int[][] map){this.map = map;}
	public int[][] getMap() {return this.map;}

	public List<Rectangle> getSolidTiles(){ return this.solidTiles;}

	public void draw(Graphics g){
		for(Tile t: tiles){
			t.draw(g);	
		}
	}

}

