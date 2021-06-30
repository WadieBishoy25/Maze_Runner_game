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
public class ArmorGiftDecorator extends GiftDecorator {
    
    public ArmorGiftDecorator(Gift decoratedGift) {
        super(decoratedGift);
    }
    
        
            @Override
    public Image getContains ()
    {
       decoratedGift.setContains(new Image("AcXuzr.png"));
       return decoratedGift.getContains() ;
    }
}
