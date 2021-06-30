/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze.controller;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import maze.model.AmmoGift;
import maze.model.AmmoGiftDecorator;
import maze.model.ArmorGift;
import maze.model.ArmorGiftDecorator;
import maze.model.Bomb;
import maze.model.BombDecorator;
import maze.model.Bullet;
import maze.model.DestroyedGift;
import maze.model.ExplosionBomb;
import maze.model.Gift;
import maze.model.GiftDecorator;
import maze.model.HealthGift;
import maze.model.HealthGiftDecorator;
import maze.model.PlayerProp;
import maze.model.ShootingPlayer;
import maze.model.cell;
import maze.model.maze;
import maze.model.player;
import maze.view.FXMLDocumentController;
import maze.view.InfoPanel;

/**
 *
 * @author wadiebishoy
 */
public class GameController implements GameEngine {

    MazeEngine ME = new MazeEngine();
    Canvas mazeCanvas ;
    ContextArmor context_A = new ContextArmor();
    ContextMoving context_M = new ContextMoving();
    cell c ;
    int playerX , playerY , bulletX , bulletY , hitX ,hitY ;
    boolean shooting = false ;
    int shootingDirection ;
    Subject subject = new Subject() ;

    Pane win ;
    Pane lose ;
    Text t , timer ;
    
    
    InfoPanel IP = new InfoPanel(subject);
    
    @Override
    public void GenerateMaze(Object canvas , Pane win , Pane lose , Text t ,Text timer  ) {
        this.mazeCanvas = (Canvas)canvas ;
        this.win = (Pane)win ;
        this.lose = (Pane)lose ;
        this.t = (Text)t ;
        this.timer = (Text)timer ;
        
    ME.GenerateMaze();
    playerX =0 ;
    playerY = 0 ;
    hitX = -1 ;
    hitY = -1 ;
    
    subject.attach(IP);
    ME.addBombs();
    ME.addGifts();
    ME.addBreakableWalls();
   
    }

    @Override
    public AnimationTimer gameLoop() {
        AnimationTimer gameLoop = new AnimationTimer(){
          long updatedTime1 = 0 ;
          long updatedTime2 = 0 ;
            @Override
            public void handle(long now) {
                
                mazeCanvas.getGraphicsContext2D().clearRect(0, 0, 1020, 660);
                ME.mazeShowCanvas(mazeCanvas);
                subject.setState();
                
                if (PlayerProp.getHealth() == 0)
                    LoseCondition();
                
                 if (now - updatedTime1 >= 400000000)
                {

                     if (hitX >= 0 && hitY >=0)
                {

                    c = new cell() ;
               ME.changeCell(hitX, hitY, c);
               hitX = -1 ;
               hitY =-1 ;
                }
                     updatedTime1 = now ;
                }
                if (now - updatedTime2 >= 70000000)
                {
                    if (shooting){                   
                    
               if (maze.getMaze()[bulletY ][bulletX].getBreakableWalls()[shootingDirection])
            {
               ME.removeBreakableWallsToMaze(bulletY, bulletX, shootingDirection);
               shooting = false ;
                c = new cell() ;
               ME.changeCell(bulletY, bulletX, c);
                
            }
              else  if (! maze.getMaze()[bulletY ][bulletX].getWalls()[shootingDirection] )
                    {  

                    c = new cell() ;
               ME.changeCell(bulletY, bulletX, c);
               c= new Bullet();
               ShootNextCell();
                if ((maze.getMaze()[bulletY ][bulletX].getContains() == null))
               {
               ME.changeCell(bulletY , bulletX, c);
               }
               else
               {
                   hitting(bulletY, bulletX, bulletY, bulletX);
                   shooting = false;               }
                    }
                else 
                {
                    shooting = false ;
                    c = new cell() ;
               ME.changeCell(bulletY, bulletX, c);
                }
                    }
                updatedTime2 = now ;
                }
            }
                
    }; 
    return gameLoop ;
    }    
    

    @Override
    public EventHandler<KeyEvent> controls() {
       
            EventHandler<KeyEvent> Listener = new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
            if (event.getCode().equals(KeyCode.DOWN))
        {
            if (! maze.getMaze()[playerY][playerX].getWalls()[3] && ! maze.getMaze()[playerY][playerX].getBreakableWalls()[3] )
            {  
                if ((maze.getMaze()[playerY + 1][playerX].getContains() == null))
                {
               c = new cell() ;
               ME.changeCell(playerY, playerX, c);
               c= new player();
               ME.changeCell(playerY + 1, playerX, c);
               playerY +=1 ;
                }
                else 
                {
                    hitting(playerY, playerX, playerY + 1, playerX);
                }
            }  
        }
                        if (event.getCode().equals(KeyCode.UP))
        {
            if (! maze.getMaze()[playerY][playerX].getWalls()[2] && ! maze.getMaze()[playerY][playerX].getBreakableWalls()[2] )
            {  
                if ((maze.getMaze()[playerY - 1][playerX].getContains() == null))
                {
               c = new cell() ;
               ME.changeCell(playerY, playerX, c);
               c= new player();
               ME.changeCell(playerY - 1, playerX, c);
               playerY -=1 ;
                }
                else 
                {
                    hitting(playerY, playerX, playerY - 1, playerX);
                }
            }  
        }
                        if (event.getCode().equals(KeyCode.RIGHT))
        {
            context_M.setState(new RightDirectionState());
            if (! maze.getMaze()[playerY][playerX].getWalls()[1] && ! maze.getMaze()[playerY][playerX].getBreakableWalls()[1] )
            { 
                if (playerX == 29 && playerY == 19)
                {
                  WinCondition();
                }
              else if ((maze.getMaze()[playerY ][playerX+1].getContains() == null))
                {
               c = new cell() ;
               ME.changeCell(playerY, playerX, c);
               c= new player();
               ME.changeCell(playerY, playerX + 1, c);
               playerX +=1 ;

                }
                else 
                {
                    hitting(playerY, playerX, playerY , playerX + 1);
                }
            }   
        }
                        if (event.getCode().equals(KeyCode.LEFT))
        {
            context_M.setState(new LeftDirectionState());
            if (! maze.getMaze()[playerY][playerX].getWalls()[0] && ! maze.getMaze()[playerY][playerX].getBreakableWalls()[0] )
            {  
               if ((maze.getMaze()[playerY ][playerX-1].getContains() == null))
                {
               c = new cell() ;
               ME.changeCell(playerY, playerX, c);
               c= new player();
               ME.changeCell(playerY, playerX - 1, c);
               playerX -=1 ;
                }
                else 
                {
                    hitting(playerY, playerX, playerY , playerX - 1);
                }
            }   
        }   
                 if (event.getCode().equals(KeyCode.S))
        {  
            if (PlayerProp.getAmmo() > 0){
            PlayerProp.changeAmmo(-1);
            if (maze.getMaze()[playerY ][playerX].getBreakableWalls()[3])
            ME.removeBreakableWallsToMaze(playerY, playerX, 3);
            else if (! maze.getMaze()[playerY ][playerX].getWalls()[3] )
            { 
                shooting = true ;
                c=new cell();
                ME.changeCell(bulletY, bulletX, c);
                shootingDirection = 3 ;
               bulletX = playerX ;
               bulletY = playerY ;
               c= new Bullet();
               ShootNextCell();
               
               if ((maze.getMaze()[bulletY ][bulletX].getContains() == null))
               {
               ME.changeCell(bulletY , bulletX, c);
               }
               else
               {
                   hitting(bulletY, bulletX, bulletY, bulletX);
                   shooting = false;               }
               
            }  
        }
        }
                        if (event.getCode().equals(KeyCode.W))
        {
             if (PlayerProp.getAmmo() > 0){
            PlayerProp.changeAmmo(-1);
                        if (maze.getMaze()[playerY ][playerX].getBreakableWalls()[2])
            ME.removeBreakableWallsToMaze(playerY, playerX, 2);
            else if (! maze.getMaze()[playerY ][playerX].getWalls()[2] )
            { 
                shooting = true ;
                c=new cell();
                ME.changeCell(bulletY, bulletX, c);
                shootingDirection = 2 ;
               bulletX = playerX ;
               bulletY = playerY ;
               c= new Bullet();
               ShootNextCell();
               if ((maze.getMaze()[bulletY ][bulletX].getContains() == null))
               {
               ME.changeCell(bulletY , bulletX, c);
               }
               else
               {
                   hitting(bulletY, bulletX, bulletY, bulletX);
                   shooting = false;               }
            }  
        }
        }
                        if (event.getCode().equals(KeyCode.D))
        {
             if (PlayerProp.getAmmo() > 0){
            PlayerProp.changeAmmo(-1);
            
                        if (maze.getMaze()[playerY ][playerX].getBreakableWalls()[1])
            ME.removeBreakableWallsToMaze(playerY, playerX,1);
           else  if (! maze.getMaze()[playerY ][playerX].getWalls()[1] )
            { 
                   shootingDirection = 1 ;
                shooting = true ;
                c=new cell();
                ME.changeCell(bulletY, bulletX, c);
                bulletX = playerX ;
               bulletY = playerY ;
               c= new Bullet();
               ShootNextCell();
               if ((maze.getMaze()[bulletY ][bulletX].getContains() == null))
               {
               ME.changeCell(bulletY , bulletX, c);
               }
               else
               {
                   hitting(bulletY, bulletX, bulletY, bulletX);
                   shooting = false;               }               
            }  
        }
        }
                        if (event.getCode().equals(KeyCode.A))
        {
             if (PlayerProp.getAmmo() > 0){
            PlayerProp.changeAmmo(-1);
                                    if (maze.getMaze()[playerY ][playerX].getBreakableWalls()[0])
            ME.removeBreakableWallsToMaze(playerY, playerX, 0);
          else  if (! maze.getMaze()[playerY ][playerX].getWalls()[0] )
            { 
                shootingDirection = 0 ;
                shooting = true ;
                c=new cell();
                ME.changeCell(bulletY, bulletX, c);
                bulletX = playerX ;
               bulletY = playerY ;
               c= new Bullet();
               ShootNextCell();
               if ((maze.getMaze()[bulletY ][bulletX].getContains() == null))
               {
               ME.changeCell(bulletY , bulletX, c);
               }
               else
               {
                   hitting(bulletY, bulletX, bulletY, bulletX);
                   shooting = false;
               }               
            }  
        }
        }
            event.consume();

        }
            };
      return Listener ;
    }

    public void ShootNextCell() {
       
        switch (shootingDirection)
        {
            case 0 :
            {
               bulletX -=1 ;
               break;
            }
           case 1 :
            {
               bulletX +=1 ;
               break;
            }
           case 2 :
            {
               bulletY -=1  ;
               break;
            }
           case 3 :
            {
               bulletY +=1 ;
               break;
            }
           
            
        }
    }
    
    public void hitting (int movingx , int movingy , int hitx , int hity )
    {
        if ( maze.getMaze()[hitx][hity].getContains() != null )
        {

            if (maze.getMaze()[hitx][hity] instanceof Bomb && !(maze.getMaze()[hitx][hity] instanceof BombDecorator))
            {
                  hitX = hitx ;
                  hitY = hity ;
                ME.changeCell(hitx, hity, new ExplosionBomb((Bomb)maze.getMaze()[hitx][hity]));
                if (maze.getMaze()[movingx][movingy] instanceof player)
                {
                    context_A.bombHit(context_A, ((Bomb) (maze.getMaze()[hitx][hity])).getHealthEffect());
                    PlayerProp.changeScore(-200);
                    System.out.println( PlayerProp.getHealth() +" " + PlayerProp.getScore());
                }
                else
                {
                    PlayerProp.changeScore(+500);
                                        System.out.println(   PlayerProp.getScore());

                }
            }
                  else     if (maze.getMaze()[hitx][hity] instanceof Gift && !(maze.getMaze()[hitx][hity] instanceof GiftDecorator))
            {
                  hitX = hitx ;
                  hitY = hity ;
                  if (maze.getMaze()[movingx][movingy] instanceof player)
                  {
                       PlayerProp.changeScore(+200);
                  if (maze.getMaze()[hitx][hity] instanceof HealthGift)
                  {
                     ME.changeCell(hitx, hity, new HealthGiftDecorator((Gift)maze.getMaze()[hitx][hity]));
                      PlayerProp.changeHealth(((GiftDecorator) (maze.getMaze()[hitx][hity])).getHealthEffect());
                    System.out.println( PlayerProp.getHealth()+" " + PlayerProp.getScore() );
                  }
                  else if (maze.getMaze()[hitx][hity] instanceof AmmoGift)
                  {
                ME.changeCell(hitx, hity, new AmmoGiftDecorator((Gift)maze.getMaze()[hitx][hity]));

                    PlayerProp.changeAmmo(((GiftDecorator) (maze.getMaze()[hitx][hity])).getAmmoEffect());
                    System.out.println( PlayerProp.getAmmo()+" " + PlayerProp.getScore());
                  }
                  else
                  {
                ME.changeCell(hitx, hity, new ArmorGiftDecorator((Gift)maze.getMaze()[hitx][hity]));
                                        context_A.setState(new HittingBombWithArmorState());
                    PlayerProp.setArmor(((GiftDecorator) (maze.getMaze()[hitx][hity])).isArmorEffect());
                    System.out.println( PlayerProp.isArmor()+" " + PlayerProp.getScore());
                
                  }
                  }
                  else 
                  {
                      ME.changeCell(hitx, hity, new DestroyedGift((Gift)maze.getMaze()[hitx][hity]));
                      PlayerProp.changeScore(-150);
                                                              System.out.println(   PlayerProp.getScore());

                  }
            }
         
                  else if (maze.getMaze()[hitx][hity] instanceof Bullet)
                  {
                         c = new cell() ;
                      ME.changeCell(hitx, hity, c);
        }
        }
    }


    @Override
    public InfoPanel getInfoPanel() {
       return IP ;
    }
    
        public void WinCondition ()
    {int Min = 0 , Sec = 0 ;
        win.setVisible(true);
        String[] TimeSplit = timer.getText().split(":");
                Min = Integer.parseInt(TimeSplit[0]);
                Sec = Integer.parseInt(TimeSplit[1]);
        int totalScore ;
        totalScore = PlayerProp.getScore()  - ((Min*60 + Sec)*2 ) ;
        t.setText(String.format("%05d", totalScore));
    }
        
            public void LoseCondition ()
    {
        lose.setVisible(true);
    }
    
}
