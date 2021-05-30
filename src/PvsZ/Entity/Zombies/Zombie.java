package PvsZ.Entity.Zombies;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;


/**
 * Zombie class represents a zombie in PlantVsZombies game
 * It holds the zombie details relevant in our game.
 * three types of our zombies will be handled at this package class.
 *
 *
 *
 * @author sara lahourpour
 * @version 0.1
 * @since 1/30/2021
 *
 */
public class Zombie {

    //coordinate of zombie in map
    protected int x, y;

    //length and width of zombie picture
    protected int length, width;

    //zombie image name
    protected String imageName;
    protected Image image;


    protected int life;
    protected int damage;
    protected int speed;

    //if the eating field be true , we may not use the move method
    protected boolean eating;


    /**
     * constructor
     *
     */
    public Zombie() {

        x = 1280;
        y = 120/2 + new Random().nextInt(5) * 120 ;
        eating = false;

    }


//    /**
//     * set the zombie image
//     *
//     * @param imageName
//     */
//    public void setImageName(String imageName) {
//        this.imageName = imageName;
//    }

    /**
     * getter of zombie's image
     * @return zombie's image
     */
    public Image getImage() {

//        try {
//            image = ImageIO.read(new File(imageName));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        image=new ImageIcon(imageName).getImage();
        return image;
    }

    /**
     * getter of zombie's x coordinate
     * @return zombie's x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * getter of zombie's y coordinate
     * @return zombie's y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * move the zombie
     * but before it should be check that the zombie is eating plant or not
     *
     */
    public void move() {

        x=x-speed;

    }


    /**
     * reduce the speed of zombie when
     * frozen pea catches the zombie
     *
     */
    public void reduceSpeed() {
        speed /= 2;
    }

//    public void backToNormalSpeed(){
//        speed*=2;
//    }


    /**
     * getter of zombie's image length
     * @return length of zombie's image
     */
    public int getLength() {
        return length;
    }

    /**
     * getter of zombie's image width
     * @return width of zombie's image
     */
    public int getWidth() {
        return width;
    }

    /**
     * getter of zombie's life
     * @return zombie's life
     */
    public int getLife() {
        return life;
    }

    /**
     * reduce life when any type of pea catches the zombie
     * @param damage pea's damage
     */
    public void reduceLife(int damage) {
        life = life - damage;
        if (life <= 200) {
            imageName = "res/Pictures/Zombies/normal_zombie.png";
        }
    }

    /**
     * getter of zombie's damage
     * @return zombie's damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * check whether the zombie is eating plant or not
     * @return true if it is eating plant and false if not
     */
    public boolean isEating() {
        return eating;
    }

    /**
     * setter of eating field
     * @param eating true if zombie is eating and false if it is not
     */
    public void setEating(boolean eating) {
        this.eating = eating;
    }



}
