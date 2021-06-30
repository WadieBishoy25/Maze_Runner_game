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
public class GiftDecorator extends Gift {
    
        protected Gift decoratedGift ;

    public GiftDecorator(Gift decoratedGift) {
        this.decoratedGift = decoratedGift;
    }
    
        @Override
    public Image getContains ()
    {
        return decoratedGift.getContains();
    }
    
    public int getHealthEffect() {
        return ((HealthGift)decoratedGift).getHealthEffect();
    }
    
        public int getAmmoEffect() {
        return ((AmmoGift)decoratedGift).getAmmoEffect();
    }
    public boolean isArmorEffect() {
        return ((ArmorGift)decoratedGift).isArmorEffect();
    }
}
