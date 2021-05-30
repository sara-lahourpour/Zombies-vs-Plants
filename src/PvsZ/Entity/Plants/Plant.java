package PvsZ.Entity.Plants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Plant class represents a plant in PlantVsZombies game
 * It holds the plant details relevant in our game.
 *
 *
 * @author sara lahourpour
 * @since 1/23/2021
 * @version 0.1
 *
 */
public class Plant {

    //coordinate of plant in map
    protected int x, y;

    //length and width of plant picture
    protected int length, width;

    //plant image name
    protected String imageName;
    protected Image image;

    protected int life;
    protected int sunRequired;


    /**
     * constructor
     *
     * @param x coordinate of plant in map
     * @param y coordinate of plant in map
     */
    public Plant(int x, int y){

        this.x=x;
        this.y=y;

        life=0;
        sunRequired=0;
        length=width=0;
        imageName="";

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
     * @param x coordinate of plant in map
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
     * @param y coordinate of plant in map
     */
    public void setY(int y) {
        this.y = y;
    }


    /**
     * setter of Image name
     * @param imageName name of plant's image
     */
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    /**
     * getter of plant's image
     * @return plant's image
     */
    public Image getImage() {

//        try {
//            image= ImageIO.read(new File(imageName));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        image=new ImageIcon(imageName).getImage();
        return image;
    }

    /**
     * getter of plant life
     * @return plant's life
     */
    public int getLife() {
        return life;
    }

    /**
     * reduce plant's life while zombie is eating it
     * @param damage zombie's damage
     */
    public void reduceLife(int damage) {
        life=life-damage;
    }

    /**
     * getter of plant image length
     * @return length of plant's image
     */
    public int getLength() {
        return length;
    }

    /**
     * getter of plant image width
     * @return width of plant's image
     */
    public int getWidth() {
        return width;
    }

    /**
     * getter of plant sun required
     * @return num of plant's sun required
     */
    public int getSunRequired() {
        return sunRequired;
    }

}
