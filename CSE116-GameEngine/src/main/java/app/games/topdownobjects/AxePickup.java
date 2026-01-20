package app.games.topdownobjects;

import app.gameengine.Level;
import app.gameengine.graphics.SpriteLocation;
import app.gameengine.model.gameobjects.CollectibleGameObject;
import app.gameengine.model.physics.Vector2D;

public class AxePickup extends CollectibleGameObject {
    public AxePickup(Vector2D location){
        super(location,"Axe");
        this.spriteSheetFilename="Objects/Axe.png";
        this.defaultSpriteLocation= new SpriteLocation(0,0);
    }
    PlayerAxeProjectile px= new PlayerAxeProjectile(new Vector2D(2,2));

    public void use(Level l){
        l.getPlayer().fireProjectile(px,5,l);
    }
}
