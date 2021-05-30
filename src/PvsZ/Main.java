package PvsZ;

import PvsZ.Boundary.GameFrame;
import PvsZ.Boundary.MainFrame;
import PvsZ.Controller.GameLoop;
import PvsZ.Controller.MainController;
import PvsZ.Entity.Sound.Sound;
import PvsZ.Entity.ThreadPool;

import javax.swing.*;
import java.awt.*;

/**
 * Program start.
 *
 * @author Seyed Mohammad Ghaffarian
 */
public class Main {

    public static void main(String[] args) {
        // Initialize the global thread-pool
//        ThreadPool.init();

        // Show the game menu ...

        // After the player clicks 'PLAY' ...
//        EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                GameFrame frame = new GameFrame();
//                frame.setLocationRelativeTo(null); // put frame at center of screen
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                frame.setVisible(true);
//                frame.initBufferStrategy();
//                Sound sound=new Sound();
//                sound.setSong("res/Sounds/background.wav");
//                sound.run();
//                // Create and execute the game-loop
                MainFrame mainFrame=new MainFrame();
                MainController mainController=new MainController(mainFrame);
//                mainFrame.render();
//                mainFrame.setVisible(true);
//                JFrame main=new JFrame();
//                main.add(mainFrame);
//                main.setSize(1280,720);
//                main.setVisible(true);
//                GameLoop game = new GameLoop(frame);
//                game.init();
//                ThreadPool.execute(game);
//                ThreadPool.execute(sound);
                // and the game starts ...
//            }
//        });
    }
}
