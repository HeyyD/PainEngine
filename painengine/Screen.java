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
	private Stage stage;

	public Screen(String name, int width, int height){
		setTitle(name);
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setFocusable(true);
		Canvas canvas = new Canvas(width, height);
		canvas.setBackground(Color.BLACK);
		setStage(new Stage(canvas));
		add(stage.getCanvas());
		setFocusable(true);
		setVisible(true);
	}

	public Stage getStage(){return this.stage;}

	public void setStage(Stage stage){
		if(this.stage != null)
			remove(this.stage.getCanvas());

		add(stage.getCanvas());
		invalidate(); validate();
		this.stage = stage;
	}
}

