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
public class HealthGiftDecorator extends GiftDecorator{
    
    public HealthGiftDecorator(Gift decoratedGift) {
        super(decoratedGift);
    }
    
        @Override
    public Image getContains ()
    {
       decoratedGift.setContains(new Image("RQv1N68Rla3N0eUj7YsxojuH_400x400.png"));
       return decoratedGift.getContains() ;
    }
}
