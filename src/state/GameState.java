package state;

import gameobject.*;
import graphics.Aseets;
import math.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameState {

    private int meteors ;
    private Player player;
    private ArrayList<MovingObject> movingObjects = new ArrayList<MovingObject>();
    public GameState(){
        player = new Player(new Vector2D(100,500),new Vector2D(),7 , Aseets.player, this);
        movingObjects.add(player);
        meteors = 1;

        straWade();
    }


    private void straWade(){
        double x,y;

        for(int i = 0; i < meteors; i++){
            x = 1 % 2 == 0 ? Math.random()* Constants.WIDTH: 0 ;
            y = 1 % 2 == 0 ? 0: Math.random()*Constants.HEIGHT;

            BufferedImage textura = Aseets.bigs[(int)(Math.random()*Aseets.bigs.length)];

            movingObjects.add(new Meteor(
                    new Vector2D(x, y),
                    new Vector2D(0,1).setDirection(Math.random()*Math.PI*2),
                    Constants.METEOR_VEL*Math.random() + 1,
                    textura,
                    this,
                    Size.BIG

            ));
        }
        meteors ++;

    }

    public void update(){

       for (int i=0; i<movingObjects.size(); i++){
           movingObjects.get(i).update();
       }

    }

    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        for (int i=0; i<movingObjects.size(); i++){
            movingObjects.get(i).draw(g);
        }
    }

    public ArrayList<MovingObject> getMovingObjects() {
        return movingObjects;
    }

    public void setMovingObjects(ArrayList<MovingObject> movingObjects) {
        this.movingObjects = movingObjects;
    }
}
