package PvsZ.Entity.Plants;



/**
 * Peashooter class represents a plant in PlantVsZombies game
 * It holds the plant details relevant in our game.
 *
 *
 * @author sara lahourpour
 * @since 1/23/2021
 * @version 0.1
 *
 */
public class Peashooter extends Plant {

    private long createTime;
    private boolean createdPeaOnce;

    /**
     * constructor
     *
     * @param x coordinate of plant in map
     * @param y coordinate of plant in map
     */
    public Peashooter(int x, int y) {
        super(x, y);

        createTime=System.currentTimeMillis()/1000;

        createdPeaOnce=false;

        length=width=40;
        sunRequired=100;
        life=70;
        imageName="res/Pictures/Plants/peashooter.gif";


    }


    /**
     * check whether it's the proper time to create pea or not
     * @return true if peashooter should create pea , and false if not
     */
    public boolean isTimeToShoot(){
        long now=System.currentTimeMillis()/1000;

        if (!((now-createTime)%4==0)){
            createdPeaOnce=false;
        }

        System.out.println("before if in peashooter class");
        if ((now-createTime)%4==0 &&  !createdPeaOnce) {
            System.out.println("in peashooter class");
            createdPeaOnce=true;
            return true;
        }
        return false;

    }

//    public void setFirstTimeShoot() {
//        firstTimeShoot=System.currentTimeMillis()/1000;
//    }


}
