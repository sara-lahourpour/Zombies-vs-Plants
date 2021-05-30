package PvsZ.Entity.Zombies;


/**
 * FlagZombie class represents a flag zombie in PlantVsZombies game
 * It holds the flag zombie details relevant in our game.
 *
 *
 *
 * @author saralahourpour
 * @version 0.1
 * @since 1/30/2021
 *
 */
public class FlagZombie extends Zombie {


    /**
     * constructor
     *
     */
    public FlagZombie(){

        life = 200;
        damage = 5;
        speed = 1;

        length=160;
        width=80;

        imageName = "res/Pictures/Zombies/Flag_Zombie.png";

    }


}
