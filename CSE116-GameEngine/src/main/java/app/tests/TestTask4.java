package app.tests;

import app.gameengine.Game;
import app.gameengine.Level;
import app.gameengine.model.ai.Decision;
import app.gameengine.model.ai.DecisionTree;
import app.gameengine.model.datastructures.BinaryTreeNode;
import app.gameengine.model.gameobjects.DynamicGameObject;
import app.gameengine.model.gameobjects.Player;
import app.gameengine.model.physics.PhysicsEngine;
import app.gameengine.model.physics.Vector2D;
import app.games.topdownobjects.TopDownLevel;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestTask4 {
    public static void compareBinaryTreesOfDecisions(BinaryTreeNode<Decision> b1,
                                                     BinaryTreeNode<Decision> b2) {
        if (b1 == null || b2 == null){
            if(b1==null && b2==null){}
            else{
                assertTrue(false);
            }
            return;
        }
         if(b1.getValue().getName().equals(b2.getValue().getName())){
            compareBinaryTreesOfDecisions(b1.getLeft(),b2.getLeft());
            compareBinaryTreesOfDecisions(b1.getRight(),b2.getRight());
        }
        else{
            assertTrue(false);
        }
    }
    @Test
    public void testreverse() {
        Worker w1 = new Worker("bb", true);
        Worker w2 = new Worker("cc", false);
        Worker w3 = new Worker("dd", true);
        Worker w4 = new Worker("ee", false);
        // First test
        BinaryTreeNode<Decision> b4 = new BinaryTreeNode<>(w1, null, null);
        BinaryTreeNode<Decision> b5 = new BinaryTreeNode<>(w2, null, null);
        BinaryTreeNode<Decision> b6 = new BinaryTreeNode<>(w3, null, null);
        BinaryTreeNode<Decision> b7 = new BinaryTreeNode<>(w4, null, null);
        BinaryTreeNode<Decision> b2 = new BinaryTreeNode<>(w2, b4, b5);
        BinaryTreeNode<Decision> b3 = new BinaryTreeNode<>(w3, b6, b7);
        BinaryTreeNode<Decision> b1 = new BinaryTreeNode<>(w4, b2, b3);
        DecisionTree dt1 = new DecisionTree(b1);
        dt1.reverse();
        BinaryTreeNode<Decision> b555 = dt1.getTree();

        BinaryTreeNode<Decision> b11 = new BinaryTreeNode<>(w1, null, null);
        BinaryTreeNode<Decision> b12 = new BinaryTreeNode<>(w2, null, null);
        BinaryTreeNode<Decision> b13 = new BinaryTreeNode<>(w3, null, null);
        BinaryTreeNode<Decision> b14 = new BinaryTreeNode<>(w4, null, null);
        BinaryTreeNode<Decision> b9 = new BinaryTreeNode<>(w2, b12, b11);
        BinaryTreeNode<Decision> b10 = new BinaryTreeNode<>(w3, b14, b13);
        BinaryTreeNode<Decision> b8 = new BinaryTreeNode<>(w4, b10, b9);
        // Second test:
        BinaryTreeNode<Decision> b21 = new BinaryTreeNode<>(w1, null, null);
        BinaryTreeNode<Decision> b24 = new BinaryTreeNode<>(w2, null, null);
        BinaryTreeNode<Decision> b25 = new BinaryTreeNode<>(w3, null, null);
        BinaryTreeNode<Decision> b22 = new BinaryTreeNode<>(w4, b24, b25);
        BinaryTreeNode<Decision> b23 = new BinaryTreeNode<>(w1, b21, b22);
        DecisionTree dt3 = new DecisionTree(b23);
        dt3.reverse();
        BinaryTreeNode<Decision> b666 = dt3.getTree();
        BinaryTreeNode<Decision> b31 = new BinaryTreeNode<>(w1, null, null);
        BinaryTreeNode<Decision> b34 = new BinaryTreeNode<>(w2, null, null);
        BinaryTreeNode<Decision> b35 = new BinaryTreeNode<>(w3, null, null);
        BinaryTreeNode<Decision> b32 = new BinaryTreeNode<>(w4, b35, b34);
        BinaryTreeNode<Decision> b33 = new BinaryTreeNode<>(w1, b32, b31);
        //Third test:
        BinaryTreeNode<Decision> b44 = new BinaryTreeNode<>(w1, null, null);
        BinaryTreeNode<Decision> b45 = new BinaryTreeNode<>(w2, null, null);
        BinaryTreeNode<Decision> b43 = new BinaryTreeNode<>(w3, null, b45);
        BinaryTreeNode<Decision> b42 = new BinaryTreeNode<>(w4, b44, null);
        BinaryTreeNode<Decision> b41 = new BinaryTreeNode<>(w1, b42, b43);
        DecisionTree dt4 = new DecisionTree(b41);
        dt4.reverse();
        BinaryTreeNode<Decision> b777 = dt4.getTree();
        BinaryTreeNode<Decision> b54 = new BinaryTreeNode<>(w1, null, null);
        BinaryTreeNode<Decision> b55 = new BinaryTreeNode<>(w2, null, null);
        BinaryTreeNode<Decision> b53 = new BinaryTreeNode<>(w3, b55, null);
        BinaryTreeNode<Decision> b52 = new BinaryTreeNode<>(w4, null, b54);
        BinaryTreeNode<Decision> b51 = new BinaryTreeNode<>(w1, b53, b52);
        compareBinaryTreesOfDecisions(b555, b8);
        compareBinaryTreesOfDecisions(b666, b33);
        compareBinaryTreesOfDecisions(b777, b51);
    }
        // Testing for the traverse Method:
        @Test
        public void testtraverse1(){
            Player o1=null;
            Level ll1=null;
            double dd1=0.0;
            Worker w1 = new Worker("bb", true);
            Worker w2 = new Worker("cc", false);
            Worker w3 = new Worker("dd", true);
            Worker w4 = new Worker("ee", false);
            Worker w5= new Worker("ff",false);
            // First test
            BinaryTreeNode<Decision> b4 = new BinaryTreeNode<>(w1, null, null);
            BinaryTreeNode<Decision> b5 = new BinaryTreeNode<>(w2, null, null);
            BinaryTreeNode<Decision> b6 = new BinaryTreeNode<>(w3, null, null);
            BinaryTreeNode<Decision> b7 = new BinaryTreeNode<>(w4, null, null);
            BinaryTreeNode<Decision> b2 = new BinaryTreeNode<>(w2, b4, b5);
            BinaryTreeNode<Decision> b3 = new BinaryTreeNode<>(w3, b6, b7);
            BinaryTreeNode<Decision> b1 = new BinaryTreeNode<>(w4, b2, b3);
            DecisionTree dt1=new DecisionTree(b1);
            dt1.traverse(o1,ll1,dd1);
            assertFalse(w1.decide(o1,ll1,dd1));
            w1.setCheck(true);
            BinaryTreeNode<Decision> b44 = new BinaryTreeNode<>(w1, null, null);
            BinaryTreeNode<Decision> b45 = new BinaryTreeNode<>(w2, null, null);
            BinaryTreeNode<Decision> b43 = new BinaryTreeNode<>(w2, null, b45);
            BinaryTreeNode<Decision> b42 = new BinaryTreeNode<>(w4, b44, null);
            BinaryTreeNode<Decision> b41 = new BinaryTreeNode<>(w1, b42, b43);
            DecisionTree dt4 = new DecisionTree(b41);
            assertNull(dt4.traverse(b41,o1,ll1,dd1));
        }





}


