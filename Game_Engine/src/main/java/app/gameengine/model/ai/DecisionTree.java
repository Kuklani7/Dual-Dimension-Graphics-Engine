package app.gameengine.model.ai;

import app.gameengine.Level;
import app.gameengine.model.datastructures.BinaryTreeNode;
import app.gameengine.model.gameobjects.DynamicGameObject;

public class DecisionTree {
    private BinaryTreeNode<Decision> node;

    public DecisionTree(BinaryTreeNode<Decision> node) {
        this.node = node;
    }

    public BinaryTreeNode<Decision> getTree() {
        return this.node;
    }

    public void setTree(BinaryTreeNode<Decision> node) {
        this.node = node;
    }

    public Decision traverse(BinaryTreeNode<Decision> choose,
                             DynamicGameObject d1, Level l1, double dt) {
        if (choose == null) {
            return null;
        }
        while ((choose != null &&(choose.getLeft() != null || choose.getRight() != null)) ) {
            if (choose.getValue().decide(d1, l1, dt)) {
                choose = choose.getRight();
            } else {
                choose = choose.getLeft();
            }
        }
        if (choose == null) {
            return null;
        } else {
            return choose.getValue();
        }
    }

    public void traverse(DynamicGameObject d1, Level l1, double dt) {
        Decision d4 = traverse(this.getTree(), d1, l1, dt);
        if (d4 != null) {
            d4.doAction(d1, l1, dt);
        }
    }

    public void reverse(BinaryTreeNode<Decision> b1) {
        if(b1!=null){
            if(b1.getLeft()!=null || b1.getRight()!= null) {
                BinaryTreeNode<Decision> temp=b1.getLeft();
                BinaryTreeNode<Decision> temper_2=b1.getRight();
                b1.setLeft(temper_2);
                b1.setRight(temp);
                reverse(b1.getLeft());
                reverse(b1.getRight());
            }

        }
        else{
            return;
        }
    }
   public void reverse(){
        reverse(this.node);
    }

}
