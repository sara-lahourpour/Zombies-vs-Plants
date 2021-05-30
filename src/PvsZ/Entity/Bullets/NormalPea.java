package PvsZ.Entity.Bullets;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


/**
 * NormalPea class represents a bullet in PlantVsZombies game
 * It holds the normal pea details relevant in our game.
 *
 *
 *
 * @author sara lahourpour
 * @since 1/23/2021
 * @version 0.0
 *
 */
public class NormalPea extends Pea{


    /**
     * NormalPae constructor
     */
    public NormalPea(int x, int y){
        super(x,y);

        damage=30;

        try {
            image= ImageIO.read(new File("res/Pictures/Peas/pea.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
