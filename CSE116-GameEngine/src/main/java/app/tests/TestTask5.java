package app.tests;

import app.gameengine.model.gameobjects.Player;
import app.gameengine.model.physics.Vector2D;
import app.games.topdownobjects.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestTask5 {
    @Test
    public void testaddInventory(){
        Player player= new Player(new Vector2D(-5,-4),25);
        PotionPickup pp1=new PotionPickup(new Vector2D(0,0),5);
        MagicPickup m1=new MagicPickup(new Vector2D(1,1));
        AxePickup a1=new AxePickup(new Vector2D(2,2));
        MagicPickup m2=new MagicPickup(new Vector2D(6,6));
        AxePickup a2=new AxePickup(new Vector2D(7,7));
        MagicPickup m3=new MagicPickup(new Vector2D(8,8));
        player.addInventoryItem(pp1);
        assertEquals("Health Potion",player.getActiveItemID());
        player.addInventoryItem(m1);
        assertEquals("Health Potion",player.getActiveItemID());
        player.addInventoryItem(a1);
        assertEquals("Health Potion",player.getActiveItemID());
        player.addInventoryItem(m2);
        assertEquals("Health Potion",player.getActiveItemID());
        player.addInventoryItem(a2);
        assertEquals("Health Potion",player.getActiveItemID());
        player.addInventoryItem(m3);
        assertEquals("Health Potion",player.getActiveItemID());
        player.cycleInventory();
        assertEquals("Magic",player.getActiveItemID());
        player.cycleInventory();
        assertEquals("Axe",player.getActiveItemID());
        player.cycleInventory();
        assertEquals("Magic",player.getActiveItemID());
        player.cycleInventory();
        assertEquals("Axe",player.getActiveItemID());
        player.cycleInventory();
        assertEquals("Magic",player.getActiveItemID());
        player.cycleInventory();;
        assertEquals("Health Potion",player.getActiveItemID());
    }
    @Test
    public void testremoveActiveItem(){
        Player p11= new Player(new Vector2D(0,0),25);
        PotionPickup pp1=new PotionPickup(new Vector2D(0,0),5);
        MagicPickup m1=new MagicPickup(new Vector2D(1,1));
        AxePickup a1=new AxePickup(new Vector2D(2,2));
        MagicPickup m2=new MagicPickup(new Vector2D(6,6));
        AxePickup a2=new AxePickup(new Vector2D(7,7));
        MagicPickup m3=new MagicPickup(new Vector2D(8,8));
        p11.addInventoryItem(pp1);
        assertEquals("Health Potion",p11.getActiveItemID());
        p11.addInventoryItem(m1);
        p11.addInventoryItem(a1);
        p11.removeActiveItem();
        assertEquals("Magic",p11.getActiveItemID());
        p11.removeActiveItem();
        assertEquals("Axe",p11.getActiveItemID());
        p11.removeActiveItem();
        assertEquals("No item equipped",p11.getActiveItemID());
        p11.addInventoryItem(a1);
        p11.addInventoryItem(m1);
        p11.addInventoryItem(pp1);
        p11.cycleInventory();
        p11.cycleInventory();
        p11.removeActiveItem();
        assertEquals("Axe",p11.getActiveItemID());
        p11.removeActiveItem();
        assertEquals("Magic",p11.getActiveItemID());
        p11.removeActiveItem();
        assertEquals("No item equipped",p11.getActiveItemID());
        p11.addInventoryItem(pp1);
        assertEquals("Health Potion",p11.getActiveItemID());
        p11.addInventoryItem(m1);
        p11.addInventoryItem(a1);
        p11.addInventoryItem(m2);
        p11.addInventoryItem(a2);
        p11.addInventoryItem(m3);
        p11.cycleInventory();
        p11.cycleInventory();
        p11.cycleInventory();
        p11.removeActiveItem();
        assertEquals("Axe",p11.getActiveItemID());
        p11.cycleInventory();
        p11.removeActiveItem();
        assertEquals("Health Potion",p11.getActiveItemID());
    }
}
