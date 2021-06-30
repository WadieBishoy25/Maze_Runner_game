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
public class ExplosionBomb extends BombDecorator{
    
    public ExplosionBomb(Bomb decoratedBomb) {
        super(decoratedBomb);
    }
    
    @Override
    public Image getContains ()
    {
       decoratedBomb.setContains(new Image("240074717073212.png"));
       return decoratedBomb.getContains() ;
    }
}
