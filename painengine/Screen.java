package painengine;
import javax.swing.JFrame;
import java.awt.Color;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Screen extends JFrame
{	
	private Canvas canvas;

	public Screen(){
		createDefaultScreen();
	}

	public void setCanvas(Canvas canvas){
		this.canvas = canvas;
	}

	private void createDefaultScreen(){
		setTitle("PainEngine Game");
		setSize(600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setCanvas(new Canvas(600, 600));
		CanvasLayer l = new CanvasLayer(canvas);
		canvas.setBackground(Color.BLACK);
		canvas.addLayer(l);
		add(canvas);
		setVisible(true);
	}
}

