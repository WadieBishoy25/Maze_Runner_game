/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze.view;

import maze.controller.Observer;
import maze.controller.Subject;

/**
 *
 * @author wadiebishoy
 */
public class InfoPanel extends Observer{

        private int health ;
    private int ammo ;
    private int score ;
    private boolean armor ;
    
    
     public InfoPanel(Subject subject){
      this.subject = subject;
      this.subject.attach(this);
   }

    @Override
    public void update() {
       health = subject.getHealth();
       ammo = subject.getAmmo();
       score = subject.getScore();
       armor = subject.isArmor() ;
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

