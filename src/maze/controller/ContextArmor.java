/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze.controller;

/**
 *
 * @author wadiebishoy
 */
public class ContextArmor implements ArmorState{
    
    private ArmorState state ;

    public ContextArmor() {
        this.state = new HittingBombWithoutArmorState();
    }

    public ArmorState getState() {
        return state;
    }

    public void setState(ArmorState state) {
        this.state = state;
    }

    @Override
    public void bombHit(ContextArmor context, int healthEffect) {
        this.state.bombHit(this, healthEffect);
    }
    
    
    
}
