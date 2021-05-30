package PvsZ.Entity.Bullets;

import java.awt.image.BufferedImage;

/**
 * Pea class represents a bullet in PlantVsZombies game
 * It holds the pea details relevant in our game.
 *
 *
 *
 *
 * @author sara lahourpour
 * @since 1/23/2021
 * @version 0.0
 *
 */
public class Pea {

    //coordinate of pea in map
    protected int x, y;

    //length and width of pea picture
    protected int length, width;

    protected int damage;
    protected BufferedImage image;


    /**
     * constructor
     *
     */
    public Pea(int x, int y){

        this.x=x;
        this.y=y;
        length=width=25;

    }


    /**
     * move pea
     */
    public void move(){
       x=x+4;
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
     * @param x coordinate of pea in map
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
     * @param y coordinate of pea in map
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * getter of pea image length
     * @return length of pea's image
     */
    public int getLength() {
        return length;
    }

    /**
     * getter of pea image width
     * @return width of pea's image
     */
    public int getWidth() {
        return width;
    }

    /**
     * getter of pea damage
     * @return pea damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * getter of pea image
     * @return pea image
     */
    public BufferedImage getImage() {
        return image;
    }

}
