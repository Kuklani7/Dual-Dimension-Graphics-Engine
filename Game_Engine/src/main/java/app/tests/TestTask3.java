package app.tests;

import app.gameengine.model.gameobjects.Player;
import app.gameengine.model.physics.Vector2D;
import app.games.platformerobjects.PlatformerWall;
import org.junit.Test;
import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;



public class TestTask3 {
    static final double EPSILON = 0.0001;
    @Test
    public void testCollideWithDynamicObject() {
        Player p11 = new Player(new Vector2D(2, 2), 25);
        PlatformerWall w11 = new PlatformerWall(2, 3);
        p11.getVelocity().setY(5.18);
        p11.getDimensions().setX(1);
        p11.getDimensions().setY(1);
        w11.getDimensions().setX(1);
        w11.getDimensions().setY(1);
        w11.collideWithDynamicObject(p11);
        assertEquals(0, p11.getVelocity().getY(), EPSILON);
        assertTrue(p11.isOnGround());
        Player p12=new Player(new Vector2D(5,5),20);
        PlatformerWall w12= new PlatformerWall(5,4);
        p12.getVelocity().setY(15.7);
        p12.getDimensions().setX(1);
        p12.getDimensions().setY(1);
        w12.getDimensions().setX(1);
        w12.getDimensions().setY(1);
        w12.collideWithDynamicObject(p12);
        assertEquals(0, p12.getVelocity().getY(), EPSILON);
        assertFalse(p12.isOnGround());

    }
}
