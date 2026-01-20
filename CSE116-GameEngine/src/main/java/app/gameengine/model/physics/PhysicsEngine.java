package app.gameengine.model.physics;

import app.gameengine.model.gameobjects.DynamicGameObject;
import app.gameengine.Level;
import app.gameengine.model.gameobjects.StaticGameObject;

import java.util.ArrayList;

public class PhysicsEngine {

    public PhysicsEngine() {}

    public void updateLevel(Level level, double dt) {

        // Update the location of each dynamic object based on its velocity
        for(DynamicGameObject dynamicObject : level.getDynamicObjects()){
            updateObject(dynamicObject, dt);
        }

        // detect all collisions for each dynamic object
        for (int i = 0; i < level.getDynamicObjects().size(); i++) {
            DynamicGameObject dynamicObject1 = level.getDynamicObjects().get(i);

            // check for collisions with other dynamic objects
            // start at i+1 to avoid reporting collision multiple times
            for (int j = i+1; j < level.getDynamicObjects().size(); j++) {
                DynamicGameObject dynamicObject2 = level.getDynamicObjects().get(j);
                if(detectCollision(dynamicObject1.getHitBox(), dynamicObject2.getHitBox())){
                    dynamicObject1.collideWithDynamicObject(dynamicObject2);
                    dynamicObject2.collideWithDynamicObject(dynamicObject1);
                }
            }

            // check for collisions with static objects
            for(StaticGameObject so : level.getStaticObjects()){
                if(detectCollision(so.getHitBox(), dynamicObject1.getHitBox())){
                    so.collideWithDynamicObject(dynamicObject1);
                    dynamicObject1.collideWithStaticObject(so);
                }
            }
        }

    }

    public void updateObject(DynamicGameObject dynamicObject, double dt){
        Vector2D r=dynamicObject.getVelocity();
        double vel_x=r.getX();
        double vel_y=r.getY();
        Vector2D loc=dynamicObject.getLocation();
        double x_loc=loc.getX();
        double y_loc=loc.getY();
        double new_x=x_loc+vel_x*dt;
        double new_y=y_loc+vel_y*dt;
        dynamicObject.getLocation().setX(new_x);
        dynamicObject.getLocation().setY(new_y);


    }

    public boolean detectCollision(Hitbox hb1, Hitbox hb2){
        Vector2D ordinates=hb1.getLocation();
        double x1_ordinate=ordinates.getX();
        double y1_ordinate=ordinates.getY();
        Vector2D dimensions=hb1.getDimensions();
        double x1_dimension= dimensions.getX();
        double y1_dimension=dimensions.getY();
        Vector2D second=hb2.getLocation();
        double x2_ordinate=second.getX();
        double y2_ordinate=second.getY();
        Vector2D space=hb2.getDimensions();
        double x2_dimension= space.getX();
        double y2_dimension=space.getY();
//        if ( x1_dimension<0 || x2_dimension<0 || y1_dimension<0 || y2_dimension<0 ){
//            return false;
//        }
        if (x1_ordinate>=x2_ordinate && y1_ordinate>=y2_ordinate){
            if(x2_ordinate+x2_dimension>=x1_ordinate && y2_ordinate+y2_dimension>=y1_ordinate){
                return true;
            }
        }
         if (x1_ordinate<=x2_ordinate && y1_ordinate<=y2_ordinate){
            if (x1_ordinate+x1_dimension>=x2_ordinate && y1_ordinate+y1_dimension>=y2_ordinate){
                return true;
            }
        }
        if (x1_ordinate>=x2_ordinate && y1_ordinate<=y2_ordinate){
            if(x2_ordinate+x2_dimension>=x1_ordinate && y1_ordinate+y1_dimension>=y2_ordinate){
                return true;
            }
        }
         if (x1_ordinate<=x2_ordinate && y1_ordinate>=y2_ordinate){
            if(x1_ordinate+x1_dimension>=x2_ordinate && y2_ordinate+y2_dimension>=y1_ordinate){
                return true;
            }
        }
        return false;
        }

    }


