package graphics;

import java.awt.image.BufferedImage;

public class Asset {

    public static BufferedImage player;
    public static BufferedImage speed;
    public static BufferedImage blueLaser,redLaser,greenLaser;
    public static void init(){

        player = Loader.Imageloader("/res/player.png");
        speed = Loader.Imageloader("/res/fire08.png");

        blueLaser = Loader.Imageloader("/res/lasers/laserBlue01.png");
        redLaser = Loader.Imageloader("/res/lasers/laserRed01.png");
        greenLaser = Loader.Imageloader("/res/lasers/laserGreen11.png");
    }
}
