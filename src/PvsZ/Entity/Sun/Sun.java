package PvsZ.Entity.Sun;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;


/**
 * Sun class represents a sun in PlantVsZombies game
 * It holds the sun details relevant in our game.
 *
 *
 *
 * @author sara lahourpour
 * @since 1/23/2021
 * @version 0.2
 *
 */
public class Sun {

    //coordinate of sun in map
    private int x, y;

    //length and width of sun picture in map
    private int length, width;

    private BufferedImage image;

    private long createTime;
    private int bonus;
    private boolean fromSunflower;
    private boolean stopped;
    private int whereShouldYStop;
    private int i;


    /**
     * constructor
     *
     *
     * @param fromSunflower sun is from sunflower or not
     */
    public Sun(boolean fromSunflower){

        this.fromSunflower=fromSunflower;
        length=100;
        width=100;
        bonus=25;
        stopped=false;
        i=0;


        SecureRandom random=new SecureRandom();
        if (!fromSunflower){

            x=50+(random.nextInt(9)*130);
            y=0;
            whereShouldYStop=120+(random.nextInt(5)*120);
        }else {
            createTime=System.currentTimeMillis()/1000;
        }


    }


    /**
     * getter of X coordinate
     * @return X
     */
    public int getX() {
        return x;
    }

    /**
     * setter of X coordinate
     * @param x coordinate of sun in map
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * getter of Y coordinate
     * @return Y
     */
    public int getY() {
        return y;
    }

    /**
     * setter of Y coordinate
     * @param y coordinate of sun in map
     */
    public void setY(int y) {
        this.y = y;
    }


    /**
     * getter of sun image
     * @return sun's image
     */
    public BufferedImage getImage() {

        try {
            image= ImageIO.read(new File("res/Pictures/Sun/sun.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    /**
     * getter of sun image length
     * @return length of sun's image
     */
    public int getLength() {
        return length;
    }

    /**
     * getter of sun image width
     * @return width of sun's image
     */
    public int getWidth() {
        return width;
    }


    /**
     * getter of sun's bonus
     * @return sun's bonus
     */
    public int getBonus() {
        return bonus;
    }

    /**
     * getter whether the sun is from sunflower or panel
     * @return true if from sunflower, and false if not
     */
    public boolean isFromSunflower() {
        return fromSunflower;
    }

    /**
     * check whether sun is still exist or not
     * @return true if it is exists , and false if not
     */
    public boolean stillExist(){

        long now=System.currentTimeMillis()/1000;

//        System.out.println("in stillExist : "+(now-createTime));

        if ((now-createTime)<7){
            return true;
        }
        return false;

    }


    /**
     * getter of is sun stopped or not
     * @return true if stopped and false if not
     */
    public boolean isStopped(){

        if (whereShouldYStop==y){
            stopped=true;
            i++;
            if (i==1) {
                createTime = System.currentTimeMillis() / 1000;
            }
            return true;
        }
        return false;
    }

    /**
     * move the sun
     * user should know that the sun is from sunflower or not by isFromSunflower method
     * then should use this method
     */
    public void move(){

        y++;

    }


}
