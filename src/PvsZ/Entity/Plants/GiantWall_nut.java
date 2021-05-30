package PvsZ.Entity.Plants;



/**
 * Giant WallNut class represents a plant in PlantVsZombies game
 * It holds the plant details relevant in our game.
 *
 *
 * @author sara lahourpour
 * @since 1/23/2021
 * @version 0.1
 *
 */
public class GiantWall_nut extends Plant {



    /**
     * constructor
     *
     * @param x coordinate of plant in map
     * @param y coordinate of plant in map
     */
    public GiantWall_nut(int x, int y) {
        super(x, y);

        length=width=10;
        life=150;
        sunRequired=50;
        imageName="res/Pictures/Plants/walnut_full_life.gif";


    }


}
