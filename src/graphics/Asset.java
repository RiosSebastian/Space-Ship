package graphics;

import java.awt.image.BufferedImage;

public class Asset {

    public static BufferedImage player;
    public static void init(){
        player = Loader.Imageloader("/res/player.png");
    }
}
