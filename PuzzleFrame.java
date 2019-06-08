/*************************************************************************************************
* Su Latt Phone
* July 23 2018-
* Puzzle Project
* 
* PuzzleFrame.java
* The test driver class that constructs GUI components and frame
* Edited July 29
* Changes: from e.getX() and e.getY() into directly getting the point with e.getPoint()
* Edited Aug 2 in CIS Lab
* Changes: added crossRadioButton

* Aug 9 : Tried to fix the frame resize problem with ComponentListener but to no avail
**************************************************************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;




public class PuzzleFrame extends JFrame implements MouseListener, ActionListener//, ComponentListener
{
   private PuzzleGraphics graphics;
   
   private JButton submitButton;
   private JRadioButton yellowRadio;
   private JRadioButton redRadio;
   private JRadioButton blueRadio;
   private JRadioButton deleteRadio;
   private JRadioButton crossRadio; 
	
   private Color color;
   private int clickedX;
   private int clickedY;
	
   public PuzzleFrame()
   {
      setTitle("Puzzle");
		
		Container contentArea = getContentPane();
		contentArea.setLayout(new BorderLayout());
		contentArea.setBackground(new Color(80,80,80));
     // contentArea.setPreferredSize(new Dimension(600,600));
     //contentArea.addComponentListener(this);
		
		graphics = new PuzzleGraphics();
		contentArea.add(graphics, BorderLayout.CENTER);
		graphics.setFocusable(true);
      graphics.addMouseListener(this);
   //   graphics.addComponentListener(this);
	
		JPanel panel = new JPanel();
		submitButton = new JButton("Submit");
      submitButton.addActionListener(this);
     // submitButton.addComponentListener(this);
      submitButton.setFocusable(true);	//might change this later, or not
		panel.add(submitButton);

      yellowRadio = new JRadioButton("Yellow");
      blueRadio = new JRadioButton("Blue");
      redRadio = new JRadioButton("Red");
	   deleteRadio = new JRadioButton("Delete");
      crossRadio = new JRadioButton("None");

      yellowRadio.setSelected(true);

      ButtonGroup radioGroup = new ButtonGroup();
      radioGroup.add(yellowRadio);
      radioGroup.add(redRadio);
      radioGroup.add(blueRadio);
	   radioGroup.add(deleteRadio);
      radioGroup.add(crossRadio);

      panel.add(yellowRadio);
      panel.add(redRadio);
      panel.add(blueRadio);
	   panel.add(deleteRadio);
      panel.add(crossRadio);
	   contentArea.add(panel, BorderLayout.SOUTH);
      
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		graphics.requestFocusInWindow(); 	
		pack();
		setVisible(true);
        
      JOptionPane.showMessageDialog(this, "How to Play:\n\n Place circles of different colors within the grids such that:\n * each row = 3 circles (different color)\n * each column = 3 circles (different color)\n * each circle on the top/bottom/sides should\n   see a circle of the same color first.");
		  
   }
  

   public void actionPerformed(ActionEvent e)
   {
      if(e.getSource().equals(submitButton))
      {
        // System.exit(0);		//test
        boolean status = graphics.checkAnswer();
        JOptionPane.showMessageDialog(this, status);
      }
   }

   public void mouseClicked(MouseEvent e)
   {

      if(deleteRadio.isSelected())
		{
			graphics.removeElement(e.getX(), e.getY());
		}
		else
		{
      	   if(yellowRadio.isSelected())
            color = Color.YELLOW;
         else if(redRadio.isSelected())
            color = Color.RED;
         else if(blueRadio.isSelected())
            color = Color.BLUE;
         else if(crossRadio.isSelected())
            color = null;
 
         graphics.setPointFromMouse(e.getPoint(), color);
		}
   }

   public void mouseEntered(MouseEvent e){}

   public void mouseExited(MouseEvent e){}
   
   public void mousePressed(MouseEvent e){}

   public void mouseReleased(MouseEvent e){}
   
   /*public void componentResized(ComponentEvent e)
   {
      graphics.repaint();
   }
   
   public void componentHidden(ComponentEvent e){}
   
   public void componentMoved(ComponentEvent e){}
   
   public void componentShown(ComponentEvent e){}*/
   
   
   public static void main(String args[])
	{
	   PuzzleFrame frame = new PuzzleFrame();
		
	}
}