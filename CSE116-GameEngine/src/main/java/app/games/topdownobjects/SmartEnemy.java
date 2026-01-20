package app.games.topdownobjects;

import app.gameengine.graphics.SpriteLocation;
import app.gameengine.model.ai.Decision;
import app.gameengine.model.ai.DecisionTree;
import app.gameengine.model.ai.MoveTowardsPlayer;
import app.gameengine.model.ai.MoveTowardsPlayerAvoidWalls;
import app.gameengine.model.datastructures.BinaryTreeNode;
import app.gameengine.model.physics.Vector2D;

public class SmartEnemy extends Enemy{
    public SmartEnemy(Vector2D location){
        super(location,1);
        this.setDecisionTree(new DecisionTree(new BinaryTreeNode<>
                (new MoveTowardsPlayerAvoidWalls("Rachit"),null,null)));
        this.spriteSheetFilename="Characters/Monsters/Orcs/ArcherGoblin.png";
        this.defaultSpriteLocation=new SpriteLocation(0,0);
    }
}
