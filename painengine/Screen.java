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

	public Screen(){
		createDefaultScreen();
	}

	private void createDefaultScreen(){
		setTitle("PainEngine Game");
		setSize(600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setFocusable(true);
		Canvas canvas = new Canvas(600,600);
		canvas.setBackground(Color.BLACK);
		setStage(new Stage(canvas));
		add(stage.getCanvas());
		setFocusable(true);
		setVisible(true);
	}

	public Stage getStage(){return this.stage;}
	public void setStage(Stage stage){this.stage = stage;}
}

