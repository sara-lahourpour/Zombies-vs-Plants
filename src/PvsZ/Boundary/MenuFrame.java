package PvsZ.Boundary;

import PvsZ.Controller.MainController;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuFrame extends JFrame {

    public static final int Width=400;
    public static final int Height=400;

    private MainController mainController;
    private MouseHandler mouseHandler;

    private JButton save_but;
    private JButton resume_but;
    private JButton exit_bu;

    /**
     * constructor
     */
    public MenuFrame(){

        mouseHandler=new MouseHandler();

        setSize(Width,Height);
        setLocationRelativeTo(null);
        setLayout(null);

        setButtons();

        repaint();
        revalidate();

    }


    /**
     * set the buttons
     */
    private void setButtons(){

        save_but=new JButton("Save Game");
        save_but.addMouseListener(mouseHandler);

        resume_but=new JButton("Resume Game");
        resume_but.addMouseListener(mouseHandler);

        exit_bu=new JButton("Exit to Main Menu");
        exit_bu.addMouseListener(mouseHandler);


        save_but.setBounds(20,50,100,20);
        resume_but.setBounds(140,50,100,20);
        exit_bu.setBounds(50,90,100,20);


        add(save_but);
        add(resume_but);
        add(exit_bu);


    }


    /**
     * set the main controller
     * @param mainController main controller
     */
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }


    /**
     * set the mouse handler
     */
    private class MouseHandler extends MouseAdapter{

        @Override
        public void mouseClicked(MouseEvent e) {

            if (e.getSource().equals(save_but)){
                mainController.saveGame();
            }else if (e.getSource().equals(resume_but)){
                mainController.resumeGame();
            }else if (e.getSource().equals(exit_bu)){
                mainController.exitToMainMenu();
            }

        }

    }


}
