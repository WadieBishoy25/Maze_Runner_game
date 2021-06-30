/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze.model;

/**
 *
 * @author wadiebishoy
 */
public class maze {
    
    private static cell[][] m = new cell[20][30] ;

        private maze (){}
        
    public static cell[][] getMaze() {
        return m;
    }

    public static void setMaze(cell[][] m) {
        maze.m = m;
    }
    

}
