package PvsZ.Entity.Zombies;


/**
 * BucketHeadZombie class represents a bucket head zombie in PlantVsZombies game
 * It holds the bucket head zombie details relevant in our game.
 *
 *
 *
 * @author saralahourpour
 * @version 0.1
 * @since 1/30/2021
 *
 */
public class BucketHeadZombie extends Zombie{


    /**
     * constructor
     *
     *
     */
    public BucketHeadZombie(){

        //1100 more for bucket
        life = 1300;

        damage = 20;
        speed = 2;

        length = 160;
        width = 80;

        imageName = "res/Pictures/Zombies/Buckethead_Zombie.png";

    }



}
