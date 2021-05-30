package PvsZ.Entity.Bullets;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * FrozenPea class represents a bullet in PlantVsZombies game
 * It holds the frozen pea details relevant in our game.
 *
 *
 *
 * @author sara lahourpour
 * @since 1/23/2021
 * @version 0.0
 *
 */
public class FrozenPea extends Pea{


    /**
     * FrozenPea constructor
     */
    public FrozenPea(int x, int y){
        super(x,y);

        damage=35;

        try {
            image= ImageIO.read(new File("res/Pictures/Peas/frozenpea.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
