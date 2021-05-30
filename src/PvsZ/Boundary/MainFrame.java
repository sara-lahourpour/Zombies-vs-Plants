package PvsZ.Boundary;



import PvsZ.Controller.MainController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class MainFrame extends JFrame {

    private MainController mainController;

    private MouseHandler mouseHandler;

    public static final int GAME_HEIGHT = 720;                  // 720p game resolution
    public static final int GAME_WIDTH = 16 * GAME_HEIGHT / 9;  // wide aspect ratio


//    private BufferStrategy bufferStrategy;
//
//
//    private BufferedImage image;

    private JButton newGame_but;
    private JButton loadGame_but;
    private JButton ranking_but;
    private JButton setting_but;
    private JButton quitGame_but;


    /**
     * constructor
     *
     */
    public MainFrame(){

        mouseHandler=new MouseHandler();

        setSize(GAME_WIDTH,GAME_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setButtons();
//        initBufferStrategy();

        repaint();
        revalidate();


    }



//    private void doRendering(Graphics2D g2d) {
//
//        try {
//            image= ImageIO.read(new File("res/Pictures/Background/first_screen.jpg"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        g2d.drawImage(image, 0, 0, GAME_WIDTH, GAME_HEIGHT, null);
//
//        setButtons();
//
//    }




    /**
     * set the buttons
     */
    private void setButtons(){

        newGame_but=new JButton("New Game");
        newGame_but.addMouseListener(mouseHandler);

        loadGame_but=new JButton("Load Game");
        loadGame_but.addMouseListener(mouseHandler);

        ranking_but=new JButton("Ranking");
        ranking_but.addMouseListener(mouseHandler);

        setting_but=new JButton("Setting");
        setting_but.addMouseListener(mouseHandler);

        quitGame_but=new JButton("Quit Game");
        quitGame_but.addMouseListener(mouseHandler);


        newGame_but.setBounds(GAME_WIDTH-100,100,100,50);
        loadGame_but.setBounds(GAME_WIDTH-100,200,100,50);
        ranking_but.setBounds(GAME_WIDTH-100,300,100,50);
        setting_but.setBounds(GAME_WIDTH-100,400,100,50);
        quitGame_but.setBounds(GAME_WIDTH-100,500,100,50);

        add(newGame_but);
        add(loadGame_but);
        add(ranking_but);
        add(setting_but);
        add(quitGame_but);


    }

    /**
     * set the controller to main frame
     * @param mainController main controller
     */
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }


//    @Override
//    public void paintComponents(Graphics g) {
//        super.paintComponents(g);
//
//        try {
//            image= ImageIO.read(new File("res/Pictures/Background/first_screen.jpg"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Graphics2D g2d = (Graphics2D) g;
//        g2d.drawImage(image, 0, 0, GAME_WIDTH, GAME_HEIGHT, null);
//
//
//    }

    private class MouseHandler extends MouseAdapter{



        @Override
        public void mouseClicked(MouseEvent e) {

            if (e.getSource().equals(newGame_but)){
                mainController.newGame();
            }else if (e.getSource().equals(loadGame_but)){

            }else if (e.getSource().equals(ranking_but)){

            }else if (e.getSource().equals(setting_but)){
                mainController.showSetting();
            }else if (e.getSource().equals(quitGame_but)){
                mainController.quietGame();
            }

        }

    }





}
