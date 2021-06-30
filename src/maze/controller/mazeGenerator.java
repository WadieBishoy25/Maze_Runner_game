/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze.controller;

import java.util.Random;
import java.util.Stack;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Paint;
import maze.model.cell;


/**
 *
 * @author wadiebishoy
 */
public class mazeGenerator {
    
   private cell [][] maze = new cell [20][30] ;
    
   public void cellIntiallize ()
   {
       int i,j ;
       for (i=0 ; i<20 ; i++)
           for (j=0; j<30 ; j++)
           {
                maze[i][j] = new cell();
               maze[i][j].setX(i);
               maze[i][j].setY(j); ;
           }       
       
   }
   public void mazeGeneration ()
   {
       int c;
       Random rnd = new Random();
       
       Stack<cell> backtrack = new Stack<>();
       
       int vistedCells =1 ;
      
       maze[0][0].setVisited(true);
       cell currentCell = maze[0][0] ;
       
       while (vistedCells < 20*30 )
       {
           if (!checkNeighbours(currentCell)[0] && !checkNeighbours(currentCell)[1] && !checkNeighbours(currentCell)[2] && !checkNeighbours(currentCell)[3] )
           {
               currentCell = backtrack.pop();
           }
           else 
           {
             while (true)
             {
                 c = rnd.nextInt(4);
                 if (checkNeighbours(currentCell)[c])
                     break;
             }
             backtrack.push(currentCell);
              switch (c)
              {
                  case 0 :
                  {
                      maze[currentCell.getX()][currentCell.getY()].getWalls()[0] = false ;
                      maze[currentCell.getX()][currentCell.getY() - 1].getWalls()[1] = false ;
                      
                      currentCell = maze[currentCell.getX()][currentCell.getY() - 1] ;
                      maze[currentCell.getX()][currentCell.getY()].setVisited(true);
                      
                      vistedCells ++ ;
                      break;
                  }
                  case 1 :
                  {
                      maze[currentCell.getX()][currentCell.getY()].getWalls()[1] = false ;
                      maze[currentCell.getX()][currentCell.getY() + 1].getWalls()[0] = false ;
                      
                      currentCell = maze[currentCell.getX()][currentCell.getY() + 1] ;
                      maze[currentCell.getX()][currentCell.getY()].setVisited(true);
                      
                      vistedCells ++ ;
                      break;
                  }
                  case 2 :
                  {
                      maze[currentCell.getX()][currentCell.getY()].getWalls()[2] = false ;
                      maze[currentCell.getX() -1 ][currentCell.getY() ].getWalls()[3] = false ;
                      
                      currentCell = maze[currentCell.getX()-1][currentCell.getY() ] ;
                      maze[currentCell.getX()][currentCell.getY()].setVisited(true);
                      
                      vistedCells ++ ;
                      break;
                  }
                  case 3 :
                  {
                      maze[currentCell.getX()][currentCell.getY()].getWalls()[3] = false ;
                      maze[currentCell.getX () +1][currentCell.getY() ].getWalls()[2] = false ;
                      
                      currentCell = maze[currentCell.getX() +1][currentCell.getY()] ;
                      maze[currentCell.getX()][currentCell.getY()].setVisited(true);
                      
                      vistedCells ++ ;
                      break;
                  }
  
              }
               
           }
       }
       
      maze[19][29].getWalls()[1] = false ;
       
   }
   
   
   public  boolean  [] checkNeighbours (cell c)
   {
       // 0:Left  1:Right  2:Up  3:Down
        boolean  [] neighbours = { false,false,false,false } ;
       if ( c.getX()-1>=0 && !maze[c.getX()-1][c.getY()].isVisited() )
        neighbours[2]=true ;
       if (c.getX()+1<20 && !maze[c.getX()+1][c.getY()].isVisited() )
        neighbours[3]=true ;
       if (  c.getY()+1<30 && !maze[c.getX()][c.getY()+1].isVisited())
        neighbours[1]=true ;
       if (  c.getY()-1>=0 && !maze[c.getX()][c.getY()-1].isVisited())
        neighbours[0]=true ;
       
       return neighbours ;
   }
   


    public cell[][] getMaze() {
        return maze;
    }

   

}
