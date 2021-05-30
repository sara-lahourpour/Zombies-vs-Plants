package PvsZ.Controller;

import PvsZ.Boundary.GameFrame;
import PvsZ.Boundary.MainFrame;
import PvsZ.Boundary.MenuFrame;
import PvsZ.Boundary.SettingFrame;
import PvsZ.Entity.Sound.Sound;
import PvsZ.Entity.ThreadPool;

import javax.swing.*;

public class MainController {

    private MenuFrame menuFrame;
    private MainFrame mainFrame;
    private GameFrame frame;
    private GameLoop gameloop;
    private SettingFrame settingFrame;

    /**
     * constructor
     * @param mainFrame main frame
     */
    public MainController(MainFrame mainFrame){
        this.mainFrame=mainFrame;
        init();
    }

    /**
     * initialize the main frame
     */
    private void init(){
        mainFrame.setMainController(this);
    }


    /**
     * new game
     */
    public void newGame(){

        mainFrame.dispose();

        frame = new GameFrame();
        frame.setLocationRelativeTo(null); // put frame at center of screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.initBufferStrategy();
        gameloop = new GameLoop(frame);
        gameloop.init();
        ThreadPool.init();
        ThreadPool.execute(gameloop);

    }

    /**
     * load game
     */
    public void loadGame(){

    }

    /**
     * show ranking board
     */
    public void showRanking(){

    }

    /**
     * set the difficulty
     * @param type 0 is normal and 1 is hard
     */
    public void setDifficulty(int type){
        settingFrame.dispose();
    }

    /**
     * show th setting to set the difficulty
     */
    public void showSetting(){
        settingFrame=new SettingFrame();
        settingFrame.setVisible(true);
        settingFrame.setMainController(this);
    }

    /**
     * quite game
     */
    public void quietGame(){
        mainFrame.dispose();
        System.exit(0);

    }

    /**
     * show the game menu
     */
    public void showMenu(){
        menuFrame=new MenuFrame();
        menuFrame.setMainController(this);
        menuFrame.setVisible(true);
    }

    /**
     * resume the game
     */
    public void resumeGame(){

        gameloop.setMainController(this);
        gameloop.getState().setPaused(false);
        menuFrame.dispose();
    }

    /**
     * new game
     */
    public void saveGame(){

    }

    /**
     * exit to main menu
     */
    public void exitToMainMenu(){

        gameloop.getState().setEnd(true);
        frame.dispose();

    }


}
