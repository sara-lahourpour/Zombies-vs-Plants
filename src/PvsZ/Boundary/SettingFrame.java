package PvsZ.Boundary;

import PvsZ.Controller.MainController;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SettingFrame extends JFrame {

    public static final int Width=200;
    public static final int Height=200;

    private MouseHandler mouseHandler;
    private MainController mainController;

    private JCheckBox normal_box;
    private JCheckBox hard_box;

    private JButton ok_but;


    /**
     * constructor
     */
    public SettingFrame(){

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

        normal_box=new JCheckBox("Normal");

        hard_box=new JCheckBox("Hard");

        ok_but=new JButton("OK");
        ok_but.addMouseListener(new MouseHandler());

        normal_box.setBounds(20,50,100,20);
        hard_box.setBounds(20,90,100,20);
        ok_but.setBounds(50,130,100,20);

        add(normal_box);
        add(hard_box);
        add(ok_but);

    }


    /**
     * setter of main controller
     * @param mainController main controller
     */
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }



    /**
     * handle the mouse
     */
    private class MouseHandler extends MouseAdapter{


        @Override
        public void mouseClicked(MouseEvent e) {
            int type = 0;
            if (e.getSource().equals(ok_but)){
                if (hard_box.getText().equals("Hard")){
                    type=1;
                }
                mainController.setDifficulty(type);
            }

        }

    }

}
