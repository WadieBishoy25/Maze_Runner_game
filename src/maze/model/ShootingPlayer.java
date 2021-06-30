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
public class ShootingPlayer extends PlayerDecorator{
    
    public ShootingPlayer(player decoratedPlayer) {
        super(decoratedPlayer);
    }
    
    @Override
       public Image getContains ()
    {
       decoratedPlayer.setContains(new Image("thQ1OTJLUB5iuui.png"));
       return decoratedPlayer.getContains() ;
    }
}
