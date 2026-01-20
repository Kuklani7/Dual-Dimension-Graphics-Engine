package app.gameengine.model.ai;

import app.gameengine.Level;
import app.gameengine.model.datastructures.LinkedListNode;
import app.gameengine.model.gameobjects.DynamicGameObject;
import app.gameengine.model.physics.Vector2D;

public class TargetingPlayer extends Decision {
    private double stray;

    public TargetingPlayer(String name, double stray) {
        super(name);
        this.stray = stray;
    }

    @Override
    public boolean decide(DynamicGameObject d1, Level l1, double dt) {
        LinkedListNode<Vector2D> guidance=d1.getPath();
        if(guidance==null){
            return false;
        }
        LinkedListNode<Vector2D> end=guidance.LastNode(guidance);
        double x1_ordinate=end.getValue().getX();
        double y1_ordinate=end.getValue().getY();
        if (Math.sqrt(Math.pow(x1_ordinate - l1.getPlayer().getLocation().getX(), 2)+
                Math.pow(y1_ordinate - l1.getPlayer().getLocation().getY(), 2)) <= this.stray){
            return true;
        }
        else{
            return false;
        }


    }
}
