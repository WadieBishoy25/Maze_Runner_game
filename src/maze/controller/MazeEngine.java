/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze.controller;

import java.util.Random;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Paint;
import maze.model.Bomb;
import maze.model.BombFactory;
import maze.model.Bullet;
import maze.model.GiftFactory;
import maze.model.Wall;
import maze.model.WoodenWall;
import maze.model.cell;
import maze.model.concreteWall;
import maze.model.maze;
import maze.model.player;

/**
 *
 * @author wadiebishoy
 */
public class MazeEngine {
    
   private BombFactory BF = new BombFactory();
   private GiftFactory GF = new GiftFactory();
   private mazeGenerator MG = new mazeGenerator();
      int i,j; 
   
    public void GenerateMaze ()
    {
        MG.cellIntiallize();
        MG.mazeGeneration();
        maze.setMaze(MG.getMaze());
        
        cell c = new player() ;
            changeCell(0, 0, c);
            
       
    }
    
    public void addBombs ()
    {
        int i ,x,y;
        cell c ; 
        Random rnd = new Random();
        for (i=0 ; i<7 ; i++)
        {
            do {
            x=rnd.nextInt(19);
            y=rnd.nextInt(28);}while(x < 5 && y<5);
            c= BF.getBomb("small") ;
            changeCell(x, y, c);

        }
        for (i=0 ; i<3 ; i++)
        {
            do {
            x=rnd.nextInt(19);
            y=rnd.nextInt(28);}while(x < 5 && y<5);
            c= BF.getBomb("large") ;
            changeCell(x, y, c);
        }        
       
    }
    
        public void addGifts ()
    {
        int i,x,y ;
        cell c ; 
        Random rnd = new Random();
        for (i=0 ; i<2; i++)
        {
            do {
            x=rnd.nextInt(19);
            y=rnd.nextInt(28);}while(x < 5 && y<5);
            c= GF.getGift("health");
            changeCell(x, y, c);
          
        }        
        for (i=0 ; i<2 ; i++)
        {
            do {
            x=rnd.nextInt(19);
            y=rnd.nextInt(28);}while(x < 5 && y<5);       
            c= GF.getGift("ammo");
            changeCell(x, y, c);
        }         
         for (i=0 ; i<2 ; i++)
        {
             do {
            x=rnd.nextInt(19);
            y=rnd.nextInt(28);}while(x < 5 && y<5);          
            c= GF.getGift("armor");
            changeCell(x, y, c);

        }     
    }
        
        public void addBreakableWalls ()
        {
         int i,x,y ;
        Random rnd = new Random();
            for (i=0 ; i<10 ; i++)
            {
            do {
            x=rnd.nextInt(19);
            y=rnd.nextInt(28);}while(x < 5 && y<5); 
            if (!(maze.getMaze()[x][y].getWalls()[0]))
            {
                addBreakableWallsToMaze(x, y, 0);
            }
            else if (!(maze.getMaze()[x][y].getWalls()[2]))
            {
                addBreakableWallsToMaze(x, y, 2);
            }
            else if (!(maze.getMaze()[x][y].getWalls()[1]))
            {
                addBreakableWallsToMaze(x, y, 1);
            }
            else  if (!(maze.getMaze()[x][y].getWalls()[3]))
            {
                addBreakableWallsToMaze(x, y, 3);
            }
            else 
                i--;
            }
        }
    
       public void addBreakableWallsToMaze (int x , int y , int c) 
       {
           switch (c)
           {
               case 0 :
               {
                 maze.getMaze()[x][y].addBreakableWall(0);
                maze.getMaze()[x][y -1].addBreakableWall(1);
                break;
               }
               case 1 :
               {
                maze.getMaze()[x][y].addBreakableWall(1);
                maze.getMaze()[x][y +1].addBreakableWall(0);
                break;
               }
               case 2 :
               {
                maze.getMaze()[x][y].addBreakableWall(2);
                maze.getMaze()[x-1][y].addBreakableWall(3);
                break;
               }
               case 3 :
               {
                maze.getMaze()[x][y].addBreakableWall(3);
                maze.getMaze()[x + 1][y].addBreakableWall(2);
                break;
               }
           }
       }
        
       public void removeBreakableWallsToMaze (int x , int y , int c) 
       {
           switch (c)
           {
               case 0 :
               {
                 maze.getMaze()[x][y].removeBreakableWall(0);
                maze.getMaze()[x][y -1].removeBreakableWall(1);
                break;
               }
               case 1 :
               {
                maze.getMaze()[x][y].removeBreakableWall(1);
                maze.getMaze()[x][y +1].removeBreakableWall(0);
                break;
               }
               case 2 :
               {
                maze.getMaze()[x][y].removeBreakableWall(2);
                maze.getMaze()[x-1][y].removeBreakableWall(3);
                break;
               }
               case 3 :
               {
                maze.getMaze()[x][y].removeBreakableWall(3);
                maze.getMaze()[x + 1][y].removeBreakableWall(2);
                break;
               }
           }
       }
     public void changeCell (int x , int y, cell c)
     {
            cell [][] temp = maze.getMaze();
            c.clone(temp[x][y]);
            temp[x][y] = c ;
            maze.setMaze(temp);
     }
       
     
       public void mazeShowCanvas (Object canvas)
   {
       Wall wall = new concreteWall() ;
       Wall B_wall = new WoodenWall();
                     
         int i,j;
       
                 for (j=0;j<30;j++)
          {
              if (maze.getMaze()[0][j].getWalls()[2])
              {
//                ( (Canvas)canvas).getGraphicsContext2D().setLineWidth(2);   
//                  ( (Canvas)canvas).getGraphicsContext2D().setStroke(Paint.valueOf("grey"));
//             ( (Canvas)canvas).getGraphicsContext2D().strokeLine(j*33 , 0, (j+1)*33 ,0);
                         ( (Canvas)canvas).getGraphicsContext2D().drawImage(wall.getWallHImage()  ,  j*33 , 0 );

              }
              else if (maze.getMaze()[0][j].getBreakableWalls()[2])
              {
                   ( (Canvas)canvas).getGraphicsContext2D().drawImage(B_wall.getWallHImage()  ,  j*33 , 0 );
              }
          }
          
      for (i=0;i<20;i++)
      {

          for (j=0;j<30;j++)
          {
        if (maze.getMaze()[i][j].getWalls()[0])
                         {
//                ( (Canvas)canvas).getGraphicsContext2D().setLineWidth(2);   
//                  ( (Canvas)canvas).getGraphicsContext2D().setStroke(Paint.valueOf("grey"));
                  
            ( (Canvas)canvas).getGraphicsContext2D().drawImage(wall.getWallVImage()  ,  j*33 , i*32 );

//             ( (Canvas)canvas).getGraphicsContext2D().strokeLine(j*33 , i*32 , (j)*33 ,(i+1)*32);
              }
             else if (maze.getMaze()[i][j].getBreakableWalls()[0])
              {
                ( (Canvas)canvas).getGraphicsContext2D().drawImage(B_wall.getWallVImage()  ,  j*33 , i*32 );
              }
         
         ( (Canvas)canvas).getGraphicsContext2D().drawImage(maze.getMaze()[i][j].getContains(), (j*33)+7 , (i*32)+7 ,25, 24);
         
         if (maze.getMaze()[i][j].getWalls()[1])
                                     {
//                ( (Canvas)canvas).getGraphicsContext2D().setLineWidth(2);   
//                  ( (Canvas)canvas).getGraphicsContext2D().setStroke(Paint.valueOf("grey"));
//             ( (Canvas)canvas).getGraphicsContext2D().strokeLine((j+1)*33 , i*32 , (j+1)*33 ,(i+1)*32);
                         ( (Canvas)canvas).getGraphicsContext2D().drawImage(wall.getWallVImage()  , (j+1)*33 , i*32 );

              }
                      else if (maze.getMaze()[i][j].getBreakableWalls()[1])
              {
                ( (Canvas)canvas).getGraphicsContext2D().drawImage(B_wall.getWallVImage()  ,  (j+1)*33 , i*32 );
              }
         
          }
                     for (j=0;j<30;j++)
          {
              if (maze.getMaze()[i][j].getWalls()[3])
                                                {
//                ( (Canvas)canvas).getGraphicsContext2D().setLineWidth(2);   
//                  ( (Canvas)canvas).getGraphicsContext2D().setStroke(Paint.valueOf("grey"));
//             ( (Canvas)canvas).getGraphicsContext2D().strokeLine((j)*33 ,(i+1)*32 , (j+1)*33 ,(i+1)*32);
                          ( (Canvas)canvas).getGraphicsContext2D().drawImage(wall.getWallHImage()  , (j)*33 ,(i+1)*32 );

                                                }
                           else if (maze.getMaze()[i][j].getBreakableWalls()[3])
              {
                ( (Canvas)canvas).getGraphicsContext2D().drawImage(B_wall.getWallHImage()  ,  (j)*33 ,(i+1)*32);
              }
          }
      }
   }
       
       
}
