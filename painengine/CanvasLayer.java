package painengine;
import java.util.LinkedList;
import java.util.List;


/**
	Used to draw all the Sprites on the layer on to the
	Canvas.
 */

public class CanvasLayer
{
	/**Host canvas that the layer is drawn on */
	private Canvas host;
	private List<Sprite> sprites = new LinkedList<>();

	public CanvasLayer(Canvas host){
		this.host = host;
	}

	public void addSprite(Sprite sprite){
		sprites.add(sprite);
	}

	public void drawLayer(){
		for(Sprite s: sprites)
			s.draw();
	}
}

