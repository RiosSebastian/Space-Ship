package gameobject;



import graphics.Aseets;

import java.awt.image.BufferedImage;

public enum Size {
    BIG(2, Aseets.meds), MED(3,Aseets.smalls), SMALL(4, Aseets.tinies), TINY(0, null);

    public int quantity;

    public BufferedImage[] texture;

    private Size(int quantity,BufferedImage[] texture){
        this.quantity = quantity;
        this.texture = texture;
    }
}
