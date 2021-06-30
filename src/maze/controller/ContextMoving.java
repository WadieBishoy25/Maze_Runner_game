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
public class ContextMoving implements MovingDirectionState{

     private MovingDirectionState state ;

    public ContextMoving() {
        this.state = new RightDirectionState() ;
    }

    public MovingDirectionState getState() {
        return state;
    }

    public void setState(MovingDirectionState state) {
        this.state = state;
    }

    @Override
    public void MovingDirection(int x, int y) {
        this.state.MovingDirection(x, y);
    }
    
}
