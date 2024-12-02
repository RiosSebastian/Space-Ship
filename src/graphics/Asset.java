package graphics;

import java.awt.image.BufferedImage;

public class Asset {

    public static BufferedImage player;
    public static BufferedImage speed;
    public static void init(){
        player = Loader.Imageloader("/res/player.png");
        speed = Loader.Imageloader("/res/fire08.png");
    }
}
