/**************************************************************************************
* Su Latt Phone
* July 29 2018 -
* Project Puzzle
* 
* PuzzleChecker.java
* Checks the solution of the puzzle
* Edited Aug 9
* Changes: constructed the methods checkPuzzle(), rowThreeChecker() and colThreeChecker
*          but all the logic was screwed.  Currently stopped
*************************************************************************************/
import java.awt.Color;
import java.util.ArrayList;
import java.awt.*;

public class PuzzleChecker
{
   private ArrayList<Color> colors;
   private ArrayList<Point> points;
   boolean[] colorFound = new boolean[3];   
   
   public boolean checkPuzzle(ArrayList<Point> p, ArrayList<Color> c)
   {
      boolean row = rowThreeCheck(c);
      resetBooleanArray();
      boolean col = colThreeCheck(c);
      
      if(row==true && col==true)
         return true;
      else
         return false;
   }
   
   /*method: rowThreeCheck()
   * to check the existence of 3 circles of different color for each row
   */
   public boolean rowThreeCheck(ArrayList<Color> color)
   {
      
      for(int i=0; i<color.size(); i++)
      {
         Color c = color.get(i);
         int arrayI=0;
         if(c==Color.YELLOW)
            arrayI = 0;
         else if(c==Color.RED)
            arrayI = 1;
         else if(c==Color.BLUE)
            arrayI = 2;
         if(!colorFound[arrayI])
         {
            colorFound[arrayI] = true;
         }
         else 
            return false;
      }
      return true;
   }
   
   public boolean colThreeCheck(ArrayList<Color> color)
   {
      for(int i=0; i<color.size(); i++)
      {
         Color c = color.get(i);
         int arrayI=0;
         if(c==Color.YELLOW)
            arrayI=0;
         else if(c==Color.RED)
            arrayI = 1;
         else if(c==Color.BLUE)
            arrayI = 2;
         if(!colorFound[arrayI])
            colorFound[arrayI] = true;
         else
            return false;
      }
      return true;
   }
   
   public void resetBooleanArray()
   {
      for(int i=0; i<colorFound.length; i++)
      {
         colorFound[i] = false;
      }
   }
}