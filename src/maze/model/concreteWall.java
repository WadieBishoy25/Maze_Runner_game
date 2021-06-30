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
public class concreteWall extends Wall{

    public concreteWall() {
        
        wallVImage = new Image("Untitled-2ad.png");
        wallHImage = new Image("Untitled-4s.png");
        breakable = false ;
    }
    
    
}
