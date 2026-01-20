package app.games.topdownobjects;

import app.gameengine.Level;
import app.gameengine.graphics.SpriteLocation;
import app.gameengine.model.ai.Decision;
import app.gameengine.model.ai.DecisionTree;
import app.gameengine.model.ai.MoveTowardsPlayer;
import app.gameengine.model.datastructures.BinaryTreeNode;
import app.gameengine.model.datastructures.LinkedListNode;
import app.gameengine.model.gameobjects.DynamicGameObject;
import app.gameengine.model.physics.Vector2D;

import static java.lang.Math.abs;

/**
 * Basic enemy class.
 *
 * In future tasks, you will develop tools to give enemies more features:
 * like pathfinding, AI, etc.
 */
public class Enemy extends DynamicGameObject {
    private Vector2D location;

    private int strength;
    private LinkedListNode<Vector2D> guide = null;

    public Enemy(Vector2D location) {
        this(location, 3);
        this.location=location;

    }

    static final double PY = 0.01;
    static final double EPSILON=0.000001;

    public Enemy(Vector2D location, int strength) {
        super(location, 10);
        this.strength = strength;
        this.spriteSheetFilename = "Characters/Monsters/Demons/ArmouredRedDemon.png";
        this.defaultSpriteLocation = new SpriteLocation(0, 2);
        this.setDecisionTree(new DecisionTree(new BinaryTreeNode<>
                (new MoveTowardsPlayer("Rachit"),null,null)));
    }

    public void setPath(LinkedListNode<Vector2D> v1) {
        this.guide = v1;
    }
    public void setLocation(Vector2D change){
        this.location= new Vector2D(change.getX(),change.getY());
    }

    public LinkedListNode<Vector2D> getPath() {
        return this.guide;
    }
    public void setVelocity(Vector2D vel){
        this.getVelocity().setX(vel.getX());
        this.getVelocity().setY(vel.getY());
    }

//    public void update(double d1, Level l1) {
//        if (this.guide == null) {
//            this.guide = findPath(this.getLocation(), l1.getPlayer().getLocation());
//            return;
//        }
////        double u = Math.pow(this.getLocation().getX() - this.guide.getValue().getX(), 2);
////        double v = Math.pow(this.getLocation().getY() - this.guide.getValue().getY(), 2);
////        while(this.guide.getNext()!=null){
//
//         if (Math.sqrt(Math.pow(this.getLocation().getX() - this.guide.getValue().getX(), 2)+
//                 Math.pow(this.getLocation().getY() - this.guide.getValue().getY(), 2)) < PY) {
//            // Set location of the enemy to the head node of the guide.
//            this.getLocation().setX(this.guide.getValue().getX());
//             this.getLocation().setY(this.guide.getValue().getY());
//            this.guide = this.guide.getNext();
//        } else {
//             LinkedListNode<Vector2D> link = this.guide;
//             if (link != null) {
//                 if (abs(this.getLocation().getX() + 1 - link.getValue().getX())<EPSILON) {
//                     this.setVelocity(new Vector2D(1,0));
//                 } else if (abs(this.getLocation().getX() - 1 - link.getValue().getX())<EPSILON) {
//                     this.setVelocity(new Vector2D(-1,0));
//                 } else if (abs(this.getLocation().getY() + 1 - link.getValue().getY())<EPSILON) {
//                     this.setVelocity(new Vector2D(0,1));
//                 } else {
//                     this.setVelocity(new Vector2D(0,-1));
//                 }
//             }
//
//
//
//        }
//    }


    @Override
    public void collideWithDynamicObject(DynamicGameObject otherObject) {
        if (otherObject.isPlayer()) {
            if(otherObject.getInvincibilityFrames()>0.0){}
            else{
                otherObject.takeDamage(this.strength);
                otherObject.setInvincibilityFrames(0.5);
            }
        }
    }
}



