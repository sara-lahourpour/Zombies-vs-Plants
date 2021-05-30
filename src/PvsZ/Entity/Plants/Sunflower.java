package PvsZ.Entity.Plants;



/**
 * Sunflower class represents a plant in PlantVsZombies game
 * It holds the sunflower details relevant in our game.
 *
 *
 *
 * @author sara lahourpour
 * @since 1/23/2021
 * @version 0.2
 *
 */
public class Sunflower extends Plant{


    private long createTime;
    private boolean createdSunOnce;


    /**
     * constructor
     *
     * @param x coordinate of sunflower in map
     * @param y coordinate of sunflower in map
     */
    public Sunflower(int x, int y) {
        super(x, y);

        length=width=90;
        life=50;
        sunRequired=50;
        imageName="res/Pictures/Plants/sunflower.gif";

        createdSunOnce=false;

        createTime=System.currentTimeMillis()/1000;


    }


    /**
     * check whether it's the proper time to create sun or not
     * @return true if sunflower should create sun , and false if not
     */
    public boolean canCreateSun(){

        long now=System.currentTimeMillis()/1000;

//        System.out.println("canCreateSun in Sunflower :" +(now-createTime));

        if (!((now-createTime)%20==0)){
            createdSunOnce=false;
        }

        if ((now-createTime)%20==0 && !(now==createTime) && !createdSunOnce){
            createdSunOnce=true;
            return true;
        }
        return false;

    }




}
