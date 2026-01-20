package app.tests;

import app.gameengine.model.datastructures.LinkedListNode;
import app.gameengine.model.physics.Vector2D;
import org.junit.Test;

import static app.gameengine.model.ai.Pathfinding.findPath;
import static java.lang.Math.abs;
import static org.junit.Assert.*;

public class TestTask2 {
    static final double EPSILON = 0.0001;


    public void validatePath(LinkedListNode<Vector2D> positions) {
        if (positions == null) {
            return;
        } else if (positions.getNext() == null) {
            return;
        } else {
            while (positions.getNext() != null) {
                assertTrue(positions.getValue().getX() % 1 == 0 && positions.getValue().getY() % 1 == 0 &&
                        positions.getNext().getValue().getX() % 1 == 0 && positions.getNext().getValue().getY() % 1 == 0);
                double x1_ordinate = Math.floor(positions.getValue().getX());
                double y1_ordinate = Math.floor(positions.getValue().getY());
                double x2_ordinate = Math.floor(positions.getNext().getValue().getX());
                double y2_ordinate = Math.floor(positions.getNext().getValue().getY());
                if ((x1_ordinate - x2_ordinate < EPSILON) || (y1_ordinate - y2_ordinate < EPSILON)) {
                    if ((abs(x1_ordinate - x2_ordinate) < EPSILON) && (abs(y1_ordinate - y2_ordinate) < EPSILON)) {
                        boolean c = false;
                        assertTrue(c);
                    }
                    if (abs(x1_ordinate - x2_ordinate) == 1 ^ abs(y1_ordinate - y2_ordinate) == 1) {
                        positions = positions.getNext();
                    } else {
                        boolean c = false;
                        assertTrue(c);
                    }
                } else {
                    boolean b = false;
                    assertTrue(b);
                }
            }
            assertTrue(true);
        }
    }
    public int size(LinkedListNode<Vector2D> positions){
        if(positions.getNext()==null){
            return 1;
        }
        else{
            int a=size(positions.getNext());
            return 1+a;
        }
    }
    public LinkedListNode<Vector2D> LastNode(LinkedListNode<Vector2D> vectors){
        while(vectors.getNext()!=null){
            vectors=vectors.getNext();
        }
        return vectors;
    }
    public LinkedListNode<Vector2D> FirstNode(LinkedListNode<Vector2D> vectors){
        return vectors;
    }

    @Test
    public void testFindPath() {
        LinkedListNode<Vector2D> path_1 = findPath(new Vector2D(0.5, 0.8), new Vector2D(5, 5));
        LinkedListNode<Vector2D> path_2 = findPath(new Vector2D(-18, 13), new Vector2D(12, -27));
        LinkedListNode<Vector2D> path_3 = findPath(new Vector2D(2.8, 3.1), new Vector2D(5.4, 3.2));
        LinkedListNode<Vector2D> path_4 = findPath(new Vector2D(-12.7, 13.4), new Vector2D(-11.3, -5.8));
        validatePath(path_1);
        validatePath(path_2);
        validatePath(path_3);
        validatePath(path_4);
        assertEquals(0,FirstNode(path_1).getValue().getX(),EPSILON);
        assertEquals(0,FirstNode(path_1).getValue().getY(),EPSILON);
        assertEquals(5,LastNode(path_1).getValue().getX(),EPSILON);
        assertEquals(5,LastNode(path_1).getValue().getY(),EPSILON);
        assertTrue(size(path_1)==11);
        assertEquals(-18,FirstNode(path_2).getValue().getX(),EPSILON);
        assertEquals(13,FirstNode(path_2).getValue().getY(),EPSILON);
        assertEquals(12,LastNode(path_2).getValue().getX(),EPSILON);
        assertEquals(-27,LastNode(path_2).getValue().getY(),EPSILON);
        assertTrue(size(path_2)==71);
    }
//    @Test
//    public void testSize(){
//        LinkedListNode<Vector2D> l1= new LinkedListNode<>(new Vector2D(0,0),null);
//        l1.append(new LinkedListNode<>(new Vector2D(1,0),null));
//        l1.append(new LinkedListNode<>(new Vector2D(1,1),null));
//        l1.append(new LinkedListNode<>(new Vector2D(2,1),null));
//        assertTrue(size(l1)==4);
//}


}






//    @Test
//    public void testvalidatePath() {
//        LinkedListNode<Vector2D> tester = new LinkedListNode<>(new Vector2D(1, 2), null);
//        tester.append(new Vector2D(1, 3));
//        tester.append(new Vector2D(2, 3));
//        tester.append(new Vector2D(2, 4));
//        tester.append(new Vector2D(2, 5));
//        validatePath(tester);
//
//
//    }


//    public static void main(String[] args) {
//        int a=10;
//        System.out.println(a);
//        LinkedListNode<Vector2D> paths=findPath(new Vector2D(0,0),new Vector2D(5,5));
//        System.out.println(paths);
//    }



