package gameobject;

import math.Vector2D;
import state.GameState;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Laser extends MovingObject{

    public Laser(Vector2D position, Vector2D velocity, double maxVel,double angle, BufferedImage texture, GameState gameState) {
        super(position, velocity, maxVel, texture, gameState);
        this.angle=angle;
        this.velocity=velocity.scale(maxVel);
    }

    @Override
    public void update() {
        position = position.add(velocity);
        if (position.getX()<0 || position.getX()>800 || position.getY()<0 || position.getY()>600){
            gameState.getMovingObjects().remove(this);
        }
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        at = AffineTransform.getTranslateInstance(position.getX() - width/2,position.getY());
        at.rotate(angle, width/2, 0 );

        g2d.drawImage(texture, at, null);

    }
}
