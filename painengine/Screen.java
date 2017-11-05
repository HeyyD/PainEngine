package painengine;
import javax.swing.JFrame;

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

	private void createDefaultScreen(){
		setTitle("PainEngine Game");
		setSize(600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}

