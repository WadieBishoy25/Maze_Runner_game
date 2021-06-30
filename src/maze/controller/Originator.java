package maze.controller;

import maze.model.cell;

public class Originator {


    public Memento storeInMemento( cell[][] maze ,int Ammo ,boolean Armor ,int Score ,String Time  ,int health ) {
        return new Memento(maze, Time, Score, Armor, Ammo ,health);
    }

    public cell [][] restoreMaze(Memento memento) {
        return memento.getMaze();
    }

    public String restoreTime(Memento memento) {
        return memento.getTime();
    }

    public int restoreScore(Memento memento) {
        return memento.getScore();
       
    }

    public boolean restoreArmorState(Memento memento) {
        return memento.isArmor();
        
    }

    public int restoreAmmo(Memento memento) {
       return memento.getAmmo();
       
    }
    
        public int restoreHealth(Memento memento) {
       return memento.getHealth();
       
    }
}
