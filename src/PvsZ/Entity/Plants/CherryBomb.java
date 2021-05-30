package PvsZ.Entity.Plants;



/**
 * CherryBomb class represents a plant in PlantVsZombies game
 * It holds the plant details relevant in our game.
 *
 *
 *
 * @author sara lahourpour
 * @since 1/23/2021
 * @version 0.1
 *
 */
public class CherryBomb extends Plant {


    private long createTime;

    /**
     * constructor
     *
     * @param x coordinate of plant in map
     * @param y coordinate of plant in map
     */
    public CherryBomb(int x, int y) {
        super(x, y);

        length=width=10;
        life=70;
        sunRequired=150;
        imageName="res/Pictures/Plants/cherry.gif";

        createTime=System.currentTimeMillis()/1000;


    }


    /**
     * check whether it is the time to explode or not
     * @return true if it is the proper time, and false if not
     */
    public boolean shouldExplode(){

        long now=System.currentTimeMillis()/1000;

        if ((now-createTime)==0){
            return true;
        }
        return false;

    }



}
