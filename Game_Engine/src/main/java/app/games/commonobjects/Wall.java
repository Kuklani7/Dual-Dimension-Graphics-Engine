package app.games.commonobjects;

import app.gameengine.graphics.SpriteLocation;
import app.gameengine.model.gameobjects.DynamicGameObject;
import app.gameengine.model.gameobjects.StaticGameObject;
import app.gameengine.model.physics.Vector2D;

import static java.lang.Math.abs;

/**
 * A wall object the player can collide with, serves as a building block
 * for your levels.
 */
public class Wall extends StaticGameObject {
    static final double mover=0.00001;

    public Wall(int x, int y) {
        super(x, y);
        this.spriteSheetFilename = "Ground/Cliff.png";
        this.defaultSpriteLocation = new SpriteLocation(3, 0);
    }
    public void collideWithDynamicObject(DynamicGameObject player){
        Vector2D player_loc=player.getLocation();
        double x_loc= player_loc.getX();
        double y_loc= player_loc.getY();
        Vector2D wall_loc=this.getLocation();
        double wall_x= wall_loc.getX();
        double wall_y=wall_loc.getY();
        double d1=x_loc-(wall_x-1);
        double d2=x_loc-(wall_x+1);
        double d3=y_loc-(wall_y-1);
        double d4=y_loc-(wall_y+1);
        if (abs(d1) <= abs(d2) && abs(d1)<=abs(d3)&& abs(d1)<=abs(d4)){
            player_loc.setX((wall_x-1)-mover);
        }
        if(abs(d2)<=abs(d1) && abs(d2)<=abs(d3) && abs(d2)<=abs(d4)){
            player_loc.setX((wall_x+1)+mover);
        }
        if(abs(d3)<=abs(d1) && abs(d3)<=abs(d2) && abs(d3)<=abs(d4)){
            player_loc.setY((wall_y-1)-mover);
        }
        if(abs(d4)<abs(d1) && abs(d4)<abs(d2) && abs(d4)<abs(d3)){
            player_loc.setY((wall_y+1)+mover);
        }



    }


}
