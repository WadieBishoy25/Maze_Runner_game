/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze.controller;

import javafx.scene.image.Image;
import maze.model.maze;

/**
 *
 * @author wadiebishoy
 */
public class RightDirectionState implements MovingDirectionState {

    @Override
    public void MovingDirection( int x, int y) {
        maze.getMaze()[x][y].setContains(new Image("tumblr_mp129kjfOw1r2pz7go1_500.gif"));
    }
    
}
