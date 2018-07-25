/****************************************************************************************
* Su Latt Phone
* July 24 2018 - 
* Project Puzzle
*
* PuzzleGraphics.java
* A utility class to draw the graphics on the puzzle board
****************************************************************************************/
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;


public class PuzzleGraphics extends JComponent
{

	private final Color BLUE = new Color(0,0,255);
	private final Color RED = new Color(255,0,0);
	private final Color YELLOW = new Color (255,255,0);
	private final Color BLACK = new Color(0,0,0);
	private final int SIZE = 8;
	private final int CIRCLES = 6;
	private int x;
	private int y;
	
	public PuzzleGraphics()
	{
		setPreferredSize(new Dimension(500,500));
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		int circleWidth = getWidth()/SIZE;
		int circleHeight = getHeight()/SIZE;



		for(int row=0; row<SIZE; row++)
		{
			g.drawLine((row*getWidth())/SIZE, 0, (row*getWidth())/SIZE, getHeight());
		}
		for(int col=0; col<SIZE; col++)
		{
			g.drawLine(0, (col*getHeight())/SIZE, getWidth(), (col*getHeight())/SIZE);
		}
		
		
		
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
					  g.setColor(BLACK);
					  g.fillRect((col*getWidth())/SIZE, (row*getHeight())/SIZE, circleWidth, circleHeight);
					}
					   
				}
			}
			
		}
	}
	
	 public void colorAssign(int i, int j,Graphics g)
	{
		switch(i){
			case 0: 
				switch (j){
					case 1: g.setColor(RED);
					        break;
					case 2: g.setColor(BLACK);
					        break;
					case 3: g.setColor(BLUE);
					        break;
					case 4: g.setColor(BLUE);
					        break;
					case 5: g.setColor(YELLOW);
					        break;
					case 6: g.setColor(RED);
					        break;
				}
				break;
			case 1: 
			   if(j==0)
				   g.setColor(BLACK);
				else if(j==(SIZE-1))   
					g.setColor(RED);
					break;
			case 2:
			   if(j==0)
				   g.setColor(RED);
				else if(j==(SIZE-1))
				   g.setColor(BLUE);
					break;
			case 3:
			   if(j==0)
				   g.setColor(BLUE);
				else if(j==(SIZE-1))
				   g.setColor(YELLOW);
					break;
			case 4:
			   if(j==0)
				   g.setColor(YELLOW);
				else if(j==(SIZE-1))
				   g.setColor(RED);
					break;
			case 5:
			   if(j==0)
				   g.setColor(BLUE);
				else if(j==(SIZE-1))
				   g.setColor(YELLOW);
					break;
			case 6: 
			   if(j==0)
				   g.setColor(YELLOW);
				else if(j==(SIZE-1))
				   g.setColor(BLACK);
			        break;
			case 7:
			   switch (j){
					case 1: g.setColor(YELLOW);
					        break;
					case 2: g.setColor(YELLOW);
					        break;
					case 3: g.setColor(RED);
					        break;
					case 4: g.setColor(RED);
					        break;
					case 5: g.setColor(BLUE);
					        break;
				   case 6: g.setColor(BLACK);
				}
				break;
		}
	}
}