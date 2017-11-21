package painengine;
import javax.swing.JFrame;
import java.awt.Color;

/**
	Screen class is the window that the game is drawn on.
	@see JFrame
 */

public class Screen extends JFrame
{	
	/** Current stage of the game */
	private Stage stage;

	/**
		Constructor of the screen. It sets the name and 
		size of the screen. It also sets it on the center
		of the monitor and creates default stage and canvas
		so that the user can start building the game.

		@param name Name of the game screen
		@param width Width of the screen
		@param height Height of the screen
	 */
	public Screen(String name, int width, int height){
		setTitle(name);
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setFocusable(true);
		Canvas canvas = new Canvas(width, height);
		canvas.setBackground(Color.BLACK);
		setStage(new Stage(canvas));
		add(stage.getCanvas());
		setFocusable(true);
		setVisible(true);
	}

	/**
		@return Current stage of the game
	 */
	public Stage getStage(){return this.stage;}

	/**
		Set current stage of the game
	 */
	public void setStage(Stage stage){
		if(this.stage != null)
			remove(this.stage.getCanvas());

		add(stage.getCanvas());
		invalidate(); validate();
		this.stage = stage;
	}
}

