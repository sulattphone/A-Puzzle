/********************************************************************************************
* Su Latt Phone
* July 24 2018 - 
* Project Puzzle
*
* PuzzleGraphics.java
* A utility class to draw the graphics on the puzzle board
* Edited July 29 2018
* Changes: from x and y making Point[] into just directly Point from PuzzleFrame
*          deleted createPoints()
* Edited Aug 2 in CIS Lab
* Changes: reading Image from a local file with a new method readImage()
* Edited Aug 9
* Changes: reversing the for loop for removeElement() from index increment to decrement
           tried to fix the problem of frame resize but to no avail
*********************************************************************************************/

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;


public class PuzzleGraphics extends JComponent
{
	private final int SIZE = 8;         //number of total squares grids
	private final int CIRCLES = 6;      //number of circles on each side
    
   private Image crossImage;
	
	ArrayList<Point> clickPoints = new ArrayList<Point>();      //arrayList for the coordinate of the user's mouse click
	ArrayList<Color> clickColors = new ArrayList<Color>();      //arrayList for user's selected color
	
	public PuzzleGraphics()
	{
		setPreferredSize(new Dimension(500,500));

        crossImage = readImage("delete.png");

        
	}
   
   
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		int circleWidth = getWidth()/SIZE;
		int circleHeight = getHeight()/SIZE;

        //drawing the grids
		g.setColor(Color.BLACK);
		for(int row=0; row<SIZE; row++)
		{
			g.drawLine((row*getWidth())/SIZE, 0, (row*getWidth())/SIZE, getHeight());
		}
		for(int col=0; col<SIZE; col++)
		{
			g.drawLine(0, (col*getHeight())/SIZE, getWidth(), (col*getHeight())/SIZE);
		}
		
		
		//drawing the circles, squares and cross images
		for(int row=0; row<SIZE; row++)
		{
		   for(int col=0; col<SIZE; col++)
			{
			   colorAssign(row, col, g);
			   if(row==0 || row==(SIZE-1))
				{
				   if(col!=0 && col!= (SIZE-1)){
			            g.fillOval((col*getWidth())/SIZE,(row*getHeight())/SIZE,circleWidth,circleHeight);
					}

				}	
				else
				{
					if(col==0 || col== (SIZE-1))
						g.fillOval((col*getWidth())/SIZE, (row*getHeight())/SIZE, circleWidth,circleHeight);
						
					if((row==1 && col==2) || (row==6 && col==6))
					{
					  g.setColor(Color.BLACK);
					  g.fillRect((col*getWidth())/SIZE, (row*getHeight())/SIZE, circleWidth, circleHeight);
					}
					   
				}
                //drawing shapes in the grid the user clicked
				for(int k=0; k<clickPoints.size();k++)
				{
				   if(withinBounds(row, col, k))
               { 
                      g.setColor(clickColors.get(k));
                      if(clickColors.get(k)== null)
                         g.drawImage(crossImage, (col*getWidth())/SIZE, (row*getHeight())/SIZE, circleWidth, circleHeight, null);
                      else
                         g.fillOval((col*getWidth())/SIZE, (row*getHeight())/SIZE, circleWidth,circleHeight);
               }

				}
				
				
			}
			
		}

	}
	
    //setting up the puzzle by assigning colors to each individual circles at the start of the puzzle
	 public void colorAssign(int i, int j,Graphics g)
	{
		switch(i){
			case 0: 
				switch (j){
					case 1: g.setColor(Color.RED);
					        break;
					case 2: g.setColor(Color.BLACK);
					        break;
					case 3: g.setColor(Color.BLUE);
					        break;
					case 4: g.setColor(Color.BLUE);
					        break;
					case 5: g.setColor(Color.YELLOW);
					        break;
					case 6: g.setColor(Color.RED);
					        break;
				}
				break;
			case 1: 
			   if(j==0)
				   g.setColor(Color.BLACK);
				else if(j==(SIZE-1))   
					g.setColor(Color.RED);
				break;
			case 2:
			   if(j==0)
				   g.setColor(Color.RED);
				else if(j==(SIZE-1))
				   g.setColor(Color.BLUE);
				break;
			case 3:
			   if(j==0)
				   g.setColor(Color.BLUE);
				else if(j==(SIZE-1))
				   g.setColor(Color.YELLOW);
				break;
			case 4:
			   if(j==0)
				   g.setColor(Color.YELLOW);
				else if(j==(SIZE-1))
				   g.setColor(Color.RED);
				break;
			case 5:
			   if(j==0)
				   g.setColor(Color.BLUE);
				else if(j==(SIZE-1))
				   g.setColor(Color.YELLOW);
				break;
			case 6: 
			   if(j==0)
				   g.setColor(Color.YELLOW);
				else if(j==(SIZE-1))
				   g.setColor(Color.BLACK);
			   break;
			case 7:
			   switch (j){
					case 1: g.setColor(Color.YELLOW);
					        break;
					case 2: g.setColor(Color.YELLOW);
					        break;
					case 3: g.setColor(Color.RED);
					        break;
					case 4: g.setColor(Color.RED);
					        break;
					case 5: g.setColor(Color.BLUE);
					        break;
				   case 6: g.setColor(Color.BLACK);
				}
				break;
		}
	}

   //adding the user's mouse click coordinate and the selected color to respective arrayLists
   public void setPointFromMouse(Point p, Color color)
   {
		
		clickPoints.add(p);
		clickColors.add(color);
      repaint();
   }

   //checking in which grid the user's mouse click lies
   public boolean withinBounds(int i, int j, int k)
   {
      boolean booleanX = false;
      boolean booleanY = false;

      Point p = clickPoints.get(k);
		
      if(p.getX()>((j*getWidth())/SIZE) && p.getX()<(((j+1)*getWidth())/SIZE))
         booleanX = true;
      
      if(p.getY()>((i*getHeight())/SIZE) && p.getY()<(((i+1)*getHeight())/SIZE))
         booleanY = true;

      if(booleanX==true && booleanY==true)
         return true;

       return false;
   }
	
    // locating and removing the elements from 2 arraylists if the user chose the delete the option
	public void removeElement(int x, int y)
	{
		int markCol=0;
		int markRow=0;
		
		for(int row=0; row<SIZE; row++)
		{
			for(int col=0; col<SIZE; col++)
			{
				if(x>((col*getWidth())/SIZE) && x<(((col+1)*getWidth())/SIZE))
				   markCol = col;
				
				if(y>((row*getHeight())/SIZE) && y<(((row+1)*getHeight())/SIZE))
				   markRow = row;
			}
		}
		//fix here... the indices after removing
		for(int q=(clickPoints.size()-1); q>=0; q--)
		{
			Point p = clickPoints.get(q);
			if(p.getX()>((markCol*getWidth())/SIZE) && p.getX()<(((markCol+1)*getWidth())/SIZE) && p.getY()>((markRow*getHeight())/SIZE) && p.getY()<(((markRow+1)*getHeight())/SIZE))
			{
				clickPoints.remove(q);
				clickColors.remove(q);
		      repaint();
			   break;
         }
		}
		

	}
    
    public Image readImage(String fileName)
    {
        Image image = null;
        try
        {
            image = ImageIO.read(new File(fileName));
        }
        catch(IOException e)
        {
            System.out.println("Failed to load image "+ fileName);
        }
        return image;
    }
    
    public boolean checkAnswer()
    {
       PuzzleChecker checker = new PuzzleChecker();
       return checker.checkPuzzle(clickPoints, clickColors);
    }
}