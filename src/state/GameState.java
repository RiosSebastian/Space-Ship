package state;

import gameobject.Player;
import graphics.Asset;
import math.Vector2D;

import java.awt.*;

public class GameState {

    private Player player;
    public GameState(){
        player = new Player(new Vector2D(100,500),new Vector2D(), Asset.player);
    }

    public void update(){
        player.update();
    }

    public void draw(Graphics g){
        player.draw(g);
    }
}
