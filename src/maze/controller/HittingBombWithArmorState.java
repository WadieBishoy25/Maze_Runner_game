/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze.controller;

import maze.model.PlayerProp;

/**
 *
 * @author wadiebishoy
 */
public class HittingBombWithArmorState implements ArmorState {

    @Override
    public void bombHit(ContextArmor context , int healthEffect ) {
        PlayerProp.setArmor(false);
        context.setState(new HittingBombWithoutArmorState());
    }
    
}
