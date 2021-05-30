package PvsZ.Entity.Cards;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/**
 * Card class represents a card in PlantVsZombies game
 * It holds the card details relevant in our game.
 *
 *
 *
 * @author sara lahourpour
 * @since 1/23/2021
 * @version 0.0
 *
 */
public class Card {

    //coordinate of card in map
    protected int x, y;

    //length and width of card picture
    protected int length, width;

//    // 0--> sunflower
//    // 1--> peashooter
//    // 2--> giantWall-nut
//    // 3--> frozenPeashooter
//    // 4--> cherry bomb
//    protected int type;

    //proper time to get card enable again
    protected double preparingTime;

    //is user clicked on it or not
    protected boolean clickedOnCard;

    //time of when user clicked on card
    protected long clickedTime;

    protected String imageName;
    protected BufferedImage image;


    /**
     * constructor
     *
     */
    public Card(){

        length=width=10;
        clickedOnCard=false;

//        if (type==0){
//            setSunflower();
//        }else if (type==1){
//            setPeashooter();
//        }else if (type==2){
//            setGiantWall_nut();
//        }else if (type==3){
//            setFrozenPeashooter();
//        }else{
//            setCherryBomb();
//        }

    }

//    /**
//     * set sunflower card
//     */
//    private void setSunflower(){
//
//        preparingTime=7.5;
//        imageName="src/PvsZ/Boundary/Pictures/Cards/card_sunflower.png";
//    }
//
//    /**
//     * set peaShooter card
//     */
//    private void setPeashooter(){
//
//        preparingTime=7.5;
//        imageName="src/PvsZ/Boundary/Pictures/Cards/card_peashooter.png";
//    }
//
//    /**
//     * set giantWall_nut card
//     */
//    private void setGiantWall_nut(){
//
//        preparingTime=7.5;
//        imageName="src/PvsZ/Boundary/Pictures/Cards/card_wallnut.png";
//    }
//
//    /**
//     * set frozen peaShooter card
//     */
//    private void setFrozenPeashooter(){
//
//        preparingTime=30;
//        imageName="src/PvsZ/Boundary/Pictures/Cards/card_frozenpeashooter.png";
//    }
//
//    /**
//     * set cherryBomb card
//     */
//    private void setCherryBomb(){
//
//        preparingTime=30;
//        imageName="src/PvsZ/Boundary/Pictures/Cards/card_cherrybomb.png";
//    }
//



    /**
     * check whether the card is charged or not
     * @return true if charged , false if not
     */
    public boolean isEnable(){

        long now=System.currentTimeMillis()/1000;

        if (!clickedOnCard) {
            return true;
        }else if ((now-clickedTime)>=(preparingTime)){
            clickedOnCard=false;
            return true;
        }
        return false;
    }

    /**
     * getter of clickedOnCard
     * @return true if clicked on card, and false if not
     */
    public boolean isClickedOnCard() {
        return clickedOnCard;
    }

    /**
     * set the filed to true ,
     * setting the filed to false handled in {@link #isEnable()}
     * @param clickedOnCard clickedOnCard
     */
    public void setClickedOnCard(boolean clickedOnCard) {
        this.clickedOnCard = clickedOnCard;
        clickedTime=System.currentTimeMillis()/1000;
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
     * @param x coordinate of card in map
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
     * @param y coordinate of card in map
     */
    public void setY(int y) {
        this.y = y;
    }


    /**
     * setter of Image name
     * @param imageName name of card's image
     */
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    /**
     * getter of card image
     * @return card's image
     */
    public BufferedImage getImage() {

        try {
            image= ImageIO.read(new File(imageName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }

    /**
     * getter of card image length
     * @return length of card's image
     */
    public int getLength() {
        return length;
    }

    /**
     * getter of card image width
     * @return width of card's image
     */
    public int getWidth() {
        return width;
    }



}
