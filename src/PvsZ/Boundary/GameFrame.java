package PvsZ.Boundary;

import PvsZ.Entity.Bullets.Pea;
import PvsZ.Entity.Cards.Card;
import PvsZ.Entity.GameState;
import PvsZ.Entity.Plants.Plant;
import PvsZ.Entity.Sun.Sun;
import PvsZ.Entity.Zombies.Zombie;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ListIterator;


/**
 * GameFrame is a class which paints all the elements of PlantVsZombies game
 * it will use graphic2D and GameState , the state of all elements
 *
 *
 * @author saralahourpour
 * @since 2/1/2021
 * @version 0.0
 *
 *
 */
public class GameFrame extends JFrame{


    public static final int GAME_HEIGHT = 720;                  // 720p game resolution
    public static final int GAME_WIDTH = 16 * GAME_HEIGHT / 9;  // wide aspect ratio

    private BufferStrategy bufferStrategy;


    /**
     * constructor
     *
     *
     *
     */
    public GameFrame() {

//        super("PvsZ");

        setSize(GAME_WIDTH,GAME_HEIGHT);
        setIconImage(new ImageIcon("res/Pictures/Icon/pvsz_icon.png").getImage());
        setResizable(false);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setFocusable(true);
//        setVisible(true);
//        initBufferStrategy();


    }

    /**
     * This must be called once after the JFrame is shown: frame.setVisible(true);
     * and before any rendering is started.
     */
    public void initBufferStrategy() {
        // Triple-buffering
        createBufferStrategy(3);
        bufferStrategy = getBufferStrategy();

    }

    /**
     * Game rendering with triple-buffering using BufferStrategy.
     */
    public void render(GameState gameState) {
        // Render single frame
        do {
            // The following loop ensures that the contents of the drawing buffer
            // are consistent in case the underlying surface was recreated
            do {
                // Get a new graphics context every time through the loop
                // to make sure the strategy is validated
                Graphics2D graphics = (Graphics2D) bufferStrategy.getDrawGraphics();
                try {
                    doRendering(graphics, gameState);
                } finally {
                    // Dispose the graphics
                    graphics.dispose();
                }
                // Repeat the rendering if the drawing buffer contents were restored
            } while (bufferStrategy.contentsRestored());

            // Display the buffer
            bufferStrategy.show();
            // Tell the system to do the drawing NOW;
            // otherwise it can take a few extra ms and will feel jerky!
            Toolkit.getDefaultToolkit().sync();

            // Repeat the rendering if the drawing buffer was lost
        } while (bufferStrategy.contentsLost());
    }

    /**
     * Rendering all game elements based on the game state.
     */
    private void doRendering(Graphics2D g2d, GameState gameState) {

        drawBackGround(g2d);
        drawTotalPoint(g2d,gameState);
        drawCards(g2d, gameState);
        drawShovel(g2d);
        drawLawnMowers(g2d, gameState);
        drawPlants(g2d,gameState);
        drawPeas(g2d,gameState);
        drawSuns(g2d,gameState);
        drawZombies(g2d, gameState);

//        repaint();
//        revalidate();

    }


    /**
     * draw background of game
     *
     * @param g2d graphic2D
     */
    private void drawBackGround(Graphics2D g2d){

        // Draw background
        BufferedImage image;
        try {
            image= ImageIO.read(new File("res/Pictures/Background/play_screen.png"));
            Image result_image=image.getScaledInstance(GAME_WIDTH,GAME_HEIGHT,Image.SCALE_SMOOTH);
            g2d.drawImage(result_image,0,20,GAME_WIDTH,GAME_HEIGHT,null);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * draw total point
     *
     * @param g2d graphic2D
     * @param gameState gameState
     */
    private void drawTotalPoint(Graphics2D g2d, GameState gameState){

        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Helvetica",Font.BOLD,14));
        g2d.drawString(Integer.toString(gameState.getTotalPoint()),75,110);

    }

    /**
     * draw cards
     *
     * @param g2d graphic2D
     * @param gameState gameState
     */
    private void drawCards(Graphics2D g2d, GameState gameState){

//        BufferedImage image = null;
//        try {
//            image=ImageIO.read(new File("res/Pictures/Cards/card_sunflower.png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        g2d.drawImage(image,140,30,116,90,null);

        if(gameState.getTotalPoint()>=50 && gameState.getCards().get(0).isEnable()){
            gameState.getCards().get(0).setImageName("res/Pictures/Cards/card_sunflower.png");
        }else {
            gameState.getCards().get(0).setImageName("res/Pictures/Cards/card_sunflower_unable.png");
        }
        g2d.drawImage(gameState.getCards().get(0).getImage(),140,30,116,90,null);



        if (gameState.getTotalPoint()>=100 && gameState.getCards().get(1).isEnable()){
            gameState.getCards().get(1).setImageName("res/Pictures/Cards/card_peashooter.png");
        }else {
            gameState.getCards().get(1).setImageName("res/Pictures/Cards/card_peashooter_unable.png");
        }
        g2d.drawImage(gameState.getCards().get(1).getImage(),256,30,116,90,null);



        if (gameState.getTotalPoint()>=50 && gameState.getCards().get(2).isEnable()){
            gameState.getCards().get(2).setImageName("res/Pictures/Cards/card_wallnut.png");
        }else {
            gameState.getCards().get(2).setImageName("res/Pictures/Cards/card_wallnut_unable.png");
        }
        g2d.drawImage(gameState.getCards().get(2).getImage(),372,30,116,90,null);



        if (gameState.getTotalPoint()>=175 && gameState.getCards().get(3).isEnable()){
            gameState.getCards().get(3).setImageName("res/Pictures/Cards/card_frozenpeashooter.png");
        }else {
            gameState.getCards().get(3).setImageName("res/Pictures/Cards/card_frozenpeashooter_unable.png");
        }
        g2d.drawImage(gameState.getCards().get(3).getImage(),488,30,116,90,null);



        if (gameState.getTotalPoint()>=150 && gameState.getCards().get(4).isEnable()){
            gameState.getCards().get(4).setImageName("res/Pictures/Cards/card_cherrybomb.png");
        }else {
            gameState.getCards().get(4).setImageName("res/Pictures/Cards/card_cherrybomb_unable.png");
        }
        g2d.drawImage(gameState.getCards().get(4).getImage(),604,30,116,90,null);

    }

    /**
     * draw shovel
     *
     * @param g2d graphic2D
     */
    private void drawShovel(Graphics2D g2d){

        BufferedImage image = null;
        try {
            image= ImageIO.read(new File("res/Pictures/Shovel/shovel.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        g2d.drawImage(image,740,30,116,90,null);

    }


    /**
     * draw lawnmowers
     *
     * @param g2d graphic2D
     * @param gameState gameState
     */
    private void drawLawnMowers(Graphics2D g2d, GameState gameState){

        for (int i = 0; i < gameState.getLawnMowers().size() ; i++) {
            g2d.drawImage(gameState.getLawnMowers().get(i).getImage(),
                    gameState.getLawnMowers().get(i).getX(),gameState.getLawnMowers().get(i).getY(),
                    gameState.getLawnMowers().get(i).getWidth(),gameState.getLawnMowers().get(i).getLength(),
                    null);
        }


    }

    /**
     * draw plants
     *
     * @param g2d graphic2D
     * @param gameState gameState
     */
    private void drawPlants(Graphics2D g2d, GameState gameState){

        for (Plant plant: gameState.getPlants()) {
            //g2d.drawImage(plant.getImage(), plant.getX()+50, plant.getY(), plant.getWidth()+20, plant.getLength()+20, null);
            g2d.drawImage(plant.getImage(),plant.getX(), plant.getY(),null);
        }

    }

    /**
     * draw peas
     *
     * @param g2d graphic2D
     * @param gameState gameState
     */
    private void drawPeas(Graphics2D g2d, GameState gameState){

        for (Pea pea : gameState.getPeas()) {
            g2d.drawImage(pea.getImage(), pea.getX(), pea.getY(), pea.getWidth(), pea.getLength(), null);

        }

    }

    /**
     * draw suns
     *
     * @param g2d graphic2D
     * @param gameState gameState
     */
    private void drawSuns(Graphics2D g2d, GameState gameState){

        ListIterator<Sun> itrSun=gameState.getSuns().listIterator();
        while (itrSun.hasNext()){
            Sun sun=itrSun.next();
            g2d.drawImage(sun.getImage(),sun.getX(),sun.getY(),sun.getWidth(),sun.getLength(),null);
        }

//        for (Sun sun : gameState.getSuns()) {
//              g2d.drawImage(sun.getImage(), sun.getX(), sun.getY(), sun.getWidth(), sun.getLength(), null);
//              g2d.drawImage(sun.getImage(), null,sun.getX(), sun.getY());
//            System.out.println("x location :"+sun.getX()+"  y location : "+ sun.getY());


//        }

//        for (int i = 0; i <gameState.getSuns().size(); i++) {
//            //g2d.drawImage(gameState.getSuns().get(i).getImage(),null, gameState.getSuns().get(i).getX(),gameState.getSuns().get(i).getY());
//
//            g2d.drawImage(gameState.getSuns().get(i).getImage(), gameState.getSuns().get(i).getX()
//                    , gameState.getSuns().get(i).getY(), gameState.getSuns().get(i).getWidth(),
//                    gameState.getSuns().get(i).getLength(), null);
//
////            System.out.println("x location :"+gameState.getSuns().get(i).getX()+
////                    "  y location : " + gameState.getSuns().get(i).getY()+
////                    " index :"+i);
//        }
    }

    /**
     * draw zombies
     *
     * @param g2d graphic2D
     * @param gameState gameState
     */
    private void drawZombies(Graphics2D g2d, GameState gameState){

        for (Zombie zombie : gameState.getZombies()) {
            g2d.drawImage(zombie.getImage(), zombie.getX(), zombie.getY(),zombie.getWidth(),zombie.getLength(),null);
//               g2d.drawImage(zombie.getImage(), zombie.getX(), zombie.getY(),null);

        }

    }




}
