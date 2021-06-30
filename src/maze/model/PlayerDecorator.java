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
public class PlayerDecorator extends player{
    
      protected player decoratedPlayer ;

    public PlayerDecorator(player decoratedPlayer) {
        this.decoratedPlayer = decoratedPlayer;
    }
    
        @Override
    public Image getContains ()
    {
        return decoratedPlayer.getContains();
    }
    
}
