package PvsZ.Entity.Zombies;


/**
 * ConeHeadZombie class represents a cone head zombie in PlantVsZombies game
 * It holds the cone head zombie details relevant in our game.
 *
 *
 *
 * @author saralahourpour
 * @version 0.1
 * @since 1/30/2021
 *
 */
public class ConeHeadZombie extends Zombie{


    /**
     * constructor
     *
     *
     */
    public ConeHeadZombie(){

        //360 more for Cone
        life = 560;

        damage = 10;
        speed = 2;
        length = 160;
        width = 80;

        imageName = "res/Pictures/Zombies/ConeHead_Zombie.png";

    }



}
