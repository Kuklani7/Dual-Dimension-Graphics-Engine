package app.gameengine.model.ai;
import static java.lang.Math.abs;
import static java.lang.Math.floor;

import app.gameengine.Level;
import app.gameengine.model.datastructures.LinkedListNode;
import app.gameengine.model.datastructures.Queue;
import app.gameengine.model.gameobjects.StaticGameObject;
import app.gameengine.model.physics.Vector2D;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Pathfinding {
    static final double EPSILON = 0.0001;


    public static LinkedListNode<Vector2D> findPath(Vector2D v1, Vector2D v2) {
        double x1_ordinate = Math.floor(v1.getX());
        double y1_ordinate = Math.floor(v1.getY());
        double x2_ordinate = Math.floor(v2.getX());
        double y2_ordinate = Math.floor(v2.getY());
        if (x1_ordinate != x2_ordinate || y1_ordinate != y2_ordinate) {
            LinkedListNode<Vector2D> LL = new LinkedListNode<>(new Vector2D(x1_ordinate, y1_ordinate), null);

            if (x1_ordinate > x2_ordinate) {
                for (double w = x1_ordinate - 1; x1_ordinate > x2_ordinate; w--) {
                    LL.append(new Vector2D(w, y1_ordinate));
                    x1_ordinate -= 1;
                }
            }
            if (x1_ordinate < x2_ordinate) {
                for (double z = x1_ordinate + 1; x1_ordinate < x2_ordinate; z++) {
                    LL.append(new Vector2D(z, y1_ordinate));
                    x1_ordinate += 1;
                }
            }
            if (y1_ordinate > y2_ordinate) {
                for (double p = y1_ordinate - 1; y1_ordinate > y2_ordinate; p--) {
                    LL.append(new Vector2D(x1_ordinate, p));
                    y1_ordinate -= 1;
                }
            }
            if (y1_ordinate < y2_ordinate) {
                for (double q = y1_ordinate + 1; y1_ordinate < y2_ordinate; q++) {
                    LL.append(new Vector2D(x1_ordinate, q));
                    y1_ordinate += 1;
                }
            }
            return LL;
        } else {
            LinkedListNode<Vector2D> LL = null;
            return LL;
        }

    }

//    public static LinkedListNode<Vector2D> findPathAvoidWalls(Level l, Vector2D start, Vector2D end) {
//        double x1_ordinate = Math.floor(start.getX());
//        double y1_ordinate = Math.floor(start.getY());
//        double x2_ordinate = Math.floor(end.getX());
//        double y2_ordinate = Math.floor(end.getY());
//        Vector2D check1 = new Vector2D(x1_ordinate, y1_ordinate);
//        Vector2D check2 = new Vector2D(x2_ordinate, y2_ordinate);
//        int width = l.getWidth();
//        int height = l.getHeight();
//        boolean a = start.getX() > width || start.getX() < 0;
//        boolean b = start.getY() > height || start.getY() < 0;
//        boolean c = end.getX() > width || end.getX() < 0;
//        boolean d = end.getY() > height || end.getY() < 0;
//        Set<Vector2D> setter = new HashSet<>();
//        ArrayList<StaticGameObject> store = l.getStaticObjects();
//        for (StaticGameObject z : store) {
//            double x1 = Math.floor(z.getLocation().getX());
//            double y1 = Math.floor(z.getLocation().getY());
//            setter.add(new Vector2D(x1, y1));
//        }
//        boolean e = setter.contains(check1);
//        boolean f = setter.contains(check2);
//        if (a || b || c || d || e || f) {
//            return null;
//        }
//        Queue<Vector2D> discover= new Queue<>();
//        discover.enqueue(check2);
//        Set<Vector2D> already_discovered=new HashSet<>();
//        already_discovered.add(check2);
//        HashMap<Vector2D,Vector2D> mapper= new HashMap<>();
//        mapper.put(end,null);
//        while(discover.getFront()!=null){
//            Vector2D worker=discover.dequeue();
//            double x_plus=worker.getX()+1;
//            double x_minus=worker.getX()-1;
//            double y_plus=worker.getY()+1;
//            double y_minus=worker.getY()-1;
//            Vector2D potent1=new Vector2D(x_plus,worker.getY());
//            Vector2D potent2= new Vector2D(x_minus,worker.getY());
//            Vector2D potent3= new Vector2D(worker.getX(),y_plus);
//            Vector2D potent4= new Vector2D(worker.getX(),y_minus);
//            if((!setter.contains(potent1)) && (!already_discovered.contains(potent1))){
//                discover.enqueue(potent1);
//                already_discovered.add(potent1);
//                mapper.put(potent1,worker);
//            }
//            if((!setter.contains(potent2)) && (!already_discovered.contains(potent2))){
//                discover.enqueue(potent2);
//                already_discovered.add(potent2);
//                mapper.put(potent2,worker);
//            }
//            if((!setter.contains(potent3)) && (!already_discovered.contains(potent3))){
//                discover.enqueue(potent3);
//                already_discovered.add(potent3);
//                mapper.put(potent3,worker);
//            }
//            if((!setter.contains(potent4)) && (!already_discovered.contains(potent4))){
//                discover.enqueue(potent4);
//                already_discovered.add(potent4);
//                mapper.put(potent4,worker);
//            }
//        }
//        LinkedListNode<Vector2D> transformer= new LinkedListNode<>(check1,null);
//        if(!(mapper.keySet().contains(check1))){
//            return null;
//        }
//        Vector2D flag= mapper.get(check1);
//        while(flag!=null){
//            LinkedListNode<Vector2D> add= new LinkedListNode<>(flag,null);
//            transformer.append(add);
//            flag=mapper.get(flag);
//        }
//        return transformer;
//   }
    public static LinkedListNode<Vector2D> findPathAvoidWalls(Level l, Vector2D start, Vector2D end) {
        double x1_ordinate = Math.floor(start.getX());
        double y1_ordinate = Math.floor(start.getY());
        double x2_ordinate = Math.floor(end.getX());
        double y2_ordinate = Math.floor(end.getY());
        Vector2D check1 = new Vector2D(x1_ordinate, y1_ordinate);
        Vector2D check2 = new Vector2D(x2_ordinate, y2_ordinate);
        int width = l.getWidth();
        int height = l.getHeight();
        boolean a = start.getX() > width || start.getX() < 0;
        boolean b = start.getY() > height || start.getY() < 0;
        boolean c = end.getX() > width || end.getX() < 0;
        boolean d = end.getY() > height || end.getY() < 0;
        Set<Vector2D> setter = new HashSet<>();
        ArrayList<StaticGameObject> store = l.getStaticObjects();
        for (StaticGameObject z : store) {
            double x1 = Math.floor(z.getLocation().getX());
            double y1 = Math.floor(z.getLocation().getY());
            setter.add(new Vector2D(x1, y1));
        }
        boolean e = setter.contains(check1);
        boolean f = setter.contains(check2);
        if (a || b || c || d || e || f) {
            return null;
        }
        Queue<Vector2D> discover= new Queue<>();
        discover.enqueue(check2);
        Set<Vector2D> already_discovered=new HashSet<>();
        already_discovered.add(check2);
        HashMap<Vector2D,Vector2D> mapper= new HashMap<>();
        mapper.put(end,null);
        while(discover.getFront()!=null){
            Vector2D worker=discover.dequeue();
            double x_plus=worker.getX()+1;
            double x_minus=worker.getX()-1;
            double y_plus=worker.getY()+1;
            double y_minus=worker.getY()-1;
            // Chec for bounds for each one of them as well:
            Vector2D potent1=new Vector2D(x_plus,worker.getY());
            Vector2D potent2= new Vector2D(x_minus,worker.getY());
            Vector2D potent3= new Vector2D(worker.getX(),y_plus);
            Vector2D potent4= new Vector2D(worker.getX(),y_minus);
            boolean looper_1=(potent1.getX()<=0 || potent1.getX()>=l.getWidth());
            boolean looper_2=(potent1.getY()<=0 || potent1.getY()>=l.getHeight());
            boolean looper_3=(potent2.getX()<=0 || potent2.getX()>=l.getWidth());
            boolean looper_4=(potent2.getY()<=0 || potent2.getY()>=l.getHeight());
            boolean looper_5=(potent3.getX()<=0 || potent3.getX()>=l.getWidth());
            boolean looper_6=(potent3.getY()<=0 || potent3.getY()>=l.getHeight());
            boolean looper_7=(potent4.getX()<=0 || potent4.getX()>=l.getWidth());
            boolean looper_8=(potent4.getY()<=0 || potent4.getY()>=l.getHeight());
            boolean loop_breaker_1=looper_1 || looper_2;
            boolean loop_breaker_2=looper_3 || looper_4;
            boolean loop_breaker_3=looper_5 || looper_6;
            boolean loop_breaker_4=looper_7 || looper_8;
            if(((!setter.contains(potent1)) && (!already_discovered.contains(potent1))) && (!loop_breaker_1)){
                discover.enqueue(potent1);
                already_discovered.add(potent1);
                mapper.put(potent1,worker);
            }
            if(((!setter.contains(potent2)) && (!already_discovered.contains(potent2))) && (!loop_breaker_2)){
                discover.enqueue(potent2);
                already_discovered.add(potent2);
                mapper.put(potent2,worker);
            }
            if(((!setter.contains(potent3)) && (!already_discovered.contains(potent3))) && (!loop_breaker_3)){
                discover.enqueue(potent3);
                already_discovered.add(potent3);
                mapper.put(potent3,worker);
            }
            if(((!setter.contains(potent4)) && (!already_discovered.contains(potent4))) && (!loop_breaker_4)){
                discover.enqueue(potent4);
                already_discovered.add(potent4);
                mapper.put(potent4,worker);
            }
        }
        LinkedListNode<Vector2D> transformer= new LinkedListNode<>(check1,null);
        if(!(mapper.containsKey(check1))){
            return null;
        }
        Vector2D flag= mapper.get(check1);
        while(flag!=null){
            LinkedListNode<Vector2D> add= new LinkedListNode<>(flag,null);
            transformer.append(add);
            flag=mapper.get(flag);
        }
        return transformer;
    }
}



