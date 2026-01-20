package app.gameengine.model.ai;

import app.gameengine.Level;
import app.gameengine.model.datastructures.LinkedListNode;
import app.gameengine.model.gameobjects.DynamicGameObject;
import app.gameengine.model.physics.Vector2D;

public class RecalculatePath extends Decision{
    public RecalculatePath(String name){
        super(name);
    }
    @Override
    public void doAction(DynamicGameObject d1, Level l1, double dt){
        d1.getVelocity().setX(0.0);
        d1.getVelocity().setY(0.0);
        LinkedListNode<Vector2D> path=Pathfinding.findPath
                (d1.getLocation(),l1.getPlayer().getLocation());
        d1.setPath(path);
    }
}
