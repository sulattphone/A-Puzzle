/****************************************************************
* Su Latt Phone
* July 27 2018-
* Puzzle Project
* 
* PuzzleFrame.java
* The test driver class that constructs GUI components and frame
*****************************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;*/



public class PuzzleFrame extends JFrame
{
   private PuzzleGraphics graphics;
   
	private JButton submitButton;
	
   public PuzzleFrame()
   {
      setTitle("Puzzle");
		
		Container contentArea = getContentPane();
		contentArea.setLayout(new BorderLayout());
		
		graphics = new PuzzleGraphics();
		contentArea.add(graphics, BorderLayout.CENTER);
		graphics.setFocusable(true);
		
		JPanel panel = new JPanel();
		submitButton = new JButton("Submit");
		panel.add(submitButton);
		contentArea.add(panel, BorderLayout.SOUTH);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		graphics.requestFocusInWindow(); 	
		pack();
	//	setSize(500,500);
		setVisible(true);
		  
   }
  

	public static void main(String args[])
	{
	   PuzzleFrame frame = new PuzzleFrame();
		
	}
}