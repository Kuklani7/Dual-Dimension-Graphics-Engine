package app.gameengine.model.ai;

import app.gameengine.Level;
import app.gameengine.model.datastructures.LinkedListNode;
import app.gameengine.model.gameobjects.DynamicGameObject;
import app.gameengine.model.physics.Vector2D;

import static app.gameengine.model.ai.Pathfinding.findPath;
import static java.lang.Math.abs;

public class RunAway extends Decision {
    static final double PY = 0.01;
    static final double EPSILON=0.000001;
    public RunAway(String name){
        super(name);
    }
    @Override
    public void doAction(DynamicGameObject d1, Level l1, double dt){
        if (d1.getPath() == null) {
            d1.setPath(findPath(d1.getLocation(), l1.getPlayer().getLocation()));
            return;
        }
            if (Math.sqrt(Math.pow(d1.getLocation().getX() - d1.getPath().getValue().getX(), 2) +
                    Math.pow(d1.getLocation().getY() - d1.getPath().getValue().getY(), 2)) < PY) {
                // Set location of the enemy to the head node of the guide.
                d1.getLocation().setX(d1.getPath().getValue().getX());
                d1.getLocation().setY(d1.getPath().getValue().getY());
                d1.setPath(d1.getPath().getNext());
            } else {
                LinkedListNode<Vector2D> link = d1.getPath();
                if (link != null) {
                    if (abs(d1.getLocation().getX() + 1 - link.getValue().getX()) < EPSILON) {
                        d1.setVelocity(new Vector2D(-1, 0));
                    } else if (abs(d1.getLocation().getX() - 1 - link.getValue().getX()) < EPSILON) {
                        d1.setVelocity(new Vector2D(1, 0));
                    } else if (abs(d1.getLocation().getY() + 1 - link.getValue().getY()) < EPSILON) {
                        d1.setVelocity(new Vector2D(0, -1));
                    } else {
                        d1.setVelocity(new Vector2D(0, 1));
                    }
                }


            }
        }

    }

