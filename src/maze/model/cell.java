/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze.model;

import javafx.scene.image.Image;

/**
 *
 * @author wadiebishoy
 */
public class cell {
    
    int x ,y ;
    
    protected boolean [] walls = {true,true,true,true} ;
    protected boolean visited = false ;
    protected Image contains  ;
    protected boolean [] breakableWalls = {false,false,false,false} ;
    
    public void setContains(Image contains) {
        this.contains = contains;
    }

    public Image getContains() {
        return contains;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
        
    public void clone (cell c)
    {
        this.visited = c.isVisited();
        this.x = c.getX();
        this.y = c.getY();
        this.walls = c.getWalls();
        this.breakableWalls = c.getBreakableWalls() ;
    }
    public boolean[] getWalls() {
        return walls;
    }

    public boolean[] getBreakableWalls() {
        return breakableWalls;
    }

    public void addBreakableWall(int x) {
        this.breakableWalls [x] = true ;
    }
    
        public void removeBreakableWall(int x) {
        this.breakableWalls [x] = false ;
    }
    
        public void removeallBreakableWalls() {
        this.breakableWalls [0] = false ;
        this.breakableWalls [1] = false ;
        this.breakableWalls [2] = false ;
        this.breakableWalls [3] = false ;

    }
}
