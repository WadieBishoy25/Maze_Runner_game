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
public class SmallBomb extends Bomb{ 

    public SmallBomb() {
        healthEffect = -20 ;
        contains = new Image("cf8800006625ade.png") ;
    }
    
}
