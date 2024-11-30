package gameobject;

import math.Vector2D;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public abstract class  MovingObject extends GameObject{

    protected Vector2D velocity;
    protected AffineTransform at;//nos ayuda a girar la nave
    protected double angle;


    public MovingObject(Vector2D position, Vector2D velocity, BufferedImage texture) {
        super(position, texture);
        this.velocity = velocity;
        angle = 0;
    }



}
