package app.tests;

import app.gameengine.Game;
import app.gameengine.Level;
import app.gameengine.model.datastructures.LinkedListNode;
import app.gameengine.model.physics.Vector2D;
import app.games.commonobjects.Wall;
import app.games.topdownobjects.Enemy;
import app.games.topdownobjects.TopDownLevel;
import org.junit.Test;
import app.gameengine.model.datastructures.LinkedListNode;
import app.gameengine.model.physics.Vector2D;
import static app.gameengine.model.ai.Pathfinding.findPath;
import static app.gameengine.model.ai.Pathfinding.findPathAvoidWalls;
import static java.lang.Math.abs;
import static org.junit.Assert.*;

public class TestTask6 {
    // jennakin@buffalo.edu
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
    public void testDirections() {
        Game g1 = new Game();
        Game g2 = new Game();
        Game g3 = new Game();
        Game g4 = new Game();
        Game g5= new Game();
        Game g6= new Game();
        Level l1 = new TopDownLevel(g1, 5, 5, "tester_1");
        l1.getPlayerStartLocation().setX(1.0);
        l1.getPlayerStartLocation().setY(1.0);
        Enemy e1=new Enemy(new Vector2D(3,1));
        Wall w1= new Wall(2,1);
        Wall w2= new Wall(2,2);
        l1.getStaticObjects().add(w1);
        l1.getStaticObjects().add(w2);
        LinkedListNode<Vector2D> path_1=findPathAvoidWalls(l1,e1.getLocation(),l1.getPlayerStartLocation());
        validatePath(path_1);
        assertTrue(size(path_1)==7);
        assertEquals(3,FirstNode(path_1).getValue().getX(),EPSILON);
        assertEquals(1,FirstNode(path_1).getValue().getY(),EPSILON);
        assertEquals(1,LastNode(path_1).getValue().getX(),EPSILON);
        assertEquals(1,LastNode(path_1).getValue().getY(),EPSILON);

        //Second level:
        Level l2= new TopDownLevel(g2,9,9,"tester_2");
        l2.getPlayerStartLocation().setX(1.0);
        l2.getPlayerStartLocation().setY(1.0);
        Enemy e2=new Enemy(new Vector2D(7,1));
        Wall w4= new Wall(6,1);
        Wall w5= new Wall(6,2);
        Wall w6= new Wall(6,3);
        l2.getStaticObjects().add(w4);
        l2.getStaticObjects().add(w5);
        l2.getStaticObjects().add(w6);
        LinkedListNode<Vector2D> path_2=findPathAvoidWalls(l2,e2.getLocation(),l2.getPlayerStartLocation());
        validatePath(path_2);
        assertTrue(size(path_2)==13);
        assertEquals(7,FirstNode(path_2).getValue().getX(),EPSILON);
        assertEquals(1,FirstNode(path_2).getValue().getY(),EPSILON);
        assertEquals(1,LastNode(path_2).getValue().getX(),EPSILON);
        assertEquals(1,LastNode(path_2).getValue().getY(),EPSILON);
//        // Third level:
        Level l3 = new TopDownLevel(g3, 5, 5, "tester_3");
        l3.getPlayerStartLocation().setX(2.0);
        l3.getPlayerStartLocation().setY(2.0);
        Wall w11= new Wall(3,1);
        Wall w12= new Wall(3,2);
        l3.getStaticObjects().add(w11);
        l3.getStaticObjects().add(w12);
        Enemy e3=new Enemy(new Vector2D(2,3));
        LinkedListNode<Vector2D> path_3=findPathAvoidWalls(l3,e3.getLocation(),l3.getPlayerStartLocation());
        validatePath(path_3);
        assertTrue(size(path_3)==2);
        assertEquals(2,FirstNode(path_3).getValue().getX(),EPSILON);
        assertEquals(3,FirstNode(path_3).getValue().getY(),EPSILON);
        assertEquals(2,LastNode(path_3).getValue().getX(),EPSILON);
        assertEquals(2,LastNode(path_3).getValue().getY(),EPSILON);
//        // Fourth Level:
        Level l4= new TopDownLevel(g4,3,3,"tester_4");
        l4.getPlayerStartLocation().setX(2.0);
        l4.getPlayerStartLocation().setY(2.0);
        Wall w21= new Wall(1,1);
        Wall w22= new Wall(1,2);
        Enemy e4=new Enemy(new Vector2D(8,8));
        LinkedListNode<Vector2D> no_path=findPathAvoidWalls(l4,e4.getLocation(),l4.getPlayerStartLocation());
        assertNull(no_path);

        // Level 5:
        Level l5 = new TopDownLevel(g5, 5, 5, "tester_3");
        l5.getPlayerStartLocation().setX(2.0);
        l5.getPlayerStartLocation().setY(2.0);
        Wall w31= new Wall(3,1);
        Wall w32= new Wall(3,2);
        l5.getStaticObjects().add(w31);
        l5.getStaticObjects().add(w32);
        Enemy e5=new Enemy(new Vector2D(2,3));
        LinkedListNode<Vector2D> path_5=findPathAvoidWalls(l5,e5.getLocation(),l5.getPlayerStartLocation());
        validatePath(path_5);
        assertTrue(size(path_5)==2);
        assertEquals(2,FirstNode(path_5).getValue().getX(),EPSILON);
        assertEquals(3,FirstNode(path_5).getValue().getY(),EPSILON);
        assertEquals(2,LastNode(path_5).getValue().getX(),EPSILON);
        assertEquals(2,LastNode(path_5).getValue().getY(),EPSILON);

        // Level 6:
        Level l6= new TopDownLevel(g6,9,9,"tester_6");
        l6.getPlayerStartLocation().setX(1.0);
        l6.getPlayerStartLocation().setY(1.0);
        Enemy e6=new Enemy(new Vector2D(7,1));
        Wall w54= new Wall(6,4);
        l6.getStaticObjects().add(w54);
        LinkedListNode<Vector2D> path_6=findPathAvoidWalls(l6,e6.getLocation(),l6.getPlayerStartLocation());
        validatePath(path_6);
        assertEquals(7,size(path_6));
        assertEquals(7,FirstNode(path_6).getValue().getX(),EPSILON);
        assertEquals(1,FirstNode(path_6).getValue().getY(),EPSILON);
        assertEquals(1,LastNode(path_6).getValue().getX(),EPSILON);
        assertEquals(1,LastNode(path_6).getValue().getY(),EPSILON);
    }
    @Test
    public void testFindPath() {
        Game g8= new Game();
        Level l=new TopDownLevel(g8,38,38,"User");
        LinkedListNode<Vector2D> path_1 = findPathAvoidWalls(l,new Vector2D(0.5, 0.8), new Vector2D(5, 5));
        LinkedListNode<Vector2D> path_2 = findPathAvoidWalls(l,new Vector2D(18, 13), new Vector2D(12, 27));
        LinkedListNode<Vector2D> path_3 = findPathAvoidWalls(l,new Vector2D(2.8, 3.1), new Vector2D(5.4, 3.2));
        LinkedListNode<Vector2D> path_4 = findPathAvoidWalls(l,new Vector2D(12.7, 13.4), new Vector2D(11.3, 5.8));
        validatePath(path_1);
        validatePath(path_2);
        validatePath(path_3);
        validatePath(path_4);
        assertNull(path_1);
        assertEquals(18,FirstNode(path_2).getValue().getX(),EPSILON);
        assertEquals(13,FirstNode(path_2).getValue().getY(),EPSILON);
        assertEquals(12,LastNode(path_2).getValue().getX(),EPSILON);
        assertEquals(27,LastNode(path_2).getValue().getY(),EPSILON);
        assertTrue(size(path_2)==21);
    }
    @Test
    public void length_1(){
        Game g= new Game();
        Level l= new TopDownLevel(g,10,10,"Stuck");
        l.getPlayerStartLocation().setX(4.0);
        l.getPlayerStartLocation().setY(4.0);
        Wall w81= new Wall(7,3);
        Wall w82= new Wall(7,4);
        l.getStaticObjects().add(w81);
        l.getStaticObjects().add(w82);
        Enemy e80= new Enemy(new Vector2D(4.0,4.0));
        LinkedListNode<Vector2D> see=findPathAvoidWalls(l,e80.getLocation(),l.getPlayerStartLocation());
        assertNotNull(see);
        validatePath(see);
        assertEquals(4.0,FirstNode(see).getValue().getX(),EPSILON);
        assertEquals(4.0,FirstNode(see).getValue().getY(),EPSILON);
        assertEquals(4.0,LastNode(see).getValue().getX(),EPSILON);
        assertEquals(4.0,LastNode(see).getValue().getY(),EPSILON);
        assertTrue(size(see)==1);
    }
    @Test
    public void divide_Level(){
        Game gg= new Game();
        Level no_linker=new TopDownLevel(gg,6,6,"looper");
        no_linker.getPlayerStartLocation().setX(2.0);
        no_linker.getPlayerStartLocation().setY(2.0);
        Wall w91= new Wall(3,1);
        Wall w92= new Wall(3,2);
        Wall w93= new Wall(3,3);
        Wall w94= new Wall(3,4);
        no_linker.getStaticObjects().add(w91);
        no_linker.getStaticObjects().add(w92);
        no_linker.getStaticObjects().add(w93);
        no_linker.getStaticObjects().add(w94);
        Enemy e90= new Enemy(new Vector2D(4,2));
        LinkedListNode<Vector2D> no_connect=findPathAvoidWalls(no_linker,e90.getLocation(),no_linker.getPlayerStartLocation());
        assertNull(no_connect);
    }


}
