package app.games.topdownobjects;

import app.gameengine.Level;
import app.gameengine.graphics.SpriteLocation;
import app.gameengine.model.gameobjects.CollectibleGameObject;
import app.gameengine.model.physics.Vector2D;

public class MagicPickup extends CollectibleGameObject {

    public MagicPickup(Vector2D location){
        super(location,"Magic");
        this.spriteSheetFilename="User Interface/Icons-Essentials.png";
        this.defaultSpriteLocation= new SpriteLocation(1,0);
    }
    PlayerMagicProjectile pm= new PlayerMagicProjectile(new Vector2D(3,3));
    @Override
    public void use(Level l){
        l.getPlayer().fireProjectile(pm,10,l);
    }
}
