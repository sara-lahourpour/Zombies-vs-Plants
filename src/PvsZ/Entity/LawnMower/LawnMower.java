package PvsZ.Entity.LawnMower;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/**
 * LawnMower class represents a lawnmower in PlantVsZombies game
 * It holds the lawnmower details relevant in our game.
 *
 *
 *
 *
 * @author saralahourpour
 * @since 2/3/2021
 * @version 0.0
 *
 */
public class LawnMower {


    //coordinate of lawnmower in map
    private int x, y;

    //length and width of lawnmower picture in map
    private int length, width;

    private BufferedImage image;


    /**
     * constructor
     *
     */
    public LawnMower(){

        length=70;
        width=70;

        x=0;

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
     * @param x coordinate of lawnmower in map
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
     * @param y coordinate of lawnmower in map
     */
    public void setY(int y) {
        this.y = y;
    }


    /**
     * getter of lawnmower image
     * @return lawnmower's image
     */
    public BufferedImage getImage() {

        try {
            image= ImageIO.read(new File("res/Pictures/LawnMower/Lawn_Mower.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    /**
     * getter of lawnmower image length
     * @return length of lawnmower's image
     */
    public int getLength() {
        return length;
    }

    /**
     * getter of lawnmower image width
     * @return width of lawnmower's image
     */
    public int getWidth() {
        return width;
    }



    /**
     * move the lawnmower
     */
    public void move(){

        x++;

    }


}
