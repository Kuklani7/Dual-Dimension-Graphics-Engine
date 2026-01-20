package app.games.topdownobjects;

import app.gameengine.Level;
import app.gameengine.graphics.SpriteLocation;
import app.gameengine.model.gameobjects.CollectibleGameObject;
import app.gameengine.model.physics.Vector2D;

public class PotionPickup extends CollectibleGameObject {
    private int heal;
    public PotionPickup(Vector2D location, int heal){
        super(location,"Health Potion");
        this.spriteSheetFilename="User Interface/Icons-Essentials.png";
        this.defaultSpriteLocation=new SpriteLocation(3,1);
        this.heal=heal;
    }
    @Override
    public void use(Level l){
        l.getPlayer().setHP(l.getPlayer().getHP()+this.heal);
        l.getPlayer().removeActiveItem();
    }
}
