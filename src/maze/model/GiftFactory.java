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
public class GiftFactory {
    
     public cell getGift (String giftType )
    {
        Gift gift = null ;
        
        switch (giftType)
        {
            case "health" :
            {
                gift = new HealthGift();
                break;
            }
            case "ammo" :
            {
                gift = new AmmoGift();
                break;
            }
             case "armor" :
            {
                gift = new ArmorGift();
                break;
            }
            default:
                 {
                gift = new HealthGift();
                break;
            }
        }
        
        return gift ;
    }
}
