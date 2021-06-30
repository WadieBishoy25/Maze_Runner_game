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
public class BombDecorator extends Bomb{
    
    protected Bomb decoratedBomb ;

    public BombDecorator(Bomb decoratedBomb) {
        this.decoratedBomb = decoratedBomb;
    }
    
    @Override
    public Image getContains ()
    {
        return decoratedBomb.getContains();
    }
    
    @Override
    public int getHealthEffect() {
        return decoratedBomb.getHealthEffect();
    }
    
}
