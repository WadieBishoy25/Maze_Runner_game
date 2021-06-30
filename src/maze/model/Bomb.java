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
public abstract class Bomb extends cell {
    
    protected int healthEffect ;

    public int getHealthEffect() {
        return healthEffect;
    }
    
}
