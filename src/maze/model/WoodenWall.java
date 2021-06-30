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
public class WoodenWall extends Wall{
    
        public WoodenWall() {
        
        wallVImage = new Image("Untitled-8e.png");
        wallHImage = new Image("Untitled-8.png");
        breakable = true ;
    }
}
