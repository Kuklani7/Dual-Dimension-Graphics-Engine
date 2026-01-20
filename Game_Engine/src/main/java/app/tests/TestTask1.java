package app.tests;

import app.gameengine.model.gameobjects.DynamicGameObject;
import app.gameengine.model.gameobjects.GameObject;
import app.gameengine.model.gameobjects.Player;
import app.gameengine.model.physics.Hitbox;
import app.gameengine.model.physics.PhysicsEngine;
import app.gameengine.model.physics.Vector2D;
import app.games.commonobjects.Wall;
import javafx.util.Pair;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TestTask1 {
    static final double EPSILON = 0.0001;

    public void comparePlayers(Player p1, Player p2) {
        assertEquals(p1.getHP(), p2.getHP());
        assertEquals(p1.getMaxHP(), p2.getMaxHP());
        assertEquals(p1.getOrientation().getX(), p2.getOrientation().getX(), EPSILON);
        assertEquals(p1.getOrientation().getY(), p2.getOrientation().getY(), EPSILON);
        assertEquals(p1.getLocation().getX(), p2.getLocation().getX(), EPSILON);
        assertEquals(p1.getLocation().getY(), p2.getLocation().getY(), EPSILON);
        assertEquals(p1.getVelocity().getX(), p2.getVelocity().getX(), EPSILON);
        assertEquals(p1.getVelocity().getY(), p2.getVelocity().getY(), EPSILON);
    }
    @Test
    public void testDynamicGameObject(){
        Player p31=new Player(new Vector2D(21.0,-35.4),25);
        Player p32=new Player(new Vector2D(-18.2,15.7),11);
        Player p33=new Player(new Vector2D(-17.9,-223.0),23);
        Player p34=new Player(new Vector2D(0.0,0.0),7);
        assertEquals(25,p31.getMaxHP());
        assertEquals(11,p32.getMaxHP());
        assertEquals(23,p33.getMaxHP());
        assertEquals(7,p34.getMaxHP());
        assertEquals(25,p31.getHP());
        assertEquals(11,p32.getHP());
        assertEquals(23,p33.getHP());
        assertEquals(7,p34.getHP());
        assertEquals(21.0,p31.getLocation().getX(),EPSILON);
        assertEquals(-35.4,p31.getLocation().getY(),EPSILON);
        assertEquals(-18.2,p32.getLocation().getX(),EPSILON);
        assertEquals(15.7,p32.getLocation().getY(),EPSILON);
        assertEquals(-17.9,p33.getLocation().getX(),EPSILON);
        assertEquals(-223.0,p33.getLocation().getY(),EPSILON);
        assertEquals(0.0,p34.getLocation().getX(),EPSILON);
        assertEquals(0.0,p34.getLocation().getY(),EPSILON);
        assertEquals(0.0,p31.getVelocity().getX(),EPSILON);
        assertEquals(0.0,p31.getVelocity().getY(),EPSILON);
        assertEquals(0.0,p32.getVelocity().getX(),EPSILON);
        assertEquals(0.0,p32.getVelocity().getY(),EPSILON);
        assertEquals(0.0,p33.getVelocity().getX(),EPSILON);
        assertEquals(0.0,p33.getVelocity().getY(),EPSILON);
        assertEquals(0.0,p34.getVelocity().getX(),EPSILON);
        assertEquals(0.0,p34.getVelocity().getY(),EPSILON);
        p31.getVelocity().setX(15.0);
        p31.getVelocity().setY(28.0);
        p32.getVelocity().setX(-84.0);
        p32.getVelocity().setY(11.0);
        p33.getVelocity().setX(14.0);
        p33.getVelocity().setY(-77.0);
        p34.getVelocity().setX(-84.0);
        p34.getVelocity().setY(-47.0);
        assertEquals(15.0,p31.getVelocity().getX(),EPSILON);
        assertEquals(28.0,p31.getVelocity().getY(),EPSILON);
        assertEquals(-84.0,p32.getVelocity().getX(),EPSILON);
        assertEquals(11.0,p32.getVelocity().getY(),EPSILON);
        assertEquals(14.0,p33.getVelocity().getX(),EPSILON);
        assertEquals(-77.0,p33.getVelocity().getY(),EPSILON);
        assertEquals(-84.0,p34.getVelocity().getX(),EPSILON);
        assertEquals(-47.0,p34.getVelocity().getY(),EPSILON);
        assertEquals(0.0,p31.getOrientation().getX(),EPSILON);
        assertEquals(1.0,p31.getOrientation().getY(),EPSILON);
        assertEquals(0.0,p32.getOrientation().getX(),EPSILON);
        assertEquals(1.0,p32.getOrientation().getY(),EPSILON);
        assertEquals(0.0,p33.getOrientation().getX(),EPSILON);
        assertEquals(1.0,p33.getOrientation().getY(),EPSILON);
        assertEquals(0.0,p34.getOrientation().getX(),EPSILON);
        assertEquals(1.0,p34.getOrientation().getY(),EPSILON);
        p31.getOrientation().setX(55.0);
        p31.getOrientation().setY(127.0);
        p32.getOrientation().setX(-45.0);
        p32.getOrientation().setY(88.0);
        p33.getOrientation().setX(23.0);
        p33.getOrientation().setY(-92.0);
        p34.getOrientation().setX(-76.0);
        p34.getOrientation().setY(-222.0);
        assertEquals(55.0,p31.getOrientation().getX(),EPSILON);
        assertEquals(127.0,p31.getOrientation().getY(),EPSILON);
        assertEquals(-45.0,p32.getOrientation().getX(),EPSILON);
        assertEquals(88.0,p32.getOrientation().getY(),EPSILON);
        assertEquals(23.0,p33.getOrientation().getX(),EPSILON);
        assertEquals(-92.0,p33.getOrientation().getY(),EPSILON);
        assertEquals(-76.0,p34.getOrientation().getX(),EPSILON);
        assertEquals(-222.0,p34.getOrientation().getY(),EPSILON);

    }


    @Test
    public void testsetHP(){
        Player p21=new Player(new Vector2D(0,0),25);
        Player p22=new Player(new Vector2D(0,0),20);
        Player p23=new Player(new Vector2D(0,0),15);
        Player p24=new Player(new Vector2D(0,0),5);
        p21.setHP(32);
        p22.setHP(9);
        p23.setHP(48);
        p24.setHP(3);
        assertEquals(25,p21.getHP());
        assertEquals(9,p22.getHP());
        assertEquals(15,p23.getHP());
        assertEquals(3,p24.getHP());

    }


    @Test
    public void testTakeDamage() {
        Player p3 = new Player(new Vector2D(0, 0), 30);
        Player p4 = new Player(new Vector2D(0, 0), 40);
        Player p5 = new Player(new Vector2D(0, 0), 10);
        Player p6 = new Player(new Vector2D(0, 0), -10);
        Player p7 = new Player(new Vector2D(0, 0), 28);
        p3.takeDamage(10);
        assertEquals(20, p3.getHP());
        p4.takeDamage(50);
        assertEquals(-10, p4.getHP());
        p5.takeDamage(-10);
        assertEquals(10, p5.getHP());
        p6.takeDamage(20);
        assertEquals(-30, p6.getHP());
        p7.takeDamage(0);
        assertEquals(28,p7.getHP());
    }

    @Test
    public void testupdateObject() {
        Player p11 = new Player(new Vector2D(10.2, 10.3), 25);
        Player p12 = new Player(new Vector2D(15.4, -15.3), 25);
        Player p13 = new Player(new Vector2D(-14.3, -17.8), 25);
        Player p14 = new Player(new Vector2D(-43.7, 13.2), 25);
        Player p15 = new Player(new Vector2D(-41.7, 18.2), 25);
        p11.getVelocity().setX(10.8);
        p11.getVelocity().setY(-10.2);
        p12.getVelocity().setX(-3.4);
        p12.getVelocity().setY(-3.8);
        p13.getVelocity().setX(6.2);
        p13.getVelocity().setY(-6.8);
        p14.getVelocity().setX(-3.2);
        p14.getVelocity().setY(3.0);
        p15.getVelocity().setX(0);
        p15.getVelocity().setY(0);
        PhysicsEngine eng_1 = new PhysicsEngine();
        eng_1.updateObject(p11, 2);
        eng_1.updateObject(p12, 3);
        eng_1.updateObject(p13, 5);
        eng_1.updateObject(p14, 3);
        eng_1.updateObject(p15,8);
        assertEquals(31.8, p11.getLocation().getX(), EPSILON);
        assertEquals(-10.1, p11.getLocation().getY(), EPSILON);
        assertEquals(5.2, p12.getLocation().getX(), EPSILON);
        assertEquals(-26.7, p12.getLocation().getY(), EPSILON);
        assertEquals(16.7, p13.getLocation().getX(), EPSILON);
        assertEquals(-51.8, p13.getLocation().getY(), EPSILON);
        assertEquals(-53.3, p14.getLocation().getX(), EPSILON);
        assertEquals(22.2, p14.getLocation().getY(), EPSILON);
        assertEquals(-41.7, p15.getLocation().getX(), EPSILON);
        assertEquals(18.2, p15.getLocation().getY(), EPSILON);
    }

    @Test
    public void testdetectCollisions() {
        Hitbox h1 = new Hitbox(new Vector2D(0.5, 0.5), new Vector2D(1.0, 1.0));
        Hitbox h2 = new Hitbox(new Vector2D(1.5, 1.5), new Vector2D(2.2, 2.1));
        Hitbox h3 = new Hitbox(new Vector2D(2.5, 2.5), new Vector2D(1.5, 1.5));
        Hitbox h4 = new Hitbox(new Vector2D(0.5, 2.5), new Vector2D(1.0, 1.0));
        Hitbox h5 = new Hitbox(new Vector2D(2.5, 2.5), new Vector2D(-1.6, -2.8));
        Hitbox h6 = new Hitbox(new Vector2D(-0.5, -0.5), new Vector2D(4.8, 3.2));
        Hitbox h7 = new Hitbox(new Vector2D(9, -1), new Vector2D(6.0, 2.0));
        Hitbox h8 = new Hitbox(new Vector2D(10, 1), new Vector2D(8.0, 12.0));
        Hitbox h9 = new Hitbox(new Vector2D(-5, 4), new Vector2D(5.4, 2.0));
        Hitbox h10 = new Hitbox(new Vector2D(0.4, 4), new Vector2D(2.4, 4.1));
        PhysicsEngine e_1 = new PhysicsEngine();
      boolean a = e_1.detectCollision(h1, h2);
      boolean b = e_1.detectCollision(h3,h2);
      boolean c = e_1.detectCollision(h1, h3);
      boolean d = e_1.detectCollision(h4,h2);
      boolean e = e_1.detectCollision(h2, h5);
      boolean g=e_1.detectCollision(h7,h8);
      boolean h=e_1.detectCollision(h9,h10);
      boolean i=e_1.detectCollision(h1,h8);
      boolean j=e_1.detectCollision(h1,h9);
      assertTrue(a);
      assertTrue(b);
      assertTrue(d);
      assertTrue(e);
      assertTrue(g);
      assertTrue(h);
      assertFalse(i);
      assertFalse(j);

    }

    @Test
    public void testWallCollisionsSimple() {
        // we give you the tests for wall collisions. Don't change them
        //
        // However, you should read through these tests to better understand what you should
        // be testing for and how you should be testing
        Player player = new Player(new Vector2D(0, 0), 10);
        Wall w1 = new Wall(1, 0);
        Wall w2 = new Wall(0, 1);
        Wall w3 = new Wall(-1, 0);
        Wall w4 = new Wall(0, -1);

        // Move right
        player.getLocation().setX(0.5);
        player.getLocation().setY(0);
        w1.collideWithDynamicObject(player);
        assertEquals(0.0, player.getLocation().getX(), EPSILON);
        assertEquals(0.0, player.getLocation().getY(), EPSILON);


        // Move down
        player.getLocation().setX(0);
        player.getLocation().setY(0.5);
        w2.collideWithDynamicObject(player);
        assertEquals(0.0, player.getLocation().getX(), EPSILON);
        assertEquals(0.0, player.getLocation().getY(), EPSILON);

        // Move left
        player.getLocation().setX(-0.5);
        player.getLocation().setY(0);
        w3.collideWithDynamicObject(player);
        assertEquals(0.0, player.getLocation().getX(), EPSILON);
        assertEquals(0.0, player.getLocation().getY(), EPSILON);

        // Move up
        player.getLocation().setX(0);
        player.getLocation().setY(-0.5);
        w4.collideWithDynamicObject(player);
        assertEquals(0.0, player.getLocation().getX(), EPSILON);
        assertEquals(0.0, player.getLocation().getY(), EPSILON);
    }

    @Test
    public void testWallCollisionsComplex() {
        Player player = new Player(new Vector2D(0.0, 0.0), 10);
        Wall w1 = new Wall(5, 2);

        player.getLocation().setX(4.5);
        player.getLocation().setY(1.2);
        w1.collideWithDynamicObject(player);
        assertEquals(4.5, player.getLocation().getX(), EPSILON);
        assertEquals(1.0, player.getLocation().getY(), EPSILON);

        player.getLocation().setX(5.0);
        player.getLocation().setY(1.2);
        w1.collideWithDynamicObject(player);
        assertEquals(5.0, player.getLocation().getX(), EPSILON);
        assertEquals(1.0, player.getLocation().getY(), EPSILON);

        player.getLocation().setX(5.5);
        player.getLocation().setY(1.2);
        w1.collideWithDynamicObject(player);
        assertEquals(5.5, player.getLocation().getX(), EPSILON);
        assertEquals(1.0, player.getLocation().getY(), EPSILON);

        player.getLocation().setX(5.9);
        player.getLocation().setY(1.2);
        w1.collideWithDynamicObject(player);
        assertEquals(6.0, player.getLocation().getX(), EPSILON);
        assertEquals(1.2, player.getLocation().getY(), EPSILON);

        player.getLocation().setX(5.9);
        player.getLocation().setY(1.5);
        w1.collideWithDynamicObject(player);
        assertEquals(6.0, player.getLocation().getX(), EPSILON);
        assertEquals(1.5, player.getLocation().getY(), EPSILON);

        player.getLocation().setX(5.9);
        player.getLocation().setY(2.5);
        w1.collideWithDynamicObject(player);
        assertEquals(6.0, player.getLocation().getX(), EPSILON);
        assertEquals(2.5, player.getLocation().getY(), EPSILON);

        player.getLocation().setX(5.9);
        player.getLocation().setY(2.8);
        w1.collideWithDynamicObject(player);
        assertEquals(6.0, player.getLocation().getX(), EPSILON);
        assertEquals(2.8, player.getLocation().getY(), EPSILON);

        player.getLocation().setX(5.2);
        player.getLocation().setY(2.8);
        w1.collideWithDynamicObject(player);
        assertEquals(5.2, player.getLocation().getX(), EPSILON);
        assertEquals(3.0, player.getLocation().getY(), EPSILON);

        player.getLocation().setX(4.2);
        player.getLocation().setY(2.7);
        w1.collideWithDynamicObject(player);
        assertEquals(4.0, player.getLocation().getX(), EPSILON);
        assertEquals(2.7, player.getLocation().getY(), EPSILON);

        player.getLocation().setX(4.2);
        player.getLocation().setY(2.0);
        w1.collideWithDynamicObject(player);
        assertEquals(4.0, player.getLocation().getX(), EPSILON);
        assertEquals(2.0, player.getLocation().getY(), EPSILON);

        player.getLocation().setX(4.2);
        player.getLocation().setY(1.5);
        w1.collideWithDynamicObject(player);
        assertEquals(4.0, player.getLocation().getX(), EPSILON);
        assertEquals(1.5, player.getLocation().getY(), EPSILON);
    }
}


