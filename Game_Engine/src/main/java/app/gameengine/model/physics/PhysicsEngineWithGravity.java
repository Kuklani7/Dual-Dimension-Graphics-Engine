package app.gameengine.model.physics;

import app.gameengine.model.gameobjects.DynamicGameObject;

public class PhysicsEngineWithGravity extends PhysicsEngine{
    private double gravity;
    public PhysicsEngineWithGravity(double gravity){
        this.gravity=gravity;
    }
    @Override
    public void updateObject(DynamicGameObject p1, double dt){
        double change_y=this.gravity*dt;
        p1.getVelocity().setY(p1.getVelocity().getY()+change_y);
        super.updateObject(p1,dt);
    }
}
