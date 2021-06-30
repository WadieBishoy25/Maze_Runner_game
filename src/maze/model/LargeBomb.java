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
public class LargeBomb extends Bomb{

    public LargeBomb() {
        healthEffect = -50 ;
        contains = new Image("0e272a6444aad3a.png") ;
    
    }
    
}
