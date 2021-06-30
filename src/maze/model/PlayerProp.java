/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze.model;

import java.util.Observable;
import java.util.Observer;


/**
 *
 * @author wadiebishoy
 */
public class PlayerProp extends Observable{
        
    private static int health = 100 ;
    private static int ammo =8 ;
    private static boolean armor = false  ;
    private static int score = 0 ;
   
    
    private PlayerProp ()
    {}

    public static int getHealth() {
        return health;
    }

    public static void changeHealth(int health) {
        PlayerProp.health += health;
        if (PlayerProp.health > 100)
            PlayerProp.health = 100 ;
        if (PlayerProp.health < 0)
            PlayerProp.health = 0 ;
       
    }

    public static void reset ()
    {
        health = 100 ;
         ammo =8 ;
         armor = false  ;
         score = 0 ;
    }
    
    public static int getAmmo() {
        return ammo;
    }

    public static void changeAmmo(int ammo) {
        PlayerProp.ammo += ammo;
                if (PlayerProp.ammo > 10)
            PlayerProp.ammo = 10 ;
        if (PlayerProp.ammo < 0)
            PlayerProp.ammo = 0 ;
        
       
    }

    public static boolean isArmor() {
        return armor;
    }

    public static void setArmor(boolean armor) {
        PlayerProp.armor = armor;
    }

    public static int getScore() {
        return score;
    }

    public static void changeScore(int score) {
        PlayerProp.score += score;
        if (PlayerProp.score < 0)
            PlayerProp.score = 0 ;
    }
    
}
