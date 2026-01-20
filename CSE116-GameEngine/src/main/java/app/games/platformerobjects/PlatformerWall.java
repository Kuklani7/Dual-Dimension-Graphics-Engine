package app.games.platformerobjects;

import app.gameengine.graphics.SpriteLocation;
import app.gameengine.model.gameobjects.DynamicGameObject;
import app.gameengine.model.physics.Vector2D;
import app.games.commonobjects.Wall;

import static java.lang.Math.abs;

public class PlatformerWall extends Wall {
    static final double EPSILON = 0.001;
    public PlatformerWall(int x_loc, int y_loc) {
        super(x_loc, y_loc);
        this.spriteSheetFilename = "Ground/Cliff.png";
        this.defaultSpriteLocation = new SpriteLocation(4, 0);
    }

    @Override
    public void collideWithDynamicObject(DynamicGameObject p2) {
        super.collideWithDynamicObject(p2);
        double x1_ordinate = this.getLocation().getX();
        double y1_ordinate = this.getLocation().getY();
        double x1_dimension = this.getDimensions().getX();
        double y1_dimension = this.getDimensions().getY();
        double x2_ordinate = p2.getLocation().getX();
        double y2_ordinate = p2.getLocation().getY();
        double x2_dimension = p2.getDimensions().getX();
        double y2_dimension = p2.getDimensions().getY();
        boolean check=false;
        if((x1_ordinate+x1_dimension>x2_ordinate)
        && (x2_ordinate+x2_dimension>x1_ordinate)){
            p2.getVelocity().setY(0);
            if((y1_ordinate>y2_ordinate|| abs(y1_ordinate-y2_ordinate)<EPSILON) &&
                    (y2_ordinate + y2_dimension>y1_ordinate || abs((y2_ordinate+ y2_dimension)-y1_ordinate)<EPSILON)){
                p2.setOnGround(true);
                p2.getVelocity().setY(0);
            }
            if((y2_ordinate>y1_ordinate || (abs(y2_ordinate-y1_ordinate)<EPSILON)) &&
                    (y1_ordinate+y1_dimension>y2_ordinate || abs((y1_ordinate+y1_dimension)-y2_ordinate)<EPSILON )){
                p2.getVelocity().setY(0);
            }
        }
//        if(x1_ordinate>=x2_ordinate){
//            if(x2_ordinate+x2_dimension>=x1_ordinate){
//                check=true;
//            }
//        }
//        else{
//            if(x1_ordinate+x1_dimension>=x2_ordinate){
//                check=true;
//            }
//        }
//        if(check){
//            if(y1_ordinate>y2_ordinate &&
//                    (y2_ordinate+y2_dimension>=y1_ordinate)){
//                p2.getVelocity().setY(0);
//                p2.setOnGround(true);
//            }
//            else if(y2_ordinate>y1_ordinate &&
//                    y1_ordinate+y1_dimension>=y2_ordinate){
//                p2.getVelocity().setY(0);
//            }
//        }

//        if (x1_ordinate >= x2_ordinate  && y1_ordinate >= y2_ordinate ) {
//            if (x2_ordinate + x2_dimension >= x1_ordinate  && y2_ordinate + y2_dimension >= y1_ordinate ) {
//                p2.getVelocity().setY(0);
//                p2.setOnGround(true);
//            }
//        }
//        if (x1_ordinate <= x2_ordinate  && y1_ordinate <= y2_ordinate ) {
//            if (x1_ordinate + x1_dimension >= x2_ordinate && y1_ordinate + y1_dimension >= y2_ordinate ) {
//                p2.getVelocity().setY(0);
//            }
//        }
//        if (x1_ordinate >= x2_ordinate  &&  y1_ordinate <= y2_ordinate)  {
//            if (x2_ordinate + x2_dimension >= x1_ordinate  && y1_ordinate + y1_dimension >= y2_ordinate ) {
//                p2.getVelocity().setY(0);
//            }
//        }
//        if (x1_ordinate <= x2_ordinate && y1_ordinate >= y2_ordinate ) {
//            if (x1_ordinate + x1_dimension >= x2_ordinate  && y2_ordinate + y2_dimension >= y1_ordinate) {
//                p2.getVelocity().setY(0);
//                p2.setOnGround(true);
//            }
//        }

    }
}

//        if(player_loc.getX()>=wall_loc.getX() && wall_loc.getY()>player_loc.getY()){
//            if (player_loc.getY()+player_dimensions.getY()>wall_loc.getY() && wall_loc.getX()+ wall_dimensions.getX()>= player_loc.getX()){
//                p2.getVelocity().setY(0);
//                p2.setOnGround(true);
//            }
//        }
//        else if(( player_loc.getX()<=wall_loc.getX() && wall_loc.getY()>= player_loc.getY())){
//            if(player_loc.getY()+player_dimensions.getY()> wall_loc.getY() && player_loc.getX()+ player_dimensions.getX()>= wall_loc.getX()){
//                p2.getVelocity().setY(0);
//            }
//        }
//        else if(player_loc.getX()<=wall_loc.getX() && player_loc.getY()<=wall_loc.getY()){
//            if(player_loc.getX()+ player_dimensions.getX()> wall_loc.getX() && wall_loc.getY()+ wall_dimensions.getY()>= player_loc.getY()){
//                p2.getVelocity().setY(0);
//            }
//        }
//        else{
//            if(wall_loc.getX()+ wall_dimensions.getX()> player_loc.getX() && wall_loc.getY()+ wall_dimensions.getY() >= player_loc.getY()){
//                p2.getVelocity().setY(0);
//            }
//        }




