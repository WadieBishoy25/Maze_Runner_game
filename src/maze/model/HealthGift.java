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
public class HealthGift extends Gift{

    int healthEffect ;

    public int getHealthEffect() {
        return healthEffect;
    }
    
    public HealthGift() {
       healthEffect = 50 ;
    }
    
}
