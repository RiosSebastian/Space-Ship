package graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Loader {
    public static BufferedImage Imageloader(String path){
        try {
            return ImageIO.read(Loader.class.getResource(path));
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }


}
