/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze.controller;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import maze.model.cell;
import maze.view.InfoPanel;

/**
 *
 * @author wadiebishoy
 */
public interface GameEngine {
    
    public void GenerateMaze (Object canvas , Pane win , Pane lose , Text t ,Text timer );
    
    public AnimationTimer gameLoop ();
    
    public EventHandler<KeyEvent> controls ();
    
    public InfoPanel getInfoPanel ();

    }
