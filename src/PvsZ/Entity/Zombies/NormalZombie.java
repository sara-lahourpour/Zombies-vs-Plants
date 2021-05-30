package PvsZ.Entity.Zombies;


/**
 * NormalZombie class represents a normal zombie in PlantVsZombies game
 * It holds the normal zombie details relevant in our game.
 *
 *
 *
 * @author saralahourpour
 * @version 0.1
 * @since 1/30/2021
 *
 */
public class NormalZombie extends Zombie{


    /**
     * constructor
     *
     *
     */
    public NormalZombie(){

        life = 200;
        damage = 5;
        speed = 1;

        length=160;
        width=80;

        imageName = "res/Pictures/Zombies/normal_zombie.png";

    }



}
