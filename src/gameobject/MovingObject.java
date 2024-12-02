package gameobject;

import math.Vector2D;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public abstract class  MovingObject extends GameObject{

    protected Vector2D velocity;
    protected AffineTransform at;//nos ayuda a girar la nave
    protected double angle;

    protected  double maxVel;

    protected int width;
    protected int height;


    public MovingObject(Vector2D position, Vector2D velocity, double maxVel, BufferedImage texture) {
        super(position, texture);
        this.velocity = velocity;
        this.maxVel = maxVel;
        width = texture.getWidth();
        height = texture.getHeight();
        angle = 0;
    }



}
