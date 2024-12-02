package gameobject;

import math.Vector2D;
import state.GameState;

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

    protected GameState gameState;


    public MovingObject(Vector2D position, Vector2D velocity, double maxVel, BufferedImage texture, GameState gameState) {
        super(position, texture);
        this.velocity = velocity;
        this.maxVel = maxVel;
        this.gameState=gameState;
        width = texture.getWidth();
        height = texture.getHeight();
        angle = 0;
    }



}
