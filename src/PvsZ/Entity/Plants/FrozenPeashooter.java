package PvsZ.Entity.Plants;



/**
 * Frozen Peashooter class represents a plant in PlantVsZombies game
 * It holds the plant details relevant in our game.
 *
 *
 *
 * @author sara lahourpour
 * @since 1/23/2021
 * @version 0.1
 *
 */
public class FrozenPeashooter extends Plant {


    private long createTime;
    private boolean createdPeaOnce;

    /**
     * constructor
     *
     * @param x coordinate of plant in map
     * @param y coordinate of plant in map
     */
    public FrozenPeashooter(int x, int y) {
        super(x, y);

        createTime=System.currentTimeMillis()/1000;

        length=width=40;
        life=100;
        sunRequired=175;
        imageName="res/Pictures/Plants/freezepeashooter.gif";


    }

    /**
     * check whether it's the proper time to create pea or not
     * @return true if frozenPeashooter should create frozenPea , and false if not
     */
    public boolean isTimeToShoot(){
        long now=System.currentTimeMillis()/1000;

        if (!((now-createTime)%4==0)){
            createdPeaOnce=false;
        }

        System.out.println("before if in frozenpeashooter class");
        if ((now-createTime)%4==0 &&  !createdPeaOnce) {
            System.out.println("in frozenpeashooter class");
            createdPeaOnce=true;
            return true;
        }
        return false;

    }


}
