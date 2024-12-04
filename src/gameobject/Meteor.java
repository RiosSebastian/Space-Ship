package gameobject;

import graphics.Aseets;
import math.Vector2D;
import state.GameState;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Meteor  extends MovingObject{

    private Size size;

    public Meteor(Vector2D position, Vector2D velocity, double maxVel, BufferedImage texture, GameState gameState,Size size) {
        super(position, velocity, maxVel, texture, gameState);
        this.size=size;
    }


    @Override
    public void update() {
        position = position.add(velocity);

        if(position.getX() > 1000)
            position.setX(0);
        if(position.getY() > 600)
            position.setY(0);

        if(position.getX() < 0)
            position.setX(1000);
        if(position.getY() < 0)
            position.setY(600);

        angle += Constants.DELTAANGLE / 2;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        at = AffineTransform.getTranslateInstance(position.getX(),position.getY());
        at.rotate(angle, width/2,height/2);
        g2d.drawImage(texture,at, null);
    }

    public Size getSize(){
        return size;
    }
}
