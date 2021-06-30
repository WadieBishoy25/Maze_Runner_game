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
public class Wall {
    protected Image wallHImage ;
    protected Image wallVImage ;
    protected boolean breakable ;

    public boolean isBreakable() {
        return breakable;
    }

    public Image getWallHImage() {
        return wallHImage;
    }

    public Image getWallVImage() {
        return wallVImage;
    }

    
    
}
