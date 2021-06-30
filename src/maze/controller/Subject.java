/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze.controller;

import java.util.Observable;
import maze.model.PlayerProp;

/**
 *
 * @author wadiebishoy
 */
public class Subject {
    
    private int health ;
    private int ammo ;
    private int score ;
    private boolean armor ;
    
    private Observer observer ;
    
//  public int getState() {
//      return state;
//   }

   public void setState() {
     health = PlayerProp.getHealth();
      ammo = PlayerProp.getAmmo();
       score = PlayerProp.getScore();
        armor = PlayerProp.isArmor();
      
      notifyAllObservers();
   }

   public void attach(Observer observer){
      this.observer = observer ;		
   }

   public void notifyAllObservers(){
         observer.update();
      
         
}

    public int getHealth() {
        return health;
    }

    public int getAmmo() {
        return ammo;
    }

    public int getScore() {
        return score;
    }

    public boolean isArmor() {
        return armor;
    }
}
