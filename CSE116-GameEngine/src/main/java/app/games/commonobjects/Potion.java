package app.games.commonobjects;

import app.gameengine.graphics.SpriteLocation;
import app.gameengine.model.gameobjects.DynamicGameObject;
import app.gameengine.model.physics.Vector2D;

public class Potion extends DynamicGameObject {
    private int heal;
    public Potion(Vector2D location, int heal){
        super(location,10);
        this.heal=heal;
        this.spriteSheetFilename="User Interface/Icons-Essentials.png";
        if(this.heal>=0){
            this.defaultSpriteLocation= new SpriteLocation(0,1);
        }
        else{
            this.defaultSpriteLocation = new SpriteLocation(1,1);
        }
    }
    @Override
    public void collideWithDynamicObject(DynamicGameObject p1){
        if(p1.isPlayer()) {
            p1.setHP(p1.getHP() + this.heal);
            this.destroy();
        }
    }
}
