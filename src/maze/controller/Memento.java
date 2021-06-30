package maze.controller;

import maze.model.cell;

public class Memento {
    private cell [][] maze;
    private String Time;
    private int Score;
    private boolean Armor;
    private int Ammo;
    private int health ;

    public Memento(cell[][] maze ,String Time, int Score, boolean Armor, int Ammo, int health) {
        this.maze = maze;
        this.Time = Time;
        this.Score = Score;
        this.Armor = Armor;
        this.Ammo = Ammo;
          this.health = health;

    }

    public cell[][] getMaze() {
        return maze;
    }

    public String getTime() {
        return Time;
    }

    public int getScore() {
        return Score;
    }

    public boolean isArmor() {
        return Armor;
    }

    public int getAmmo() {
        return Ammo;
    }

    public int getHealth() {
        return health;
    }
    
    
    
    
}
