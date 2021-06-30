/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze.view;


import java.awt.Event;
import java.io.File;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
//import maze.controller.CareTaker;
//import maze.controller.CareTaker;
import maze.controller.GameController;
import maze.controller.GameEngine;
import maze.controller.MazeEngine;
import maze.controller.Observer;
import maze.controller.Originator;
import maze.controller.Subject;
import maze.model.PlayerProp;
import maze.model.cell;
import maze.model.maze;
import maze.model.player;

/**
 *
 * @author wadiebishoy
 */
public class FXMLDocumentController  implements Initializable  {
   
    
    int playerX = 0 ;
    int playerY = 0 ;
    int x = -10  ;
    int y = -10 ;
    boolean bullet = false ;
    AnimationTimer gameLoop ;
    BulletImage BI = new BulletImage() ;
    
    MazeEngine ME = new MazeEngine() ;
    GameEngine GE = new GameController();
    
    int i ;
    static int Seconds = 0;
    static int Minutes = 0;
    static int MilliSeconds = 0;
    static int Min = 0;
    static int Sec = 0;
    int HighestScore;
    String Time;

    Originator originatorObject = new Originator();
//    CareTaker careTakerObject = new CareTaker();
    static boolean state = true;
    
    
     @FXML
    private AnchorPane BasePane;

    @FXML
    private Pane StartPane;

    @FXML
    private Button StartGame;

    @FXML
    private Button Load;

    @FXML
    private Button ExitStart;

    @FXML
    private Pane GamePane;

    @FXML
    private Pane Puase;

            @FXML
    private Pane GameOverPane;
    
    @FXML
    private Pane WinPane;
    
    @FXML
    private Text Timer;

    @FXML
    private Text Score;

    @FXML
    private Text HighScore;

    @FXML
    private Text NewHighScore;

    @FXML
    private Text ammoLabel;
    
    @FXML
    private Label Health;

    @FXML
    private Button Pause;

    @FXML
    private Label NewHighScoreLabel;

    @FXML
    private Button Test;
    
    @FXML
    private Canvas mazeCanvas;

    @FXML
    private Pane PausePane;

    @FXML
    private Button Continue;

    @FXML
    private Button Exit;

    @FXML
    private Button Save;

    @FXML
    private Button RestartGame;
    
        @FXML
    private Button Exit1;
    
        
    @FXML
    private Text EditedScore;

    @FXML
    private Button BackGameOver;
    
            @FXML
    private Button Exit11;
    
        MediaPlayer mediaPlayer;

                @FXML
    void Exit1(ActionEvent event) {
        System.exit(0);

    }
    
            @FXML
    void BackButton(ActionEvent event) {
        StartPane.setVisible(true);
        GamePane.setVisible(false);
    }
    
                @FXML
    void BackGameOver(ActionEvent event) {
        StartPane.setVisible(true);
        GamePane.setVisible(false);
    }
    
        public void playMusic(String Name) {

        try {
            String URI = new File(Name).toURI().toString();
            mediaPlayer = new MediaPlayer(new Media(URI));
            mediaPlayer.setCycleCount(mediaPlayer.INDEFINITE); // this make it infinte loop 
            mediaPlayer.play();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     @FXML
    void ContinueButton(ActionEvent event) {
        PausePane.setVisible(false);
        UpdateInfoBar();
        mediaPlayer.play();
    }

    @FXML
    void Exit(ActionEvent event) {
        System.exit(0);
        Pause();
    }
    
            @FXML
    void Exit1Button(ActionEvent event) {
        System.exit(0);

    }

    @FXML
    void LoadButton(ActionEvent event) {
//        Time = originatorObject.restoreTime(careTakerObject.load()); // and the same for the rest

    }

    @FXML
    void PauseButton(ActionEvent event) {
        Pause();
        PausePaneOpacity();
        //mediaPlayer.pause();
        setHealth(20);
    }

        void PausePaneOpacity() {
        PausePane.setOpacity(0.5);
        PausePane.setVisible(true);
    }
        
    @FXML
    void RestartGameButton(ActionEvent event) {
        Reset();
        UpdateInfoBar();
        PausePane.setVisible(false);
        Health.setMaxWidth(134);
        Health.setMinWidth(134);
        Health.setStyle("-fx-background-color: #9a3b23");
    }

    @FXML
    void SaveButton(ActionEvent event) {
        int score = Integer.parseInt(Score.getText());
//         careTakerObject.save(originatorObject.storeInMemento(maze.getMaze(), GE.getInfoPanel().getAmmo(), GE.getInfoPanel().isArmor(), GE.getInfoPanel().getAmmo(), Timer.getText() , GE.getInfoPanel().getHealth()));// you will give me the maze and the state and the ammo
    }

    @FXML
    void StartGameButton(ActionEvent event) {
        StartPane.setVisible(false);
        GamePane.setVisible(true);
                WinPane.setVisible(false);
        GameOverPane.setVisible(false);
        PausePane.setVisible(false);
        
                PlayerProp.reset();
        Reset();
        UpdateInfoBar();
                GE.GenerateMaze(mazeCanvas , WinPane , GameOverPane , EditedScore ,Timer);        
        
        mazeCanvas.setFocusTraversable(true);
        mazeCanvas.setOnKeyPressed(GE.controls());
        

      gameLoop = GE.gameLoop() ;
      gameLoop.start();
      
    }

    void UpdateInfoBar() {
        Thread thread = new Thread() {

            @Override
            public void run() {
                state = true;
                for (;;) {
                    if (state == true) {
                        try {
                            sleep(1);
                          
                         setHealth(GE.getInfoPanel().getHealth());
                         setArmor(GE.getInfoPanel().isArmor());
                         setScore(GE.getInfoPanel().getScore());
                            setAmmo(GE.getInfoPanel().getAmmo());
                         
//                            if (Health.getWidth() == 0)
//                            {
//                                System.out.println(GE.getInfoPanel().getHealth());
//                                LoseCondition();
//                            }
                            
//                            if (GE.getFinish().equalsIgnoreCase("win"))
//                            {
//                                System.out.println("ho");
//                                WinCondition();
//                            }
                            
                            if (MilliSeconds > 1000) {
                                MilliSeconds = 0;
                                Seconds++;
                            }
                            if (Seconds > 59) {
                                MilliSeconds = 0;
                                Seconds = 0;
                                Minutes++;
                            }
                            MilliSeconds++;
                            if (Minutes < 10 && Seconds < 10) {
                                Timer.setText("0" + Minutes + ":0" + Seconds);

                            } else if (Minutes < 10 && Seconds > 9) {
                                Timer.setText("0" + Minutes + ":" + Seconds);

                            } else {
                                Timer.setText(Minutes + ":" + Seconds);

                            }
                        } catch (Exception e) {

                        }

                    } else {
                        break;
                    }

                }

            }
        };
        thread.start();
    }
    
        void Reset() {
        state = false;
        MilliSeconds = 0;
        Seconds = 0;
        Minutes = 0;
        Timer.setText("00:00");
    }

    void Pause() {
        state = false;

    }
    
    public void WinCondition ()
    {
        WinPane.setVisible(true);
        String[] TimeSplit = Timer.getText().split(":");
                Min = Integer.parseInt(TimeSplit[0]);
                Sec = Integer.parseInt(TimeSplit[1]);
        int totalScore ;
        totalScore = GE.getInfoPanel().getScore()  - ((Min*60 + Sec)*2 ) ;
        EditedScore.setText(String.format("%05d", totalScore));
    }
    
    public void LoseCondition ()
    {
        GameOverPane.setVisible(true);
    }
    
    void starttimeAfterLoad(String TimeString) {
        Thread thread = new Thread() {

            @Override
            public void run() {
                Timer.setText("00:00");
                String[] TimeSplit = TimeString.split(":");
                Min = Integer.parseInt(TimeSplit[0]);
                Sec = Integer.parseInt(TimeSplit[1]);
                state = true;
                for (;;) {
                    if (state == true) {
                        try {
                            sleep(1);

                            if (MilliSeconds > 1000) {
                                MilliSeconds = 0;
                                Sec++;
                            }
                            if (Sec > 59) {
                                MilliSeconds = 0;
                                Sec = 0;
                                Min++;
                            }
                            MilliSeconds++;
                            System.out.println(Min + ":" + Sec);
                            if (Min < 10 && Sec < 10) {
                                Timer.setText("0" + Min + ":0" + Sec);

                            } else if (Min < 10 && Sec > 9) {
                                Timer.setText("0" + Min + ":" + Sec);

                            } else {
                                Timer.setText(Min + ":" + Sec);

                            }
                        } catch (Exception e) {

                        }

                    } else {
                        Minutes = Min;
                        Seconds = Sec;
                        break;
                    }

                }

            }
        };
        thread.start();
    }
    
        void setHealth(double number) {
        Health.setMaxWidth(134 * (number / 100));
        Health.setMinWidth(134 * (number / 100));
    }
        
                void setArmor(boolean armor) {
        if (armor)
        {
            Health.setStyle("-fx-background-color: yellow");
        }
        else
        {
            Health.setStyle("-fx-background-color: #9a3b23");
        }
    }
    
                 void setScore(int number) {
       Score.setText(String.format("%05d", number));
    }
         
            void setAmmo(int number) {
            ammoLabel.setText(String.format("%d X", number));
    }             
                 
    @FXML
    void TestButton(ActionEvent event) {
        Pause();
        starttimeAfterLoad(Time);
        Health.setStyle("-fx-background-color: yellow");
//        displayAmmo(2);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
          StartPane.setVisible(true);
          NewHighScore.setVisible(false);
        GamePane.setVisible(false);
        Health.setVisible(true);
        WinPane.setVisible(false);
        GameOverPane.setVisible(false);
        PausePane.setVisible(false);
        playMusic("Retro Music.mp3");
    
}

}
