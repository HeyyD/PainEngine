package painengine;
import javax.swing.JPanel;
import java.util.LinkedList;
import java.util.List;


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

	private List<CanvasLayer> layers = new LinkedList<>();

	public Canvas(int width, int height){
		setWidth(width);
		setHeight(height);
	}

	public void drawCanvas(){
		for(CanvasLayer l: layers)
			l.drawLayer();
	}

	public void addLayer(CanvasLayer layer){
		layers.add(layer);
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
}

