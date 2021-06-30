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
public class BombFactory {
    
    public cell getBomb (String bombType )
    {
        Bomb bomb = null ;
        
        switch (bombType)
        {
            case "small" :
            {
                bomb = new SmallBomb() ;
                break;
            }
            case "large" :
            {
                bomb = new LargeBomb() ;
                break;
            }
            default:
                 {
                bomb = new SmallBomb() ;
                break;
            }
        }
        
        return bomb ;
    }
}
