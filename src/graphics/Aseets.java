package graphics;

import java.awt.image.BufferedImage;

public class Aseets {

    public static BufferedImage player;
    public static BufferedImage speed;
    public static BufferedImage blueLaser,redLaser,greenLaser;

    public static BufferedImage[] bigs = new BufferedImage[4];
    public static BufferedImage[] meds = new BufferedImage[2];
    public static BufferedImage[] smalls = new BufferedImage[2];
    public static BufferedImage[] tinies = new BufferedImage[2];

    public static void init(){

        player = Loader.Imageloader("/res/player.png");
        speed = Loader.Imageloader("/res/fire08.png");

        blueLaser = Loader.Imageloader("/res/lasers/laserBlue01.png");
        redLaser = Loader.Imageloader("/res/lasers/laserRed01.png");
        greenLaser = Loader.Imageloader("/res/lasers/laserGreen11.png");

      /*  for (int i = 0; i < bigs.length; i++ )
            bigs[i] = Loader.Imageloader("/res/meteors/big/meteorBrown_big"  +(i+1)+".png");

        for (int i = 0; i < meds.length; i++ )
            meds[i] = Loader.Imageloader("/res/meteors/meds/meteorBrown_med"+(i+1)+".png");

        for (int i = 0; i < smalls.length; i++ )
            smalls[i] = Loader.Imageloader("/res/meteors/small/meteorBrown_small"+(i+1)+".png");

        for (int i = 0; i < tinies.length; i++ )
            tinies[i] = Loader.Imageloader("/res/meteors/tiny/meteorBrown_tiny" +(i+1)+".png");*/



    }
}
